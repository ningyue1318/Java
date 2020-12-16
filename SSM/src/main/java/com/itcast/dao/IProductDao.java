package com.itcast.dao;

import com.itcast.domain.Product;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface IProductDao {

    @Select("select * from product")
    public List<Product> findAll() throws Exception;

    @Insert("insert into " +
            "product(productNum,productName,cityName,DepartureTime,productPrice,productDesc,productStatus) " +
            "values(#{productNum},#{productName},#{cityName},#{departureTime},#{productPrice},#{productDesc},#{productStatus})")
    void save(Product product) throws Exception;

    @Select("select * from product where id =#{id}")
    public Product findById(Integer id) throws Exception;
}
