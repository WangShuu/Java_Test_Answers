package clock;


public class Display {
    //成员变量
    private int value;
    private int limit;

    //构造函数
    public Display(int limit)
    {
        this.limit = limit;
    }

    //成员函数
    public void increase()
    {
        value++;
        if(value == limit)
        {
            value = 0;
        }
    }

    public void writeValue(int value)
    {
        this.value = value;
    }

    public int getValue()
    {
        return value;
    }

    //主函数
    public static void main(String[] args){
        Display d = new Display(24);
        for(;;)
        {
            d.increase();
            System.out.println(d.getValue());
        }

    }
}
