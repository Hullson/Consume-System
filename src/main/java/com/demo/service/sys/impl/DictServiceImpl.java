package com.demo.service.sys.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.demo.entity.sys.Dict;
import com.demo.mapper.sys.DictMapper;
import com.demo.service.sys.DictService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class DictServiceImpl extends ServiceImpl<DictMapper, Dict> implements DictService {
    @Override
    public Dict getOfLabel(String label) {

        return null;
    }

    @Override
    public List<Dict> getOfValue(String value) {
        return null;
    }

    @Override
    public List<Dict> listOfStyle(String style) {
        return null;
    }
}
