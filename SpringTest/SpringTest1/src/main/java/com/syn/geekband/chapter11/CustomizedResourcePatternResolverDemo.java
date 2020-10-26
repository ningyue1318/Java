package com.syn.geekband.chapter11;

import org.springframework.core.io.FileSystemResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import java.io.IOException;

public class CustomizedResourcePatternResolverDemo {
    public static void main(String[] args) throws IOException {
        String currentPackagePath = System.getProperty("user.dir")+"src/main/java/com/syn/geekband/chapter11";
        System.out.println(currentPackagePath);
        String locationPattern = currentPackagePath +"*.java";
        PathMatchingResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver(new FileSystemResourceLoader());
        Resource [] resources = resourcePatternResolver.getResources(locationPattern);

    }
}
