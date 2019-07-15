package com.jinwei.dao;

import com.jinwei.entity.LogInfo;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 创建人: 金伟
 * 描述: 用户Dao接口
 * 创建时间: 2019/7/15 0015 - 上午 11:46
 **/

@Component
public interface LogInfoDao {


    List<LogInfo> findList();

}

    