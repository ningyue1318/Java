package com.syn.springApplication.chapter12;

public interface FooService {
    Foo getFoo(String fooName);
    Foo getFoo(String fooName,String barName);
    void insertFoo(Foo foo);
    void updateFoo(Foo foo);
}