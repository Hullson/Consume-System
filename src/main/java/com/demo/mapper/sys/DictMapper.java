package com.demo.mapper.sys;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.demo.entity.sys.Dict;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DictMapper extends BaseMapper<Dict> {
    void delDict(String id);
    List<Dict> listPage(Page<Dict> page, @Param("entity") Dict entity);

    List<Dict> listOfLabel(String label);

    Dict listOfValue(String value);

    List<Dict> listOfStyle(String style);


}
