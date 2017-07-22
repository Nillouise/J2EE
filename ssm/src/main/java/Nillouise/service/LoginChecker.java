package Nillouise.service;

import Nillouise.model.LoginForm;

/**
 * Created by win7x64 on 2017/7/21.
 */
public class LoginChecker
{
    public boolean checkpassword(LoginForm loginForm)
    {
        if(loginForm.getPassword().equals("admin")&&loginForm.getUsername().equals("admin"))
        {
            return true;
        }

        return false;
    }

}
