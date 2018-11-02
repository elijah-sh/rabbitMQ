package com.consumer.message;

import com.consumer.entity.Order;
import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @Auther: shuaihu.shen@hand-china.com
 * @Date: 2018/10/17 16:24
 * @Description:  接受消息内容
 */
@Component
@Slf4j
public class MqReceiver {

    /**
     *  消息  接收
     * @param order
     */
   @RabbitListener(  bindings = @QueueBinding(
            value = @Queue(value = "order-queue",durable = "true"),
            key = "order.*",
            exchange = @Exchange(value = "order-exchange",type = "topic")
            ) )
    @RabbitHandler
    public void orderProcess (@Payload String order,
                             @Headers Map<String,Object> headers ,
                             Channel channel ) throws Exception{
           // 消费者操作
           System.err.println("============收到消息开始消费=========");
        log.info("Receiver order Message :  {}",order);
        long l = (long) headers.get(AmqpHeaders.DELIVERY_TAG);

         //  ACK   自动签收 与配置呼应
          channel.basicAck(l,false); //  收到消息之后进行回复
    }

}
