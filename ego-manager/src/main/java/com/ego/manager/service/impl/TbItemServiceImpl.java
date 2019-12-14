package com.ego.manager.service.impl;

import com.ego.commons.pojo.EasyUIDataGrid;
import com.ego.commons.utils.IDUtils;
import com.ego.dubbo.service.TbItemDescDubboService;
import com.ego.dubbo.service.TbItemDubboService;
import com.ego.manager.service.TbItemService;
import com.alibaba.dubbo.config.annotation.Reference;
import com.ego.pojo.TbItem;
import com.ego.pojo.TbItemDesc;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TbItemServiceImpl implements TbItemService{
    @Reference
    private TbItemDubboService tbItemDubboServiceImpl;
    @Reference
    private TbItemDescDubboService tbItemDescDubboServiceImpl;
    @Override
    public EasyUIDataGrid show(int page, int rows) {
        return tbItemDubboServiceImpl.show(page,rows);
    }

    @Override
    public int update(String ids, byte status) {
        int index=0;
        TbItem tbItem=new TbItem();
        String[] idsStr=ids.split(",");
        for (String id:idsStr){
            tbItem.setId(Long.parseLong(id));
            tbItem.setStatus(status);
            index+=tbItemDubboServiceImpl.updItemStatus(tbItem);
        }
        if (index==idsStr.length){
            return 1;
        }
        return 0;
    }

    @Override
    public int save(TbItem item, String desc) throws Exception {
        //不考虑食物回滚
//        Long id= IDUtils.genItemId();
//        item.setId(id);
//        Date date=new Date();
//        item.setCreated(date);
//        item.setUpdated(date);
//        item.setStatus((byte)1);
//        int index=tbItemDubboServiceImpl.insTbItem(item);
//        if (index>0){
//            TbItemDesc tbItemDesc=new TbItemDesc();
//            tbItemDesc.setItemId(id);
//            tbItemDesc.setItemDesc(desc);
//            tbItemDesc.setCreated(date);
//            tbItemDesc.setUpdated(date);
//            index+=tbItemDescDubboServiceImpl.insDesc(tbItemDesc);
//        }
//        if (index==2){
//            return 1;
//        }
        //调用dubbo中考虑事务回滚功能方法
        Long id= IDUtils.genItemId();
        item.setId(id);
        Date date=new Date();
        item.setCreated(date);
        item.setUpdated(date);
        item.setStatus((byte)1);
        TbItemDesc tbItemDesc=new TbItemDesc();
        tbItemDesc.setItemId(id);
        tbItemDesc.setItemDesc(desc);
        tbItemDesc.setCreated(date);
        tbItemDesc.setUpdated(date);
        int index=0;
        index=tbItemDubboServiceImpl.insTbItemDesc(item, tbItemDesc);
        return index;
    }
}
