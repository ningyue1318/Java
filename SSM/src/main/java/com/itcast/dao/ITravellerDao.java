package com.itcast.dao;

import com.itcast.domain.Traveller;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ITravellerDao {

    @Select("select * from traveller where id in (select travellerId from order_traveller where orderId = #{orderId})")
    public List<Traveller> findByOrdersId(Integer orderId);
}
