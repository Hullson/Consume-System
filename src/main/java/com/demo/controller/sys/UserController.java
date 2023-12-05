package com.demo.controller.sys;

import com.demo.business.R;
import com.demo.business.ResultUtils;
import com.demo.entity.sys.User;
import com.demo.service.sys.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author      : Hullson
 * @Date        : created in 2023-12-04
 * @Description : 系统用户控制层
 */

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserServiceImpl userService;

    @DeleteMapping("del/{id}")
    public R delById(@PathVariable("id") String id) {
        userService.delUser(id);
        return ResultUtils.success();
    }

    @PutMapping("updateUser")
    public R updateUser(@RequestBody User user){
        userService.updateUser(user);
        return ResultUtils.success();
    }

    @PostMapping("listPage")
    public R listPage(@RequestParam("pageNum") Integer pageNum,
                      @RequestParam("pageSize") Integer pageSize,
                      @RequestBody User user) {
        return ResultUtils.success(userService.listPage(user, pageNum, pageSize));
    }
}
