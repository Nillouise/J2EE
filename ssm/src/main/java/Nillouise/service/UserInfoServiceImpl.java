package Nillouise.service;

import Nillouise.mapper.UserInfoMapper;
import Nillouise.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * Created by win7x64 on 2017/7/21.
 */
@Service
public class UserInfoServiceImpl implements UserInfoService
{
    @Autowired
    UserInfoMapper userInfoMapper;



    public List<UserInfo> list()
    {
        return userInfoMapper.list();
    }


}
