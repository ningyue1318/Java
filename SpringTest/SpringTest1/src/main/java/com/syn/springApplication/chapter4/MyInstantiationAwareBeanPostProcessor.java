package com.syn.springApplication.chapter4;

import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessorAdapter;
/*
总结InstantiationAwareBeanPostProcessor方法:
postProcessBeforeInstantiation()在bean实例化前回调,返回实例则不对bean实例化,返回null则进行spring bean实例化(doCreateBean);
postProcessAfterInstantiation()在bean实例化后在填充bean属性之前回调,返回true则进行下一步的属性填充,返回false:则不进行属性填充
postProcessProperties在属性赋值前的回调在applyPropertyValues之前操作可以对属性添加或修改等操作最后在通过applyPropertyValues应用bean对应的wapper对象
 */

public class MyInstantiationAwareBeanPostProcessor extends InstantiationAwareBeanPostProcessorAdapter {

    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        if("car".equals(beanName)){
            System.out.println("v1-InstantiationAware BeanPostProcessor.postProcessBeforeInstantiation");
        }
        return null;
    }

    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        if("car".equals(beanName)){
            System.out.println("v3-InstantiationAware BeanPostProcessor.postProcessAfterInstantiation");
        }
        return true;
    }

    @Override
    public PropertyValues postProcessProperties(PropertyValues pvs, Object bean, String beanName) throws BeansException {
        if("car".equals(beanName)){
            System.out.println("v4-InstantiationAware BeanPostProcessor.postProcessPropertyValues");
            //在这里pvs获取的是xml文件中定义的属性值，如果需要修改属性值在这个方法里修改。然后调用set方法注入到对象里
            MutablePropertyValues propertyValues = new MutablePropertyValues();
            propertyValues.addPropertyValue("brand","qwe");
            return  propertyValues;
        }
        return pvs;
    }
}
