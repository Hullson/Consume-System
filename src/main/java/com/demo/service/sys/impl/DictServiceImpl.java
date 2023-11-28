package com.demo.service.sys.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.demo.entity.sys.Dict;
import com.demo.mapper.sys.DictMapper;
import com.demo.service.sys.DictService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class DictServiceImpl extends ServiceImpl<DictMapper, Dict> implements DictService {

    @Override
    public void saveDict(Dict dict) {
        dict.preInsert();
        baseMapper.insert(dict);
    }

    @Override
    public void updateDict(Dict dict) {
        dict.preUpdate();
        baseMapper.updateById(dict);
    }

    @Override
    public void del(String id) {
        baseMapper.delDict(id);
    }

    @Override
    public Dict getOfLabel(String label) {
        LambdaQueryWrapper<Dict> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Dict::getLabel, label);
        Dict dict = baseMapper.selectOne(wrapper);
        return dict;
    }

    @Override
    public List<Dict> getOfValue(String value) {
        LambdaQueryWrapper<Dict> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Dict::getValue, value);
        List<Dict> dictList = baseMapper.selectList(wrapper);
        return dictList;
    }

    @Override
    public List<Dict> listOfStyle(String style) {
        LambdaQueryWrapper<Dict> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Dict::getStyle, style);
        List<Dict> dictList = baseMapper.selectList(wrapper);
        return dictList;
    }
}
