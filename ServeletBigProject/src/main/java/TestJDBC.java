
import java.sql.*;

public class TestJDBC {
    public static void main(String[] args) {

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        //handnote
        //这里使用try with resource 来自动关闭联系和statement，数据库的连接和关闭都交给语言实现
        //因为Connection和Statement都实现了AutoClosable。反正也就是关闭条链接，没什么好在意的，交给语言做就可以了
        //注意这个语言在java7才有，所以需要设置语法使用到最新，而且maven导入sql的时候好像出了问题，让让默认设置变成java5
        //要在idea的setting里吧compiler设置好才行。
        try (
                Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8&&serverTimezone=GMT",
                        "root", "admin");
                Statement s = c.createStatement();
        )
        {
            //handnote
            //jdbc的增删查改都跟这个
            String sql = "insert into hero values(null," + "'提莫'" + "," + 313.0f + "," + 50 + ")";

            s.execute(sql);

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        testSelect();
    }

    static void testSelect()
    {
        //handout
        //查询语句用ResultSet 返回数据。
        try (Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8&&serverTimezone=GMT",
                "root", "admin"); Statement s = c.createStatement();) {

            String sql = "select * from hero";

            // 执行查询语句，并把结果集返回给ResultSet
            ResultSet rs = s.executeQuery(sql);
            while (rs.next()) {
                int id = rs.getInt("id");// 可以使用字段名
                String name = rs.getString(2);// 也可以使用字段的顺序
                float hp = rs.getFloat("hp");
                int damage = rs.getInt(4);
                System.out.printf("%d\t%s\t%f\t%d%n", id, name, hp, damage);
            }
            // 不一定要在这里关闭ReultSet，因为Statement关闭的时候，会自动关闭ResultSet
            // rs.close();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}