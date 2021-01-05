package com.syn.news.Dao;

import com.syn.news.Model.News;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface NewsDao {

    @Insert("insert into news(title,link,image,like_count,comment_count,created_date,user_id) " +
            "values (#{title},#{link},#{image},#{likeCount},#{commentCount},#{createdDate},#{userId})")
    int addNews(News news);

    List<News> selectByUserIdAndOffSet(@Param("userId") int userId,
                                       @Param("offset") int set,
                                       @Param("limit") int limit);
}
