package com.producer;

import com.producer.entity.Order;
import com.producer.service.OrderService;
import com.producer.service.RabbitOrderSender;
import org.junit.Test;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.UUID;

/**
 * @Auther: shuaihu.shen@hand-china.com
 * @Date: 2018/10/17 16:27
 * @Description:  发送消息队列
 */
public class MqReceiverTest extends ProducerApplicationTests {

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private OrderService orderService;

    @Autowired
    private RabbitOrderSender rabbitOrderSender;

    @Test
    public void orderSend() {
        // String exchange, String routingKey, Object object computer
        amqpTemplate.convertAndSend(
                "order-exchange",
                "order.fruit",
                "exchange is orderQueue routingKey is fruit now is "+new Date()
                 );

    }

    @Test
    public void orderSend2() {
        // String exchange, String routingKey, Object object computer
        CorrelationData correlationData = new CorrelationData();
        correlationData.setId("132");
        rabbitTemplate.convertAndSend(
                "order-exchange",
                "order.computer",
                "exchange is orderQueue routingKey is computer now is "+new Date()
                , correlationData);

    }



    //
    // @Test
    // public void testSender2() throws Exception {
    //     Order order = new Order();
    //     order.setId("2018110200000777");
    //     order.setName("水果订单");
    //     order.setMessageId(System.currentTimeMillis() + "$" + UUID.randomUUID().toString());
    //     rabbitOrderSender.sendOrder(order);
    // }



    @Test
    public void testCreateOrder() throws Exception {
        Order order = new Order();
        order.setId("2018110200000008");
        order.setName("测试创建订单");
        order.setMessageId(System.currentTimeMillis() + "$" + UUID.randomUUID().toString());
        orderService.createOrder(order);
    }


}