package com.syn.news.Dao;

import com.syn.news.Model.Comment;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CommentDao {

    @Insert("insert into comment (user_id,content,created_date,entity_id,entity_type,status) values(#{userId},#{content},#{createdDate},#{entityId},#{entityType},#{status})")
    int addComment(Comment comment);


    @Select("select user_id,content,created_date,entity_id,entity_id,entity_type from comment where entity_id=#{entityId} and entity_type=#{entityType} order by id desc")
    List<Comment> selectByEntity(@Param("entityId") int entityId,@Param("entityType") int entityType);


    @Select("select count(id) from comment where entity_id=#{entityId} and entity_type=#{entityType}")
    int getCommentCount(@Param("entityId") int entityId,@Param("entityType") int entityType);

}
