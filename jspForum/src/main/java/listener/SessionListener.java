package listener;

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
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent e) {

        System.out.println("监听到 session 销毁, sessionid 是： " + e.getSession().getId());
    }
}