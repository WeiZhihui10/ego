package com.ego.manager.controller;

import com.ego.commons.pojo.EasyTree;
import com.ego.manager.service.TbItemCatService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class TbItemCatController {
    @Resource
    private TbItemCatService tbItemCatServiceImpl;

    /**
     * 显示商品类目
     * @param id
     * @return
     */
    @RequestMapping("item/cat/list")
    @ResponseBody
    public List<EasyTree> showCat(@RequestParam(defaultValue = "0")long id){
        return tbItemCatServiceImpl.show(id);
    }
}
