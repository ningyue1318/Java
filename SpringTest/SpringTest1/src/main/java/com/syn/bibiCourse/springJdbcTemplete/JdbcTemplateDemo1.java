package com.syn.bibiCourse.springJdbcTemplete;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class JdbcTemplateDemo1 {
    public static void main(String[] args) {
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/learn");
        ds.setUsername("root");
        ds.setPassword("123456");


        JdbcTemplate jt = new JdbcTemplate();
        jt.setDataSource(ds);
        jt.execute("insert into team(team_id,team_name) values (1005,'火箭队伍')");

    }
}
