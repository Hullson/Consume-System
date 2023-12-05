package com.demo.service.sys.impl;

import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.demo.business.BusinessException;
import com.demo.entity.sys.Dict;
import com.demo.mapper.sys.DictMapper;
import com.demo.service.sys.DictService;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @Author      : Hullson
 * @Date        : created in 2023-11-27
 * @Description : 系统字典业务层
 */
@Service
@Slf4j
public class DictServiceImpl extends ServiceImpl<DictMapper, Dict> implements DictService {

    /**
     * 字典保存接口
     * @param dict 字典实体
     */
    @Override
    public void saveDict(Dict dict) {
        if (StringUtils.isBlank(dict.getValue())) {
            throw new BusinessException(500, "字典数据值不能为空");
        }

        Dict existsDict = baseMapper.listOfValue(dict.getLabel());
        if (existsDict != null) {
            throw new BusinessException(500, "该字典已存在");
        }

        dict.preInsert();
        log.info(" -- dict -- \t\t" + dict);
        baseMapper.insert(dict);
    }

    /**
     * 字典更新接口
     * @param dict 字典实体
     */
    @Override
    public void updateDict(Dict dict) {
        dict.preUpdate();
        baseMapper.updateById(dict);
    }

    /**
     * 字典删除接口（逻辑删除）
     * @param id 字典ID值
     */
    @Override
    public void del(String id) {
        baseMapper.delDict(id);
    }

    /**
     * 字典列表（分页）
     * @param entity    查询条件（字典实体）
     * @param pageNum   页码
     * @param pageSize  页大小
     * @return  分页列表
     */
    @Override
    public Page<Dict> listPage(Dict entity, Integer pageNum, Integer pageSize) {
        if (entity == null) {
            entity = new Dict();
        }
        Page<Dict> page = new Page<>(pageNum, pageSize);

        if (CollectionUtils.isEmpty(entity.getOrders())) {
            OrderItem orderItem = new OrderItem();
            orderItem.setColumn("a.create_date");
            orderItem.setAsc(false);
            entity.setOrders(Lists.newArrayList(orderItem));
        }
        page.setRecords(baseMapper.listPage(page, entity));
        return page;
    }

    /**
     * 根据标签获取字典信息
     * @param label 字典标签
     * @return  字典实体
     */
    @Override
    public List<Dict> listOfLabel(String label) {
        return baseMapper.listOfLabel(label);
    }

    /**
     * 根据字典值获取字典信息
     * @param value 字典数据值
     * @return  字典列表
     */
    @Override
    public Dict listOfValue(String value) {
        return baseMapper.listOfValue(value);
    }

    /**
     * 根据类型获取字典信息
     * @param style 字典类型
     * @return  字典列表
     */
    @Override
    public List<Dict> listOfStyle(String style) {
        return baseMapper.listOfStyle(style);
    }
}
