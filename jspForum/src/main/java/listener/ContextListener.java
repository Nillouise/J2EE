package listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

//handnote 监听application生命周期的消息
//当服务器重启时，appliacation被实例，会调用这个消息。
@WebListener
public class ContextListener implements ServletContextListener {

    @Override
    public void contextDestroyed(ServletContextEvent arg0) {
        System.out.println("web 应用销毁  ");
    }

    @Override
    public void contextInitialized(ServletContextEvent arg0) {
        System.out.println("web 应用初始化 ");

    }
}