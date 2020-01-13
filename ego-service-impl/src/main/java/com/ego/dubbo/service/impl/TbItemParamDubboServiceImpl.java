package com.ego.dubbo.service.impl;

import com.ego.commons.pojo.EasyUIDataGrid;
import com.ego.dubbo.service.TbItemParamDubboService;
import com.ego.mapper.TbItemParamItemMapper;
import com.ego.mapper.TbItemParamMapper;
import com.ego.pojo.TbItemParam;
import com.ego.pojo.TbItemParamExample;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import javax.annotation.Resource;
import java.util.List;

public class TbItemParamDubboServiceImpl implements TbItemParamDubboService{
    @Resource
    private TbItemParamMapper tbItemParamMapper;
    @Override
    public EasyUIDataGrid showPage(int page, int rows) {
        //先设置分页条件
        PageHelper.startPage(page, rows);
        //设置查询的SQL语句
        //XXXExample()设置了什么，相当于在sql语句中where从句中添加了条件
        List<TbItemParam> list=tbItemParamMapper.selectByExample(new TbItemParamExample());
        //根据程序员自己编写的SQL语句结合分页插件产生最终结果，封装到PageInfo
        PageInfo<TbItemParam> pi=new PageInfo<>(list);
        //设置方法返回结果
        EasyUIDataGrid dataGrid=new EasyUIDataGrid();
        dataGrid.setRows(pi.getList());
        dataGrid.setTotal(pi.getTotal());
        return dataGrid;
    }
}
