package com.ego.manager.service.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ego.commons.pojo.EasyUIDataGrid;
import com.ego.dubbo.service.TbItemParamDubboService;
import org.springframework.stereotype.Service;

@Service
public class TbItemParamServiceImpl implements TbItemParamDubboService{
    @Reference
    private TbItemParamDubboService tbItemParamDubboServiceImpl;
    @Override
    public EasyUIDataGrid showPage(int page, int rows) {
        return tbItemParamDubboServiceImpl.showPage(page, rows);
    }
}
