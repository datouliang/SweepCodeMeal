package com.fh.service.system.user.impl;

import com.fh.service.system.user.UserManager;
import com.fh.util.PageData;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * Created by 大梁
 * Created Time 2017/10/26.
 */
public class UserServiceTest {

    @Resource(name="userService")
    private UserManager userService;

    @Test
    public void testListAllUser() throws Exception {
        System.out.println(userService.listAllUser(new PageData()));
    }
}