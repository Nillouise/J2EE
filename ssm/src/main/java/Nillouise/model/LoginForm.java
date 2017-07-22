package Nillouise.model;

import java.util.Date;

/**
 * Created by win7x64 on 2017/7/21.
 */
public class LoginForm
{

    LoginForm()
    {
        this.date=new Date();
    }

    public Date getDate()
    {
        return date;
    }

    public void setDate(Date date)
    {
        this.date = date;
    }


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

    private Date date;
    private String username;
    private String password;
}
