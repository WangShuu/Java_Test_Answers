import java.util.Scanner;

public class Main {
    //Main函数
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Fraction a = new Fraction(in.nextInt(), in.nextInt());
        Fraction b = new Fraction(in.nextInt(),in.nextInt());
        a.print();
        b.print();
        a.plus(b).print();
        a.multiply(b).plus(new Fraction(5,6)).print();
        a.print();
        b.print();
        in.close();
    }

}

//创建一个Fraction的类（一个类里包含了成员变量和成员函数）
class Fraction{
    //定义成员变量，注意private的用法
    private int fenzi;
    private int fenmu;
    double score;

    //定义各种成员函数
    Fraction(int a,int b)//构造函数（注意构造函数和重载函数的区别）
    {
        this.fenzi = a;
        this.fenmu = b;

    }

    double toDouble()
    {
        return (fenzi*1.0)/fenmu;
    }

    Fraction plus(Fraction r)
    {
        Fraction m = new Fraction(0,1);//参数表令其为0
        m.fenmu = this.fenmu * r.fenmu;
        m.fenzi = this.fenzi * r.fenmu +this.fenmu * r.fenzi;
        return m;

    }
    Fraction multiply(Fraction r)
    {
        Fraction m = new Fraction(0,1);
        m.fenmu = this.fenmu * r.fenmu;
        m.fenzi = this.fenzi * r.fenzi;
        return m;
    }

    void print()
    {
        int temp;
        int a = fenzi;
        int b = fenmu;
        if(fenzi == fenmu)
        {
            System.out.println("1");
        }
        else
        {
            //利用辗转相除法求最大公约数
            if(a > b)//判断a和b的大小
            {
                while(b != 0)
                {
                    temp = a % b;//这里建议自己画一下过程，当b=0时，取a作最大公约数，下同
                    a = b;
                    b = temp;
                }

                System.out.println(this.fenzi/a+"/"+this.fenmu/a);
            }
            else
            {
                while(a != 0)
                {
                    temp = b % a;
                    b = a;
                    a = temp;
                }
                System.out.println(this.fenzi/b+"/"+this.fenmu/b);
            }

        }
    }
}


