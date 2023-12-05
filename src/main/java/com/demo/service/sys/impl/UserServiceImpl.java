package com.demo.service.sys.impl;

import cn.hutool.core.collection.CollectionUtil;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.demo.business.BusinessException;
import com.demo.entity.sys.User;
import com.demo.mapper.sys.UserMapper;
import com.demo.service.sys.UserService;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

/**
 * @Author      : Hullson
 * @Date        : created in 2023-12-04
 * @Description : 系统用户业务层
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Override
    public void delUser(String userId) {
        baseMapper.delUser(userId);
    }

    @Override
    public void updateUser(User user) {
        if (StringUtils.isBlank(user.getId())) {
            throw new BusinessException(500, "账号不存在");
        }
        user.preUpdate();
        baseMapper.updateUser(user);
    }

    @Override
    public Page<User> listPage(User user, Integer pageNum, Integer pageSize) {
        if (user == null) {
            user = new User();
        }
        Page<User> page = new Page<>(pageNum, pageSize);
        if (CollectionUtil.isEmpty(user.getOrders())) {
            OrderItem orderItem = new OrderItem();
            orderItem.setColumn("create_date");
            orderItem.setAsc(false);
            user.setOrders(Lists.newArrayList(orderItem));
        }
        page.setRecords(baseMapper.listPage(page, user));
        return page;
    }
}
