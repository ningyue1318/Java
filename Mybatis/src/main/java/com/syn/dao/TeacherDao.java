package com.syn.dao;

import com.syn.bean.Teacher;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TeacherDao {


    public Teacher getTeacherById(Integer id);

    public List<Teacher> getTeacherByCondition(Teacher teacher);

    public List<Teacher> getTeacherByIdIn(@Param("ids") List<Integer> ids);

    public int updateTeacher(Teacher teacher);

}
