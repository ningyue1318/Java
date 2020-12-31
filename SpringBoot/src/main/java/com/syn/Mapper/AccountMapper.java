package com.syn.Mapper;

import com.syn.bean.Account;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
public interface AccountMapper {

    public Account getAccount(int id);
}
