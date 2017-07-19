import org.smart4j.framework.helper.IocHelper;
import org.smart4j.framework.util.ClassUtil;

import java.util.Set;

/**
 * Created by win7x64 on 2017/7/19.
 */
public class jtest
{
    @org.junit.Test
    public void testgetClass() throws Exception
    {
        Set<Class<?>> c  =ClassUtil.getClassSet("org.smart4j.framework");

        for (Class<?> cc :c)
        {
            System.out.println(cc.getName());
        }
        IocHelper i = new IocHelper();
        System.out.println("fsdfdsf");
    }
}
