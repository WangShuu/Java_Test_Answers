import java.util.Scanner;

public class SpecialValue {
    public static void main(String[] args){
        int number;//输入的数字
        int count=0;//二进制此时的位数，当前为0
        int count1 = 1;//数字当前的位数
        int n;//余数
        int sv = 0;//最后的输出结果
        Scanner in = new Scanner(System.in);
        number = in.nextInt();//单一输入可以不用写到if循环里面，写到外面就可以了
        do{
            n = number % 10;
            if (n % 2 == count1 % 2)
            {
               sv = sv+(int)(1 * Math.pow(2,count));

            }
            count += 1;//无论如何都会自增，一定不要写到if循环里面
            count1 += 1;//切记不要写到if循环里面
            number = number / 10;
        }while(number != 0);
        System.out.println(sv);
    }
}
