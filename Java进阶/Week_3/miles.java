import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class miles {
    //创建存储结构
    private static HashSet<String> City_name = new HashSet<String>();
    private static HashMap<String,HashMap<String,Integer>> miles_record = new HashMap<String,HashMap<String, Integer>>();

    //构造函数
    private static void miles()
    {

    }

    //添加检查
    private  static void checkArguments1(String s) {
        if (s == null)
            throw new NullPointerException();
    }

    private static void checkArguments2(String s) {
        if (s == null)
            throw new NullPointerException();
    }

    private  static void checkArgumentmiles(int miles) {
        if (miles < 0)
            throw new IllegalArgumentException("negative miles");
    }

    //数据添加函数，利用双层嵌套的HashMap存储数据
    public static void setRecord(String s1, String s2, int miles)
    {
        checkArguments1(s1);
        checkArguments2(s2);
        checkArgumentmiles(miles);
        if(City_name.add(s1))//判断是否能够插入
            miles_record.put(s1,new HashMap<String,Integer>());//miles_record的双层hashmap插入s1和一个内部的hashmap
        HashMap<String, Integer> record = miles_record.get(s1);//将内部的hashmap命名为recoed并赋键值为s1，创造映射关系
        assert (record != null);
        record.put(s2, miles);//填充record
    }


    public static void main(String[] args)
    {
        //miles();
        int n = 0;
        Scanner in = new Scanner(System.in);
        LinkedHashMap<String,Integer> city_num = new LinkedHashMap<>();

        //创建HashMap的city_num同时数出city_num的个数
        while(true)
        {
            String s = in.next();
            if(s.equals("###"))
            {
                break;
            }
            else
            {
                city_num.put(s,n++);
            }
        }

        //创建二维数组存储输入的各城市之间的距离
        int [][] miles_num = new int[n][n];
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
            {
                miles_num[i][j] = in.nextInt();
            }

        //将所有的数据存储进双层嵌套的的二维数组里，利用双层for循环
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
            {
                setRecord(city_num.keySet().toArray()[i].toString(),city_num.keySet().toArray()[j].toString(),miles_num[i][j]);
            }

        String input1 = in.next();
        String input2 = in.next();
        System.out.println(city_num);
        System.out.println(miles_record);
        System.out.println(miles_record.get(input1).get(input2));


    }
}
