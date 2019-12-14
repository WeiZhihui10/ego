package com.ego.dubbo.service;

import com.ego.pojo.TbItemCat;

import java.util.List;

public interface TbItemCatDubboService {
    /**
     * 根据父类目id查询所有子类目
     * @param pid
     * @return
     */
    List<TbItemCat> show(Long pid);
}
