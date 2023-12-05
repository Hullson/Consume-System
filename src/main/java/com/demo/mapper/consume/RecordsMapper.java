package com.demo.mapper.consume;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.demo.entity.consume.Records;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RecordsMapper extends BaseMapper<Records> {
    void saveRecords(Records records);
    void delRecords(String id);
    void updateRecords(@Param("entity") Records entity);

    List<Records> listPage(Page<Records> page, Records entity);
}
