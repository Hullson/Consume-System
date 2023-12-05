package com.demo.controller.consume;

import com.demo.business.R;
import com.demo.business.ResultUtils;
import com.demo.entity.consume.Records;
import com.demo.service.consume.impl.RecordsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author      : Hullson
 * @Date        : created in 2023-12-05
 * @Description : 消费记录控制层
 */

@RestController
@RequestMapping("/consume")
public class RecordsController {

    @Autowired
    private RecordsServiceImpl recordsService;

    @PostMapping("save")
    public R saveRecords(@RequestBody Records records) {
        this.recordsService.saveRecords(records);
        return ResultUtils.success();
    }

    @DeleteMapping("del/{id}")
    public R delRecords(@PathVariable("id") String id) {
        this.recordsService.delRecords(id);
        return ResultUtils.success();
    }

    @PutMapping("updateRecords")
    public R updateRecords(@RequestBody Records records) {
        this.recordsService.updateRecords(records);
        return ResultUtils.success();
    }

    @PostMapping("listPage")
    public R listPage(@RequestParam("pageNum") Integer pageNum,
                      @RequestParam("pageSize") Integer pageSize,
                      @RequestBody Records records) {
        return ResultUtils.success(this.recordsService.listPage(records, pageNum, pageSize));
    }
}
