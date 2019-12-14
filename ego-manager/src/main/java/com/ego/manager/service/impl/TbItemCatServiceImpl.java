package com.ego.manager.service.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ego.commons.pojo.EasyTree;
import com.ego.dubbo.service.TbItemCatDubboService;
import com.ego.manager.service.TbItemCatService;
import com.ego.pojo.TbItemCat;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TbItemCatServiceImpl implements TbItemCatService{
    @Reference
    private TbItemCatDubboService tbItemCatDubboServiceImpl;
    @Override
    public List<EasyTree> show(long pid) {
        List<TbItemCat> list=tbItemCatDubboServiceImpl.show(pid);
        List<EasyTree> treeList=new ArrayList<>();
        for (TbItemCat cat:list){
            EasyTree tree=new EasyTree();
            tree.setId(cat.getId());
            tree.setText(cat.getName());
            tree.setState(cat.getIsParent()?"closed":"open");
            treeList.add(tree);
        }
        return treeList;
    }
}
