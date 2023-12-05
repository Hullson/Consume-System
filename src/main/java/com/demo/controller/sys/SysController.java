package com.demo.controller.sys;

import com.demo.business.R;
import com.demo.business.ResultUtils;
import com.demo.entity.sys.Account;
import com.demo.service.sys.impl.SysServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author      : Hullson
 * @Date        : created in 2023-11-30
 * @Description : 系统管理控制层
 */

@RestController
@RequestMapping("/sys")
public class SysController {

    @Autowired
    private SysServiceImpl sysService;

    @PostMapping("login")
    public R login(@RequestBody Account account) {
        sysService.login(account);
        return ResultUtils.success();
    }
}
