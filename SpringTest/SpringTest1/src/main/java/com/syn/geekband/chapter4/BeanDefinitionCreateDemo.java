package com.syn.geekband.chapter4;

import com.syn.geekband.chapterbefore3.User;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.GenericBeanDefinition;

public class BeanDefinitionCreateDemo {
    public static void main(String[] args) {
        //1.通过BeanDefinitionBuilder构建
        User user = null;
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(User.class);
        BeanDefinition beanDefinition = beanDefinitionBuilder
                .addPropertyValue("name","小马哥")
                .addPropertyValue("id","1")
                .getBeanDefinition();

        //2.通过AbstractBeanDefinition及派生类
        GenericBeanDefinition genericBeanDefinition = new GenericBeanDefinition();
        genericBeanDefinition.setBeanClass(User.class);
        //通过MutablePropertyValues 批量操作属性
        MutablePropertyValues propertyValues = new MutablePropertyValues();
        propertyValues.add("id",1)
                .add("name","小马哥");




    }
}
