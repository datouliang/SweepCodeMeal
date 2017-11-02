package com.fh.util;

import com.fh.entity.system.User;

/**
 * Created by 大梁
 * Created Time 2017/10/31.
 */
public class UserUtil {

    public static User getLoginUser(){
        User user = (User)Jurisdiction.getSession().getAttribute(Const.SESSION_USER);
        return user;
    }
}
