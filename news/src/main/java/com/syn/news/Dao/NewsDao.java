package com.syn.news.Dao;

import com.syn.news.Model.News;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface NewsDao {

    @Insert("insert into news(title,link,image,like_count,comment_count,created_date,user_id) " +
            "values (#{title},#{link},#{image},#{likeCount},#{commentCount},#{createdDate},#{userId})")
    int addNews(News news);


    List<News> selectByUserIdAndOffSet(@Param("userId") int userId,
                                       @Param("offset") int set,
                                       @Param("limit") int limit);

    @Select("select id,title,link,image,like_count,comment_count,created_date,user_id from news where id=#{id}")
    News getById(int id);


    @Update({"update news set comment_count = #{commentCount} where id=#{id}"})
    int updateCommentCount(@Param("id") int id, @Param("commentCount") int commentCount);

    @Update({"update news set like_count = #{likeCount} where id=#{id}"})
    int updateLikeCount(@Param("id") int id, @Param("likeCount") int likeCount);
}
