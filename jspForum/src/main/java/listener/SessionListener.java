package listener;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

//handnote
//session 的生命周期事件监听
@WebListener
public class SessionListener implements HttpSessionListener {

    @Override
    public void sessionCreated(HttpSessionEvent e) {

        System.out.println("监听到 session 创建, sessionid 是： " + e.getSession().getId());

        //handnote servlet获得使用application
        ServletContext application = e.getSession().getServletContext();

        Integer online_number = (Integer) application.getAttribute("online_number");

        if (null == online_number)
            online_number = 0;
        online_number++;
        application.setAttribute("online_number", online_number);

        System.out.println("新增一位在线用户");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent e) {

        ServletContext application = e.getSession().getServletContext();

        Integer online_number = (Integer) application.getAttribute("online_number");

        if(null==online_number){
            online_number = 0;
        }
        else
            online_number--;
        application.setAttribute("online_number", online_number);
        System.out.println("一位用户离线");    }
}