import java.util.Scanner;

public class Test7_2 {

    //创建Perfect函数判断完数并且输出
    public static void Perfect(int n,int m){
        int isPerfect [] = new int[1000];
        int Flag = 0;//标志位用于辅助输出

        //判断是否为完数
        for(int k=n;k<=m;k++)
        {
            int sum = 0;
            for(int j=1;j<k;j++)
            {
                if(k%j == 0)
                {
                    sum = sum + j;
                }
            }

            if(sum == k)
            {
                isPerfect[Flag] = k;
                Flag++;
            }
        }

        //输出控制
        if(Flag == 0)
        {
            System.out.println();//当循环结束时，Flag=0即没有完数时输出一个空行
        }

        else
        {
            for(int i=0;i<Flag;i++)
            {
                if(i!=(Flag-1))//当不是最后一个完数时输出数字+一个空格；当是最后一个完数时，只输出该完数并结束循环
                {
                    System.out.print(isPerfect[i]+" ");
                }
                else
                    System.out.print(isPerfect[i]);
            }
        }
    }

    //main函数
    public static void main(String[] args) {
        int n, m;
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        Perfect(n,m);//调用Perfect函数
    }
}