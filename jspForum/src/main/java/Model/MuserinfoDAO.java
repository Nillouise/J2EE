package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by win7x64 on 2017/7/2.
 */
public class MuserinfoDAO implements DAO<Muserinfo>
{
    Connection conn;

    public MuserinfoDAO(Connection conn)
    {
        this.conn = conn;
    }
    public void add(Muserinfo userinfo)
    {
        String sql = "insert into userinfo(UserName,UserPassword) values(?,?)";
        try  {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, userinfo.UserName);
            ps.setString(2, userinfo.Password);

            ps.execute();

        } catch (SQLException e) {

            e.printStackTrace();
        }

    }

    public void update(Muserinfo hero) {

    }

    public void delete(int id) {

    }

    public Muserinfo get(int id) {

        return null;
    }

    public List<Muserinfo> list() {

        return null;
    }

    public List<Muserinfo> list(int start, int count) {

        return null;
    }

}
