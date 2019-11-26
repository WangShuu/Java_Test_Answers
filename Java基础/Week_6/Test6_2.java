/*import java.util.Scanner;

public class Test6_2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String StrInput;
        String hhmmss = null;
        int hh,mm,ss = 0;
        char ID0;
        int ID1,ID3;
        String StrLast;//最后的字符
        int i = 2;
        char [] CharInput;
        do
        {
            StrInput = in.nextLine();
            if(StrInput.startsWith("$GPRMC"))
            {
                CharInput = StrInput.toCharArray();
                for(ID0 = CharInput[1];CharInput[i] != '*';i++)
                //做异或运算
                {
                    ID0 ^= CharInput[i];
                }
            ID1 = ID0 % 65536;
            StrLast = StrInput.substring(StrInput.length() - 2,StrInput.length());
            ID3 = Integer.parseInt(StrLast,16);
            if(ID1 == ID3)
            {
                hhmmss = StrInput.substring(7,13);
            }
            }

        }while(StrInput.equals("END") != true);

        hh = Integer.parseInt(hhmmss.substring(0,2));
        mm = Integer.parseInt(hhmmss.substring(2,4));
        ss = Integer.parseInt(hhmmss.substring(4,6));

        hh = hh + 8;
        if(hh > 24)
            hh = hh % 24;
        System.out.printf("%02d:%02d:%02d",hh,mm,ss);

    }
}
*/
import java.util.Scanner;

public class Test6_2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        char charInput[];// 输入转换成char数组
        int intJiaoyan_65536 = 65536;// 保存65536
        int intJiaoyan;// 用于异或
        int intJiaoyan2;// 对65536取余后的结果
        int intLast = 0;// 字段16：校验值

        String hhmmss = null;// 字段1：UTC时间，hhmmss
        String strEnd = "END";// 最后一行是END三个大写字母。
        String strInput;// 读入一系列GPS输出
        String strLast;// 字段16：校验值
        String strStart = "$GPRMC";// 字段0：$GPRMC，语句ID，表明该语句为Recommended Minimum Specific GPS/TRANSIT Data（RMC）推荐最小定位信息

        int i;// 用于循环

        int hh = 0;// 6位数时间
        int mm = 0;
        int ss = 0;

        do {
            strInput = in.nextLine();// 输入字符串zx

            if (strInput.startsWith(strStart)) {// 如果字符串的前6位是$GPRMC
                charInput = strInput.toCharArray();// 输入转换成char数组

                for (intJiaoyan = charInput[1], i = 2; charInput[i] != '*'; i++) {
                    intJiaoyan ^= charInput[i];
                } // 提示：^运算符的作用是异或。将$和*之间所有的字符做^运算(第一个字符和第二个字符异或，结果再和第三个字符异或，依此类推)之后的值对65536取余后的结果

                intJiaoyan2 = intJiaoyan % intJiaoyan_65536;// 对65536取余后的结果

                strLast = strInput.substring(strInput.length() - 2, strInput.length());

                intLast = Integer.parseInt(strLast, 16);// Integer.parseInt(s, 16)从String变量s中得到其所表达的十六进制数字

                if (intJiaoyan2 == intLast) {
                    hhmmss = strInput.substring(7, 13);
                }
            }
        } while (strInput.equals(strEnd) == false); // 循环，当输入的字符串不是END，继续循环

        hh = Integer.parseInt(hhmmss.substring(0, 2));
        mm = Integer.parseInt(hhmmss.substring(2, 4));
        ss = Integer.parseInt(hhmmss.substring(4, 6));

        hh = hh + 8; // 换算成北京时间

        hh = hh % 24;// 如果大于24小时

        System.out.printf("%02d:%02d:%02d", hh, mm, ss);// 其中，hh是两位数的小时，不足两位时前面补0；mm是两位数的分钟，不足两位时前面补0；ss是两位数的秒，不足两位时前面补0。
    }
}