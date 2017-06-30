import java.util.ArrayList;

/**
 * Created by win7x64 on 2017/6/29.
 */

class mythread
{
    public synchronized static void run()
    {
        System.out.println("fdsf");
    }

}



public class Junior {
    public static void main(String[] args) {


        String s = String.valueOf(3.15);
        System.out.println(s);
        double num = Double.parseDouble("3.1e4");
        System.out.println(num);
        ArrayList<Number> hs =new ArrayList<>();
        ArrayList<Integer> adhs =new ArrayList<>();

        //父类泛型转子类泛型，能否成功？为什么？
        adhs = hs;

    }

    static private int ma(String ss)
    {
        return 0;
    }
}
