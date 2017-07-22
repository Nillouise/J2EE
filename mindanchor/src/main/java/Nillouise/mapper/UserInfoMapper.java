package Nillouise.mapper;

import Nillouise.model.UserInfo;

import java.util.List;

/**
 * Created by win7x64 on 2017/7/21.
 */
public interface UserInfoMapper
{
    public void add(UserInfo userInfo);
    public void delete(int id);
    public UserInfo get(int id);
    public UserInfo get(String username);
    public void update(UserInfo userInfo);
    public List<UserInfo> list();
    public int count();
}
