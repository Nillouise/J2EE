package Model2;

/**
 * Created by win7x64 on 2017/7/4.
 */
public class Order
{
    public int getUserid()
    {
        return userid;
    }

    public void setUserid(int userid)
    {
        this.userid = userid;
    }

    public int getProductid()
    {
        return productid;
    }

    public void setProductid(int productid)
    {
        this.productid = productid;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public int getQuantity()
    {
        return quantity;
    }

    public void setQuantity(int quantity)
    {
        this.quantity = quantity;
    }

    int userid;
    int productid;
    int id;
    int quantity;

}
