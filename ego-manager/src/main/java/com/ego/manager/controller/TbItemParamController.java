package com.ego.manager.controller;

import com.ego.commons.pojo.EasyUIDataGrid;
import com.ego.manager.service.TbItemParamService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
public class TbItemParamController {
    @Resource
    private TbItemParamService tbItemParamServiceImpl;

    /**
     * 规格参数的分页显示
     * @param page
     * @param rows
     * @return
     */
    @RequestMapping("item/param/list")
    @ResponseBody
    public EasyUIDataGrid showPage(int page,int rows){
        return tbItemParamServiceImpl.showPage(page, rows);
    }
}
