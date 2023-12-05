package com.demo.service.sys.impl;

import com.demo.business.BusinessException;
import com.demo.entity.sys.Account;
import com.demo.entity.sys.User;
import com.demo.mapper.sys.AccountMapper;
import com.demo.mapper.sys.UserMapper;
import com.demo.service.sys.SysService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;

/**
 * @Author      : Hullson
 * @Date        : created in 2023-11-29
 * @Description : 系统业务层
 */

@Service
public class SysServiceImpl implements SysService {

    @Autowired
    private AccountMapper accountMapper;
    @Autowired
    private UserMapper userMapper;

    @Override
    public User login(Account entity) {
        if (entity == null) {
            throw new BusinessException(500, "登录账号不能为空");
        }
        Account account = accountMapper.login(entity);
        if (account == null) {
            throw new BusinessException(HttpServletResponse.SC_UNAUTHORIZED, "账号密码错误");
        }
        User user = userMapper.getUserOfAccount(account.getId());

        // todo Redis缓存用户信息
        return user;
    }

    @Override
    public void logout(Account account) {
        // todo 账号登出
    }
}
