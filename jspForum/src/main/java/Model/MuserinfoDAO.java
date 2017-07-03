package Model;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.sql.*;
import java.util.*;

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
            ps.setString(1, userinfo.username);
            ps.setString(2, userinfo.password);

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

    public boolean get(String user, String password)
    {
        String sql = "select * from userinfo where UserName = ? AND UserPassword = ?";

        try (PreparedStatement ps = conn.prepareStatement(sql);) {
            ps.setString(1,user);
            ps.setString(2,password);
            ResultSet rs = ps.executeQuery();
            if (rs.next())
            {
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;

    }


    public int getCount()
    {

        String sql = "select count(*) from userinfo";
        int r = 0;
        try (PreparedStatement ps = conn.prepareStatement(sql);) {
            ResultSet rs = ps.executeQuery();
            if (rs.next())
            {
                r = rs.getInt(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return r;

    }

    public List<Muserinfo> list() {
        //handnote 单单List好像是不行的，是abstract 的，要用ArrayList才行；

        return list(0,Short.MAX_VALUE);
    }

    public List<Muserinfo> list(int start, int count)
    {
        //handnote 单单List好像是不行的，是abstract 的，要用ArrayList才行；
        List<Muserinfo> rlist = new ArrayList<>();

        String sql = "select * from userinfo order by id desc limit ?,? ";

        try (PreparedStatement ps = conn.prepareStatement(sql);) {
            ps.setInt(1, start);
            ps.setInt(2, count);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Muserinfo userinfo = new Muserinfo();
                userinfo.id = rs.getInt("id");
                userinfo.username = rs.getString("username");
                userinfo.password = rs.getString("UserPassword");
                userinfo.createtime = rs.getTime("createtime");
                rlist.add(userinfo);
            }
        } catch (SQLException e) {

            e.printStackTrace();
        }
        return rlist;
    }

}
