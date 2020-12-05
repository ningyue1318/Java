package com.syn.dao;

import com.syn.bean.Employee;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface EmployeeDao {
    @MapKey("id")
    public Map<Integer,Object> getAllEmps();
    public Employee getEmpById(Integer id);
    public Employee getEmpByIdAndEmpName(@Param("id") Integer id, @Param("empName") String empName);
    public int updateEmployee(Employee employee);
    public int deleteEmployee(Integer id);
    public int insertEmployee(Employee employee);
    public int insertEmployee2(Employee employee);
    public Map<String,Object> getEmpByIdReturnMap(Integer id);
}
