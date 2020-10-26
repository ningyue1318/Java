package com.syn.bibiCourse.springJdbcTemplete;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class JdbcTemplateDemo2 {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("META-INF/chapter3.xml");

        JdbcTemplate jt = (JdbcTemplate) ac.getBean("jdbcTemplate");
        List<Team> result = jt.query("select * from team where team_id >?",new TeamRowMapper(),1002);
        for(Team account : result){
            System.out.println(account);
        }
    }
}

class TeamRowMapper implements RowMapper<Team>{

    @Override
    public Team mapRow(ResultSet resultSet, int i) throws SQLException {
        Team account = new Team();
        account.setId(resultSet.getInt("team_id"));
        account.setName(resultSet.getString("team_name"));
        return account;
    }
}
