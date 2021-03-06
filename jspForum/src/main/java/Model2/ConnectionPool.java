package Model2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
//handnote
//实现数据库连接池，使用了await等保证线程同步。
public class ConnectionPool {

    List<Connection> cs = new ArrayList<Connection>();

    static ConnectionPool connpool;
    public static ConnectionPool getPool()
    {
        if(connpool==null)
        {
            connpool = new ConnectionPool(10);
        }
        return connpool;
    }

    int size;

    public ConnectionPool(int size) {
        this.size = size;
        init();
    }

    public void init() {

        //这里恰恰不能使用try-with-resource的方式，因为这些连接都需要是"活"的，不要被自动关闭了
        try {
            Class.forName("com.mysql.jdbc.Driver");
            for (int i = 0; i < size; i++) {
                Connection c = DriverManager
                        .getConnection("jdbc:mysql://127.0.0.1:3306/jspforum?characterEncoding=UTF-8&&serverTimezone=GMT", "root", "admin");

                cs.add(c);

            }
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public synchronized Connection getConnection() {
        while (cs.isEmpty()) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        Connection c = cs.remove(0);
        return c;
    }

    public synchronized void returnConnection(Connection c) {
        cs.add(c);
        this.notifyAll();
    }

}