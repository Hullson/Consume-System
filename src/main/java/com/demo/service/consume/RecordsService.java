package com.demo.service.consume;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.demo.entity.consume.Records;

public interface RecordsService extends IService<Records> {

    void saveRecords(Records records);
    void delRecords(String id);
    void updateRecords(Records records);

    Page<Records> listPage(Records records, Integer pageNum, Integer pageSize);
}
