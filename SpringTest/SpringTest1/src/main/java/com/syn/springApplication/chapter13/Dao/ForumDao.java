package com.syn.springApplication.chapter13.Dao;

import com.syn.springApplication.chapter13.domain.Forum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import org.springframework.validation.ObjectError;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ForumDao {
    private JdbcTemplate jdbcTemplate;

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Autowired
    public void setDataSource(DataSource dataSource){
        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }
    public void addForum(Forum forum){
        String sql = "INSERT INTO t_forum(forum_name,forum_desc) VALUES(?,?)";
        Object [] params = new Object[]{forum.getForumName(),forum.getForumDesc()};
        jdbcTemplate.update(sql,params);
    }

    public void Test(){
        List<Actor> actors = new ArrayList<>();
        actors.add(new Actor(2L,"f2","l2"));
        actors.add(new Actor(3L,"f2","l2"));
        actors.add(new Actor(4L,"f2","l2"));
        List<Object[]> batch = new ArrayList<Object[]>();
        for(Actor actor:actors){
            Object[] values = new Object[]{
                    actor.getId(),
                    actor.getFirstName(),
                    actor.getLastName(),
            };
            batch.add(values);
        }

        jdbcTemplate.batchUpdate("insert into Actor(id,firstName,lastName) values (?,?,?)",batch);
    }

}
