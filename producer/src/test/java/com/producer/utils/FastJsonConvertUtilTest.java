package com.producer.utils;

import com.producer.ProducerApplicationTests;
import com.producer.entity.Order;
import org.junit.Test;

import java.io.IOException;

/**
 * @Auther: shuaihu.shen@hand-china.com
 * @Date: 2018/11/1 16:32
 * @Description:
 */
public class FastJsonConvertUtilTest extends ProducerApplicationTests {

    @Test
    public void convertJSONToObject() throws IOException {
        Order order = new Order("2018","threecat","1234567");
      String json =  FastJsonConvertUtil.convertObjectToJSON(order);
        System.out.println(json);
    }

    @Test
    public void convertObjectToJSON() {
        String json = "{\"id\":\"2018\",\"name\":\"threecat\",\"messageId\":\"1234567\"}";
        Order order = (Order) FastJsonConvertUtil.convertJSONToObject(json,Order.class);
        System.out.println(order.toString());
    }
}