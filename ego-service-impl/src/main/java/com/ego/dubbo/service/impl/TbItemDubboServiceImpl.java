package com.ego.dubbo.service.impl;

import com.ego.commons.pojo.EasyUIDataGrid;
import com.ego.dubbo.service.TbItemDubboService;
import com.ego.mapper.TbItemDescMapper;
import com.ego.mapper.TbItemMapper;
import com.ego.pojo.TbItem;
import com.ego.pojo.TbItemDesc;
import com.ego.pojo.TbItemExample;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import javax.annotation.Resource;
import java.util.List;

public class TbItemDubboServiceImpl implements TbItemDubboService {
    @Resource
    private TbItemMapper tbItemMapper;
    @Resource
    private TbItemDescMapper tbItemDescMapper;

    /**
     * 查询商品信息
     * @param page
     * @param rows
     * @return
     */
    @Override
    public EasyUIDataGrid show(int page, int rows) {
        PageHelper.startPage(page,rows);
        //查询全部
        List<TbItem> list=tbItemMapper.selectByExample(new TbItemExample());
        //分页代码
        //设置分页条件
        PageInfo<TbItem> pi=new PageInfo<>(list);
        //放入到实体类中
        EasyUIDataGrid dataGrid=new EasyUIDataGrid();
        dataGrid.setRows(pi.getList());
        dataGrid.setTotal(pi.getTotal());
        return dataGrid;
    }

    /**
     * 修改状态
     * @param tbItem
     * @return
     */
    @Override
    public int updItemStatus(TbItem tbItem) {
        return tbItemMapper.updateByPrimaryKeySelective(tbItem);
    }

    /**
     * 商品新增
     * @param tbItem
     * @return
     */
    @Override
    public int insTbItem(TbItem tbItem) {
        return tbItemMapper.insert(tbItem);
    }

    /**
     * 新增包含商品表和商品描述表
     * @param tbItem
     * @param desc
     * @return
     */
    @Override
    public int insTbItemDesc(TbItem tbItem, TbItemDesc desc) throws Exception {
        int index=0;
        try {
            index=tbItemMapper.insertSelective(tbItem);
            index+=tbItemDescMapper.insertSelective(desc);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (index==2){
            return 1;
        }else{
            throw new Exception("新增失败");
        }

    }


}
