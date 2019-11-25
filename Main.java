class Display {
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
}

class clock {

    //在clock的类里创建两个Display类型的对象（分别交由hour，minute来管理）<--可以理解为此时的成员变量为Display类型
    private Display hour = new Display(24);
    private Display minute = new Display(60);
    private Display seconds = new Display(60);

    public clock(int hour,int minute,int seconds)
    {
        this.hour.writeValue(hour);
        this.minute.writeValue(minute);
        this.seconds.writeValue(seconds);
    }

    public void tick()
    {
        seconds.increase();
        if (seconds.getValue() == 0) {
            minute.increase();
            if (minute.getValue() == 0) {
                hour.increase();
            }
        }

    }

    public String toString()
    {
        return String.format("%02d:%02d:%02d",hour.getValue(),this.minute.getValue(),this.seconds.getValue());
    }
}

    public class Main
        {    public static void main(String[] args)
        {
        java.util.Scanner in = new java.util.Scanner(System.in);
        clock clock = new clock(in.nextInt(), in.nextInt(), in.nextInt());
        clock.tick();
        System.out.println(clock);
        in.close();
        }
        }
