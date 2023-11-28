package com.demo.service.sys;

import com.baomidou.mybatisplus.extension.service.IService;
import com.demo.entity.sys.Dict;

import java.util.List;

public interface DictService extends IService<Dict> {

    void saveDict(Dict dict);
    void updateDict(Dict dict);
    void del(String id);

    Dict getOfLabel(String label);
    List<Dict> getOfValue(String value);
    List<Dict> listOfStyle(String style);
//    List<Dict> listPage();
}
