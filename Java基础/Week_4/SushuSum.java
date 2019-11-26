import java.util.Scanner;
//可以说是硬做出来的，估计过两天自己也忘了思路了
public class SushuSum {
    public static void main(String[] args){
        int a;//左边界
        int b;//右边界
        int count=1;//计数位
        int n = 2;
        int i;
        int sum = 0;
        int flag = 1;//标示位
        Scanner in = new Scanner(System.in);
        a = in.nextInt();
        b = in.nextInt();
        while(count<=b)
        {

            for (i = 2; i < n; i++)//判断是否位素数，若不为素数，令flag=0，break中断for循环
            {
                if (n % i == 0)
                {
                    flag = 0;
                    break;
                }
            }
            if(count>=a && count<=b)//判断计数位count是否已经到达了（a,b）的范围
            {
                if(flag == 1)//当flag=1时，sum才可以做加法运算
            {
                    sum = sum + n;
            }
            }
            if(flag != 0) count++;//只有当flag不等于0，即标示为素数时，计数位才做自加运算
            n++;//n自增继续向前寻找count所匹配的素数
            flag = 1;//标示位重新置为1
        }
        System.out.println(sum);
    }
}
