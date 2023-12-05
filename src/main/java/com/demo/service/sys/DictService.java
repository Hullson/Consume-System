package com.demo.service.sys;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.demo.entity.sys.Dict;

import java.util.List;

public interface DictService extends IService<Dict> {

    void saveDict(Dict dict);
    void updateDict(Dict dict);
    void del(String id);

    Page<Dict> listPage(Dict entity, Integer pageNum, Integer pageSize);

    List<Dict> listOfLabel(String label);

    Dict listOfValue(String value);

    List<Dict> listOfStyle(String style);
//    List<Dict> listPage();
}
