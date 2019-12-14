package com.ego.manager.controller;

import com.ego.manager.service.PicService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.Map;

@Controller
public class PicController {
    @Resource
    private PicService picServiceImpl;
    /**
     * 文件上传
     * @param uploadFile
     * @return
     */
    @RequestMapping("pic/upload")
    @ResponseBody
    public Map<String,Object> upload(MultipartFile uploadFile){
        return picServiceImpl.upload(uploadFile);
    }
}
