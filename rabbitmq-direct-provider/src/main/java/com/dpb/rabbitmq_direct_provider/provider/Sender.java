package com.dpb.rabbitmq_direct_provider.provider;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @program: rabbitmq-direct-provider
 * @description: 发送者
 * @author: 波波烤鸭
 * @create: 2019-05-22 15:51
 */
@Component
public class Sender {
    @Autowired
    private AmqpTemplate rabbitAmqpTemplate;
    //exchange 交换器名称
    @Value("${mq.config.exchange}")
    private String exchange;

    //routingkey 路由键
    @Value("${mq.config.queue.error.routing.key}")
    private String routingkey;

    /*
     * 发送消息的方法
     */
    public void send(String msg){
        //向消息队列发送消息
        //参数一：交换器名称。
        //参数二：路由键
        //参数三：消息
        this.rabbitAmqpTemplate.convertAndSend(this.exchange,routingkey, msg);
    }
}
