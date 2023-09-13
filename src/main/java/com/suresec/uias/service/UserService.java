package com.suresec.uias.service;

import com.suresec.uias.dao.UserDao;
import com.suresec.uias.vo.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Wan CC
 * @create 2023-09-12 14:49
 * @Description:
 */
@Service
public class UserService
{
    @Autowired
    private UserDao userDao;

    public UserInfo selectByLoginName(String loginName){
        UserInfo u = userDao.selectByLoginName(loginName);
        System.out.println("111111111="+u.getLoginName());
        return u;
    }
}
