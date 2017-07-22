package Nillouise.controller;

import Nillouise.model.LoginForm;
import Nillouise.service.LoginChecker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Created by win7x64 on 2017/7/21.
 */

@Controller
public class LoginController
{
    private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);

    @RequestMapping(value = "/login",
            method = {RequestMethod.GET})
    public String loginPage()
    {

        return "login.jsp";
    }

    @RequestMapping(value = "/login.action",
            method = {RequestMethod.POST})
    public String loginActionPage(LoginForm loginForm,RedirectAttributes redirectAttributes)
    {
        System.out.println("test sout");
        System.out.println(loginForm.getDate());
        System.out.println(loginForm.getPassword());

        boolean loginSuccess = new LoginChecker().checkpassword(loginForm);


        if(loginSuccess)
        {
            return "redirect:/";
        }else{
            return "redirect:/login";
        }

    }

}
