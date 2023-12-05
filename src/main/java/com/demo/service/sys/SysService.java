package com.demo.service.sys;

import com.demo.entity.sys.Account;
import com.demo.entity.sys.User;

public interface SysService {
    User login(Account entity);
    void logout(Account account);
}
