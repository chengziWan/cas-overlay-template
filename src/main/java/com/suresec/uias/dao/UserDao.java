package com.suresec.uias.dao;

import com.suresec.uias.vo.UserInfo;
import org.apache.ibatis.annotations.Param;

public interface UserDao
{
    UserInfo selectByLoginName(@Param("loginName") String loginName);
}
