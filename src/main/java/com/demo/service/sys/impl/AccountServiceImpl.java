package com.demo.service.sys.impl;

import cn.hutool.core.collection.CollectionUtil;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.demo.business.BusinessException;
import com.demo.entity.sys.Account;
import com.demo.entity.sys.User;
import com.demo.mapper.sys.AccountMapper;
import com.demo.mapper.sys.UserMapper;
import com.demo.service.sys.AccountService;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

/**
 * @Author      : Hullson
 * @Date        : created in 2023-11-29
 * @Description : 登录业务层
 */
@Service
@Slf4j
public class AccountServiceImpl extends ServiceImpl<AccountMapper, Account> implements AccountService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 新增账号数据
     * @param entity    账号实体
     */
    @Override
    @Transactional
    public void saveAccount(Account entity) {
        // todo 密码加密
        // todo 新增密码解密
        Account account = baseMapper.getAccount(entity.getAccount());
        if (account != null) {
            throw new BusinessException(500, "账号已存在");
        }

        entity.preInsert();

        User user = new User();
        user.setAccount(entity)
            .setUserType("1")
            .setGender("0")
            .setNickname(UUID.randomUUID().toString().replace("-", ""));
        user.preInsert();
        baseMapper.insert(entity);
        userMapper.saveUser(user);
    }

    /**
     * 更新账号密码
     * @param account   账号实体
     */
    @Override
    public void updatePwd(Account account) {
        account.preUpdate();
        baseMapper.updatePwd(account);
    }

    /**
     * 删除账号数据
     * @param id    账号id
     */
    @Override
    @Transactional
    public void delAccount(String id) {
        baseMapper.delAccount(id);
        userMapper.delUser(id);
    }

    /**
     * 获取账号数据（分页）
     * @param entity    账号实体
     * @param pageNum   页码
     * @param pageSize  页大小
     * @return
     */
    @Override
    public Page<Account> listPage(Account entity, Integer pageNum, Integer pageSize) {
        // todo 密码脱敏
        if (entity == null) {
            entity = new Account();
        }
        Page<Account> page = new Page<>(pageNum, pageSize);
        if (CollectionUtil.isEmpty(entity.getOrders())) {
            OrderItem orderItem = new OrderItem();
            orderItem.setColumn("create_date");
            orderItem.setAsc(false);
            entity.setOrders(Lists.newArrayList(orderItem));
        }
        page.setOrders(entity.getOrders());
        page.setRecords(baseMapper.listPage(page, entity));
        return page;
    }

}
