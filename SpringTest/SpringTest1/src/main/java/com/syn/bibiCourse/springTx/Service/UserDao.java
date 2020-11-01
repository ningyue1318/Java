package com.syn.bibiCourse.springTx.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao implements IUser{

    @Autowired
    private JdbcTemplate template;

    @Override
    public void save() {
        String sql = "insert into team(team_id,team_name) values (1010,'火箭队伍')";
        template.update(sql);
    }
}
