package com.syn;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class Test1 {

    @DisplayName("参数化测试")
    @ValueSource(ints = {1,2,3,4,5})
    @ParameterizedTest
    void testParameterized(int i){
        System.out.println(i);
    }
}
