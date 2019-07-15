package com.jinwei.service;

import com.jinwei.dao.LogInfoDao;
import com.jinwei.entity.LogInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 创建人: 金伟
 * 描述: 日志信息
 * 创建时间: 2019/7/15 0015 - 上午 11:44
 **/
@Service
@Transactional(readOnly = true)
public class LogInfoService {


    @Autowired
    private LogInfoDao logInfoDao;


    public List<LogInfo> getAll() {


        return logInfoDao.findList();

    }




}

    