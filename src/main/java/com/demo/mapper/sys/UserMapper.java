package com.demo.mapper.sys;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.demo.entity.sys.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper extends BaseMapper<User> {
    void saveUser(User user);

    void delUser(String userId);

    void updateUser(@Param("entity") User user);

    List<User> listPage(Page<User> page, @Param("entity") User user);

    User getUserOfAccount(String accountId);
}
