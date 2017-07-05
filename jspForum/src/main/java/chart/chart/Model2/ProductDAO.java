package Model2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by win7x64 on 2017/7/4.
 */
public class ProductDAO
{
    Connection conn;
    public  ProductDAO(Connection conn)
    {
        this.conn = conn;
    }

    public Product get(int id)
    {
        String sql = "select * from product where id = ?";
        try(PreparedStatement ps = conn.prepareStatement(sql))
        {
            ps.setInt(1,id);
            ResultSet rs =  ps.executeQuery();
            Product r= new Product();
            if(rs.next())
            {
                r.setId(rs.getInt("id"));
                r.setName(rs.getString("name"));
                r.setPrice(rs.getInt("price"));
            }
            return r;


        } catch (SQLException e)
        {
            e.printStackTrace();
        }
        return null;
    }
    public List<Product> get()
    {
        String sql = "select * from product";
        try(PreparedStatement ps = conn.prepareStatement(sql))
        {
            ResultSet rs =  ps.executeQuery();
            List<Product> r= new ArrayList<>();
            while(rs.next())
            {
                Product p = new Product();
                p.setId(rs.getInt("id"));
                p.setName(rs.getString("name"));
                p.setPrice(rs.getInt("price"));
                r.add(p);
            }
            return r;


        } catch (SQLException e)
        {
            e.printStackTrace();
        }
        return null;

    }

}
