package com.demo.controller.sys;

import com.demo.business.R;
import com.demo.business.ResultUtils;
import com.demo.entity.sys.Account;
import com.demo.service.sys.impl.AccountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author      : Hullson
 * @Date        : created in 2023-11-30
 * @Description : 账号登录
 */

@RestController
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private AccountServiceImpl accountService;

    @PostMapping("/save")
    public R saveAccount(@RequestBody Account account) {
        accountService.saveAccount(account);
        return ResultUtils.success();
    }

    @PutMapping("/updatePwd")
    public R updatePwd(@RequestBody Account account) {
        accountService.updatePwd(account);
        return  ResultUtils.success();
    }

    @DeleteMapping("/delete/{id}")
    public R delAccount(@PathVariable("id") String id) {
        accountService.delAccount(id);
        return ResultUtils.success();
    }

    @PostMapping("/listPage")
    public R listPage(@RequestParam("pageNum") Integer pageNum,
                      @RequestParam("pageSize") Integer pageSize,
                      @RequestBody Account account) {
        return ResultUtils.success(accountService.listPage(account, pageNum, pageSize));
    }
}
