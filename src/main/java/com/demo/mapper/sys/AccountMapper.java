package com.demo.mapper.sys;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.demo.entity.sys.Account;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AccountMapper extends BaseMapper<Account> {

    void delAccount(String id);

    void updatePwd(@Param("entity") Account account);

    Account login(@Param("entity") Account account);

    Account getAccount(String account);

    List<Account> listPage(Page<Account> page, @Param("entity") Account entity);
}
