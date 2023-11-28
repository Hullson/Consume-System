package com.demo.mapper.sys;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.demo.entity.sys.Dict;

public interface DictMapper extends BaseMapper<Dict> {
    void delDict(String id);
}
