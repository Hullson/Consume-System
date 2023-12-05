package com.demo.service.consume.impl;

import cn.hutool.core.collection.CollectionUtil;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.demo.business.BusinessException;
import com.demo.entity.consume.Records;
import com.demo.mapper.consume.RecordsMapper;
import com.demo.service.consume.RecordsService;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

/**
 * @Author      : Hullson
 * @Date        : created in 2023-12-04
 * @Description : 消费记录业务层
 */
@Service
public class RecordsServiceImpl extends ServiceImpl<RecordsMapper, Records> implements RecordsService {
    @Override
    public void saveRecords(Records records) {
        if (StringUtils.isBlank(records.getItem()) || StringUtils.isBlank(records.getStyle())) {
            throw new BusinessException(500, "消费信息未填写完整");
        }

        records.preInsert();
        baseMapper.saveRecords(records);
    }

    @Override
    public void delRecords(String id) {
        baseMapper.delRecords(id);
    }

    @Override
    public void updateRecords(Records records) {
        records.preUpdate();
        baseMapper.updateRecords(records);
    }

    @Override
    public Page<Records> listPage(Records records, Integer pageNum, Integer pageSize) {
        if (records == null) {
            records = new Records();
        }
        Page<Records> page = new Page<>(pageNum, pageSize);
        if (CollectionUtil.isEmpty(records.getOrders())) {
            OrderItem orderItem = new OrderItem();
            orderItem.setColumn("create_date");
            orderItem.setAsc(false);
            records.setOrders(Lists.newArrayList(orderItem));
        }
        page.setRecords(baseMapper.listPage(page, records));
        return page;
    }
}
