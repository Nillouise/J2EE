package util;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBUtil {
    static String ip = "127.0.0.1";
    static int port = 3306;
    static String database = "how2java";
    static String encoding = "UTF-8";
    static String loginName = "root";
    static String password = "admin";
    static{
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        String url = String.format("jdbc:mysql://%s:%d/%s?characterEncoding=%s", ip, port, database, encoding);
        return DriverManager.getConnection(url, loginName, password);
    }
    static Logger logger = Logger.getLogger(DBUtil.class.toString());

    public static void main(String[] args) throws SQLException {
        System.out.println(getConnection());
        BasicConfigurator.configure();
        logger.setLevel(Level.DEBUG);
        logger.trace("跟踪信息");
        logger.debug("调试信息");
        logger.info("输出信息");
        try {
            Thread.sleep(1000);
        }catch (Exception e)
        {

        }
        logger.warn("警告信息");
        logger.error("错误信息");
        logger.fatal("致命信息");
    }
}