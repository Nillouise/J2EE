package Model2;

import java.util.Date;

/**
 * Created by win7x64 on 2017/7/2.
 */
public class Muserinfo {

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
    //handnote
    //这里为了配合jstl的jsp标签需要的命名规范，全部成员变量全部小写（好像是前两位一定要小写，后面可以不用小写）
    //这次debug，有一点没想到很严重，就是jstl的标签机制没有考虑，这个明显是黑盒的地方不考虑是我想法的缺陷
    public int id;
    public String username;
    public String password;
    public Date createtime;
}
