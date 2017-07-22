package Nillouise.service;

import Nillouise.baseTest.SpringTestCase;
import Nillouise.model.UserInfo;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by win7x64 on 2017/7/22.
 */
public class ServiceTest extends SpringTestCase
{
    @Autowired
    private UserInfoService userInfoService;

    @Test
    public void showUser()
    {
        List<UserInfo> users = userInfoService.list();
        for(UserInfo user:users)
        {
            System.out.println(user);
        }
    }


}
