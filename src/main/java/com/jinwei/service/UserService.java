package com.jinwei.service;

import com.jinwei.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 创建人: 金伟
 * 描述: 用户接口
 * 创建时间: 2019/7/15 0015 - 上午 11:44
 **/
@Service
@Transactional(readOnly = true)
public class UserService {


    @Autowired
    private UserDao userdao;




}

    