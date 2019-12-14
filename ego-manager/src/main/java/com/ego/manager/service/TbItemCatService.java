package com.ego.manager.service;

import com.ego.commons.pojo.EasyTree;

import java.util.List;

public interface TbItemCatService {
    /**
     * 根据父菜单id显示所有子菜单
     * @param pid
     * @return
     */
    List<EasyTree> show(long pid);
}
