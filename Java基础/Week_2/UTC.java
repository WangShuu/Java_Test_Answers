import java.util.Scanner;

public class UTC {
    public static void main(String[] args){
        int BT,UT,n,m;
        Scanner in = new Scanner(System.in);
        BT = in.nextInt();
        if(BT<0 | BT>2359)
        {
            System.out.println("输入错误，请重新输入");
        }
        else
        {
            n = BT/100;
            m = BT%100;
            if(n<8)
            {
                n = n + 24;
                UT = n*100+m;
                System.out.println(UT - 800);
            }
            else
            {
                System.out.println(BT - 800);
            }
        }
    }
}
