package com.syn.geekband.chapter9;

import com.syn.geekband.chapterbefore3.User;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;

public class UserHolder implements BeanNameAware, BeanFactoryAware, BeanClassLoaderAware {
    private final User user;

    private Integer number;

    private ClassLoader classLoader;

    private BeanFactory beanFactory;

    private String beanName;

    public UserHolder(User user) {
        this.user = user;
    }

    private String description;

    public User getUser() {
        return user;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        this.classLoader = classLoader;
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }

    @Override
    public void setBeanName(String name) {
        this.beanName = name;
    }

    @Override
    public String toString() {
        return "UserHolder{" +
                "number=" + number +
                ", beanName='" + beanName + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
