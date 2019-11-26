
import java.util.Scanner;

public class NianZhengShu
{
    public static void main(String[] args)
    {
        int num;
        int temp;
        int count = 0;
        int n,p;
        Scanner in = new Scanner(System.in);
        num = in.nextInt();
        if(num == 0)
        {
            System.out.println("ling");
        }
        if(num < 0)
        {
            System.out.print("fu ");
            num = -num;
        }
        temp = num;
        while(temp != 0)
        {
            temp = temp / 10;
            count++;//得到输入数字的位数
        }
        while(count != 0)//关键在于用count来控制循环，即输入数字的位数来控制循环
        {
            p = (int)Math.pow(10,--count);
            n = num/p;
            num = num % p;

            switch(n)
            {
                case 0:
                    System.out.print("ling");
                    break;
                case 1:
                    System.out.print("yi");
                    break;
                case 2:
                    System.out.print("er");
                    break;
                case 3:
                    System.out.print("san");
                    break;
                case 4:
                    System.out.print("si");
                    break;
                case 5:
                    System.out.print("wu");
                    break;
                case 6:
                    System.out.print("liu");
                    break;
                case 7:
                    System.out.print("qi");
                    break;
                case 8:
                    System.out.print("ba");
                    break;
                case 9:
                    System.out.print("jiu");
                    break;
            }
            if(count != 0)
                System.out.print(" ");
        }
    }

}


