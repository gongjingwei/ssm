package com.jinwei.controller;

import com.github.pagehelper.PageInfo;
import com.jinwei.entity.LogInfo;
import com.jinwei.service.LogInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 创建人: 金伟
 * 描述: 用户登录
 * 创建时间: 2019/7/15 0015 - 上午 11:42
 **/
@Controller
@RequestMapping(value = "/user")
public class LoginController {

    private static Logger logger = LoggerFactory.getLogger(LoginController.class);


    @Autowired
    private LogInfoService logInfoService;

    @ResponseBody
    @RequestMapping(value = "/list")
    public Object getlist() {


        logger.info("呵呵呵呵......");


        List<LogInfo> list = logInfoService.getAll();


        return list;

    }


}

    