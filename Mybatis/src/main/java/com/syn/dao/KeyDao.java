package com.syn.dao;

import com.syn.bean.Key;
import com.syn.bean.Lock;


public interface KeyDao {
    public Key getKeyById(Integer id);

    public Lock getLockById(Integer id);

    public Lock getLockByIdSimple(Integer id);

    public Key getKeyByIdSimple(Integer id);

}
