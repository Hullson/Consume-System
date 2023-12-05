package com.demo.service.sys;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.demo.entity.sys.User;

public interface UserService extends IService<User> {
    void delUser(String userId);
    void updateUser(User user);
    Page<User> listPage(User user, Integer pageNum, Integer pageSize);

}
