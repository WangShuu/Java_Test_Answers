import java.util.Scanner;

public class Test6_1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        //输入字符串，并且使用String类的split方法利用格作为分隔符将字符串分割为字符串数组
        String S = in.nextLine();
        String[] C = S.split("\\s");

     /*
     写的时候有点弄不清楚，做了一下简单的测试
     System.out.println(C.length);
     System.out.println(C[4]);
     System.out.println(C[4].length());
     */

        //利用for循环，判断如果不是最后一个字符串时，直接输出长度+空格，如果是最后一个字符串，输出长度-1
        if (S.equals("."))
        {
            System.out.print("0");
        }
        else
        {
            for (int i = 0; i < C.length; i++) {
                if (i != C.length - 1) {
                    if (C[i].length() == 0) ;
                    else {
                        System.out.print(C[i].length() + " ");
                    }
                } else {
                    System.out.print(C[i].length() - 1);
                }
            }
        }
    }
}
