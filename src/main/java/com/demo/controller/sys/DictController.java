package com.demo.controller.sys;


import com.demo.business.R;
import com.demo.business.ResultUtils;
import com.demo.entity.sys.Dict;
import com.demo.service.sys.impl.DictServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dict")
public class DictController {

    @Autowired
    private DictServiceImpl dictService;

    @PostMapping("save")
    public R saveDict(@RequestBody Dict dict) {
        this.dictService.saveDict(dict);
        return ResultUtils.success();
    }

    @PostMapping("update")
    public R updateDict(@RequestBody Dict dict) {
        this.dictService.updateDict(dict);
        return ResultUtils.success();
    }

    @GetMapping("del/{id}")
    public R delDict(@PathVariable("id") String id) {
        this.dictService.del(id);
        return ResultUtils.success();
    }



}
