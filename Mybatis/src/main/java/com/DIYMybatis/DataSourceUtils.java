package com.DIYMybatis;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;

public class DataSourceUtils {
    public static Connection getConnection(Configuration cfg){
        try {
            Class.forName(cfg.getDriver());
            return DriverManager.getConnection(cfg.getUrl(), cfg.getUsername(), cfg.getPassword());
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
