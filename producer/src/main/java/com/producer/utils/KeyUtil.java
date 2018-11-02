package com.producer.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

/**
 * @Auther: shuaihu.shen@hand-china.com
 * @Date: 2018/10/11 14:42
 * @Description:
 */
public class KeyUtil {

    public static synchronized String genUniqueKey(){
        Random random = new Random();
        Integer number = random.nextInt(900000) + 100000;

        return System.currentTimeMillis() + String.valueOf(number);
    }

    public static synchronized String genUniqueKeyOrderId(){
        Random random = new Random();
        Integer number = random.nextInt(9000) + 1000;
        SimpleDateFormat sdf =   new SimpleDateFormat( "yyyy-MM-dd HH-mm" );
        return sdf.format(new Date()) + String.valueOf(number);
    }

    /**
     * 随机生成 MessageId
     * @return
     */
    public static synchronized String genUniqueKeyMessageId(){
        return System.currentTimeMillis() + "$" + UUID.randomUUID().toString();
    }


    public static void main(String[] args) {
        System.out.println( KeyUtil.genUniqueKey());
    }
}
