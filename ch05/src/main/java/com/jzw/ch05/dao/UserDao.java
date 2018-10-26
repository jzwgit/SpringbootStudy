package com.jzw.ch05.dao;

import com.jzw.ch05.entity.User;
import org.beetl.sql.core.annotatoin.SqlResource;
import org.beetl.sql.core.mapper.BaseMapper;

import java.util.List;

@SqlResource("www.user")
public interface UserDao extends BaseMapper<User> {
    public List<User> selectSample(User query);
}
