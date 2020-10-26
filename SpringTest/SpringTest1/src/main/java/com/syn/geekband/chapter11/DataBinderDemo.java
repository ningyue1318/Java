package com.syn.geekband.chapter11;

import com.syn.geekband.chapterbefore3.User;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.PropertyValues;
import org.springframework.validation.DataBinder;

import java.util.HashMap;
import java.util.Map;

public class DataBinderDemo {
    public static void main(String[] args) {
        User user = new User();
        DataBinder dataBinder = new DataBinder(user,"");

        Map<String, Object>  source = new HashMap<>();
        source.put("id",1);
        source.put("name","小马哥");
        //DataBinder忽略未知的属性
        source.put("age",18);
        source.put("company.name","极客时间");
        PropertyValues propertyValues = new MutablePropertyValues(source);

        dataBinder.bind(propertyValues);

        System.out.println(user);
    }
}
