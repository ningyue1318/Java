package com.syn;

import org.junit.jupiter.api.*;
import org.springframework.test.annotation.Repeat;

import java.util.concurrent.TimeUnit;

public class Junit5Test {

    @DisplayName("测试displayname注解")
    @Test
    void testDisplayName() throws InterruptedException {
        Assertions.assertEquals(5,2+2,"业务计算失败");
    }

    @BeforeEach
    void testBeforeEach(){
        System.out.println("准备开始测试");
    }

    @AfterEach
    void testAfterEach(){
        System.out.println("测试结束了");
    }
}
