package com.ego.manager.controller;

import com.ego.commons.pojo.EasyUIDataGrid;
import com.ego.commons.pojo.EgoResult;
import com.ego.manager.service.TbItemService;
import com.ego.pojo.TbItem;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
public class TbItemController {
    @Resource
    private TbItemService tbItemServiceImpl;
    /**
     * 分页显示商品
     * @param page 当前页码
     * @param rows 显示数目
     * @return
     */
    @RequestMapping("item/list")
    @ResponseBody
    public EasyUIDataGrid show(int page, int rows){
        return tbItemServiceImpl.show(page, rows);
    }

    /**
     * 商品删除
     * @param ids
     * @return
     */
    @RequestMapping("rest/item/delete")
    @ResponseBody
    public EgoResult delete(String ids){
        EgoResult result=new EgoResult();
        int index=tbItemServiceImpl.update(ids, (byte) 3);
        if (index==1){
            result.setStatus(200);
        }
        return result;
    }

    /**
     * 商品下架
     * @param ids
     * @return
     */
    @RequestMapping("rest/item/instock")
    @ResponseBody
    public EgoResult instock(String ids){
        EgoResult result=new EgoResult();
        int index=tbItemServiceImpl.update(ids, (byte) 2);
        if (index==1){
            result.setStatus(200);
        }
        return result;
    }

    /**
     * 商品上架
     * @param ids
     * @return
     */
    @RequestMapping("rest/item/reshelf")
    @ResponseBody
    public EgoResult reshelf(String ids){
        EgoResult result=new EgoResult();
        int index=tbItemServiceImpl.update(ids, (byte) 1);
        if (index==1){
            result.setStatus(200);
        }
        return result;
    }

    /**
     * 商品新增
     * @param tbItem
     * @param desc
     * @return
     */
    @RequestMapping("item/save")
    @ResponseBody
    public EgoResult insert(TbItem tbItem,String desc){
        EgoResult result=new EgoResult();
        int index= 0;
        try {
            index = tbItemServiceImpl.save(tbItem, desc);
            if (index==1){
                result.setStatus(200);
            }
        } catch (Exception e) {
            result.setData(e.getMessage());
        }
        return result;
    }
}
