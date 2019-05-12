package classwork.apr25;

import java.util.ArrayList;
import java.util.List;

public class Streams
{
    public static void main(String[] args)
    {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 100; i++)
        {
            list.add(i);
        }

        list.stream().forEach(elem -> System.out.println(elem));
        list.stream().forEach(System.out::println);


        list.stream().map(String::valueOf).forEach(System.out::println);



    }
    
}
