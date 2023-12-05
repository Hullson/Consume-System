package com.demo.service.sys;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.demo.entity.sys.Account;

public interface AccountService extends IService<Account> {

    void saveAccount(Account Account);

    void updatePwd(Account account);

    void delAccount(String id);

    Page<Account> listPage(Account account, Integer pageNum, Integer pageSize);
}
