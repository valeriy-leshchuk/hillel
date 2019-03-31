package hw.five.six.one;

import java.util.List;

public class Demo
{
    public static void main(String[] args)
    {
        List<Object> uniqueList = new UniqueList();
        uniqueList.add(1);
        uniqueList.add(2);
        uniqueList.add(2);
        uniqueList.add(3);
        uniqueList.add(1);
        uniqueList.add(2);
        uniqueList.add(null);
        uniqueList.add("text");
        uniqueList.add("text");
        uniqueList.add(null);

        System.out.println(uniqueList);
    }
}