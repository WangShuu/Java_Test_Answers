import java.util.Scanner;

public class Jiou {
    public static void main(String[] args){
        int number;
        int count0 = 0;
        int count1 = 0;
        Scanner in = new Scanner(System.in);
        do{
            number = in.nextInt();
            if(number != -1)
            {
                if (number % 2 == 0) {
                    count0 += 1;
                } else {
                    count1 += 1;
                }
            }
        }while(number != -1);//重点理解do while和while循环的区别
        System.out.print(count1+" ");
        System.out.println(count0);
    }
}
