package com.ego.dubbo.service.impl;

import com.ego.dubbo.service.TbItemCatDubboService;
import com.ego.mapper.TbItemCatMapper;
import com.ego.mapper.TbItemMapper;
import com.ego.pojo.TbItemCat;
import com.ego.pojo.TbItemCatExample;

import javax.annotation.Resource;
import java.util.List;

public class TbItemCatDubboServiceImpl implements TbItemCatDubboService {
    @Resource
    private TbItemCatMapper tbItemCatMapper;
    @Override
    public List<TbItemCat> show(Long pid) {
        TbItemCatExample example=new TbItemCatExample();
        example.createCriteria().andParentIdEqualTo(pid);
        return tbItemCatMapper.selectByExample(example);
    }
}
