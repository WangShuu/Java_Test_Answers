import java.util.Scanner;

//自己用二维数组做的，觉得整体思路没什么问题，但就是出错了，也不太想改了
/*public class T5_1 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int[][] A = new int[100][2];
        int[][] B = new int[100][2];
        int[][] C = new int[100][2];
        //对第一个X*2数组的输入及判断终止条件
        for(int j=0;j<2;j++)
        {
            for(int i=0;;i++)
            {
                A[i][j] = in.nextInt();
                if(A[i][j] == 0)
                {
                    break;
                }
                A[i][j] = in.nextInt();
            }
        }
        //对第二个X*2数组的输入及判断终止条件
        for(int j=0;j<2;j++)
        {
            for(int i=0;;i++)
            {
                B[i][j] = in.nextInt();
                if(B[i][j] == 0)
                {
                    break;
                }
                B[i][j] = in.nextInt();
            }
        }
        //将A数组和B数组作整合给C数组进行第一轮赋值得到初始C数组
        for(int j=0;j<2;j++)//控制A数组的列
        {
            for(int i=0;i<A.length;i++)//从A数组的第一行开始
            {
                for(int m=0;m<B.length;m++)//从B数组的第一行开始逐步比较
                {
                    if (A[i][j] == B[m][j])//将A数组的第一列的第一个元素同B数组的第一列所有元素进行比较
                    {
                       C[m][j] = A[i][j];//给C数组的第一列第一行进行赋值
                       C[m][1] = A[i][1] + B[m][1];//该行的第二列相加
                    }
                }
            }
        }
        //将B数组与C数组进行第二轮整合，得到最后的C数组
        for(int i=0;i<B.length;i++)
        {
            for(int j=0;j<C.length;j++)
            {
                if(B[i][0] != C[j][0])
                {
                    C[C.length][0] = B[i][0];
                    C[C.length][1] = B[i][1];
                }
            }
        }
        //输出C数组，并按照高次幂到低次幂进行排序
        for(int i=0;i<C.length;i++)
        {
            if(C[i][0] != 0)
            {
                System.out.print(C[i][1]+"x"+C[i][0]+"+");
            }
           else
            {
               System.out.print(C[i][1]);
            }
        }

    }
}
*/

//参考的网上别人的代码
public class T5_1 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner in = new Scanner(System.in);
        int[] a=new int[101];//存放第一个多项式
        int[] b=new int[101];//存放第二个多项式
        int[] c=new int[101];//存放合并后的多项式
        int count=0;//用来统计输出的项数
        int n=0;//n表示幂次
        int x=0;//x表示系数
        //得到第一个多项式，用一维数组其实就可以解决问题了，因为有下标及该下标存储的值，如果使用二维数组有点麻烦
        do
        {
            n=in.nextInt();
            x=in.nextInt();
            a[n]=x;
        }while(n!=0);
       //得到第二个多项式
        do
        {
            n=in.nextInt();
            x=in.nextInt();
            b[n]=x;
        }while(n!=0);
        //合并多项式
        for(int i=0;i<101;i++)
        {
            c[i]=a[i]+b[i];
        }

        //输出幂次为2到100的项
        //从最高次幂向下进行输出，注意输出的控制格式和要求要相符合
        //注意此时在for循环遍历完成后，count大概率大于0，多数情况已经排除，下面只需要排除掉特殊情况即可
        for(int i=100;i>1;i--)//还是有待改进，从C.length开始效果应该会更加好
        {
            if(c[i]!=0)//如果系数不为零
            {
                if(count>0)//如果不是输出的第一项
                {
                    if(c[i]>0)//系数大于零要输出+号
                    {
                        System.out.print("+");
                    }
                }
                if(c[i]!=1&&c[i]!=-1)//如果系数为+-1的话，不能把1输出来，所以要单独处理
                {
                    System.out.print(c[i]+"x"+i);
                }else if(c[i]==1)//系数为1时
                {
                    System.out.print("x"+i);
                }else//系数为-1时
                {
                    System.out.print("-x"+i);
                }
                count++;
            }
            else//系数为零不输出
            {
                continue;
            }
        }
//        开始处理幂次为1的项
        if(c[1]!=0)
        {
            if(count>0)//非首项
            {
                if(c[1]>0)//正项要输出+号
                {
                    System.out.print("+");
                }
            }
            if(c[1]!=1&&c[1]!=-1)//系数为+-1同样要单独处理
            {
                System.out.print(c[1]+"x");
            }
            else if(c[1]==1)//系数为1
            {
                System.out.print("x");
            }
            else//xi数为-1时
            {
                System.out.print("-x");
            }
            count++;
        }
        //开始处理幂次为0的项
        if(c[0]!=0)
        {
            if(count>0)//非首项
            {
                if(c[1]>0)//正项要输出+号
                {
                    System.out.print("+");
                }
            }
            System.out.print(c[0]);
            count++;
        }
       //如果之前一个项都没有输出
        if(count==0)
        {
            System.out.print("0");
        }
    }
}
