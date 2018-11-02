package com.producer.mapper;

import com.producer.entity.Order;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * @Auther: shuaihu.shen@hand-china.com
 * @Date: 2018/11/1 15:14
 * @Description:
 */

public interface OrderMapper {

   void insertOrder(Order order);

}
