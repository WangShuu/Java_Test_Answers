import java.util.Scanner;

public class Test7_1 {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n;
        n = in.nextInt();


        //int [] Primes =new int[];

        //得到用于计算用的素数表（100000以内）
        boolean [] isPrime = new boolean[100000];
        for(int i=2;i<isPrime.length;i++)
        {
            isPrime[i] = true;
        }
        //System.out.println(isPrime[n]);

        for(int i=2;i<isPrime.length;i++)
        {
            if(isPrime[i])
            {
                for(int k=2;i*k<isPrime.length;i++)
                {
                    isPrime[i*k] = false;
                }
            }
        }
        //System.out.println(isPrime[n]);
        //System.out.println(isPrime[n]);

        //判断并且输出
        if(isPrime[n])
        {
            System.out.print(n+"="+n);
        }
        else
        {   System.out.print(n+"=");
            for(int i=2;i<isPrime.length&&(n!=i)&&(isPrime[i]=true);)
            {
                if(n%i==0)
                {
                        System.out.print(i+"x");
                        n = n / i;
                }
                else
                {
                    i++;
                }

            }
        }
        System.out.print(n);
    }
}
