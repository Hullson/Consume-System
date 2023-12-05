package com.demo.controller.sys;


import com.demo.business.R;
import com.demo.business.ResultUtils;
import com.demo.entity.sys.Dict;
import com.demo.service.sys.impl.DictServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sys/dict")
public class DictController {

    @Autowired
    private DictServiceImpl dictService;

    @PostMapping("save")
    public R saveDict(@RequestBody Dict dict) {
        this.dictService.saveDict(dict);
        return ResultUtils.success();
    }

    @PutMapping("update")
    public R updateDict(@RequestBody Dict dict) {
        this.dictService.updateDict(dict);
        return ResultUtils.success();
    }

    @DeleteMapping("del/{id}")
    public R delDict(@PathVariable("id") String id) {
        this.dictService.del(id);
        return ResultUtils.success();
    }

    @PostMapping("listPage")
    public R listPage(@RequestParam("pageNum") Integer pageNum,
                      @RequestParam("pageSize") Integer pageSize,
                      @RequestBody Dict entity) {
        return ResultUtils.success(dictService.listPage(entity, pageNum, pageSize));
    }

    @GetMapping("listOfLabel")
    public R listOfLabel(@PathVariable("label") String label) {
        return ResultUtils.success(dictService.listOfLabel(label));
    }

    @GetMapping("listOfValue")
    public R listOfValue(@PathVariable("value") String value) {
        return ResultUtils.success(dictService.listOfValue(value));
    }

    @GetMapping("listOfStyle")
    public R listOfStyle(@PathVariable("style") String style) {
        return ResultUtils.success(dictService.listOfStyle(style));
    }

}
