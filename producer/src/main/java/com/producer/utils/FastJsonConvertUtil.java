package com.producer.utils;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.producer.entity.Order;

import java.io.IOException;

/**
 * @Auther: shuaihu.shen@hand-china.com
 * @Date: 2018/11/1 15:54
 * @Description:
 */
public class FastJsonConvertUtil {

    static ObjectMapper mapper = new ObjectMapper();


    /**
     *  JSON 转 实体类
     * @param json
     * @param object
     * @return
     */
   public static Object convertJSONToObject (String json , Class<Order> object) {
       Object order = new Object();
       try {
           //JSON.toJavaObject((JSON)json,object);
             order =   mapper.readValue(json, object);
       } catch (IOException e) {
           e.printStackTrace();
       }
       return  order;
   }

    /**
     * 实体类转JSON
     * @param object
     * @return
     */
    public static String convertObjectToJSON (Object object) {

        //Convert object to JSON string
        try {
            String text = JSON.toJSONString(object);
            return text;
        } catch (Exception e){
            return null;
        }
       /* String jsonInString = mapper.writeValueAsString(object);

        //Convert object to JSON string and pretty print
        jsonInString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(object);
        System.out.println(jsonInString);
        return jsonInString;*/
    }
}
