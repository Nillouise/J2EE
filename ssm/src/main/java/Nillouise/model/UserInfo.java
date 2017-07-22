package Nillouise.model;

import java.util.Date;

/**
 * Created by win7x64 on 2017/7/21.
 */
public class UserInfo
{
    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public Date getCreatetime()
    {
        return createtime;
    }

    public void setCreatetime(Date createtime)
    {
        this.createtime = createtime;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    @Override
    public String toString()
    {
        return getUsername()+" "+getPassword();
    }

    private int id;
    private String username;
    private String password;
    private Date createtime;



}
