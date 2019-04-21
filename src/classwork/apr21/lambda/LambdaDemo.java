package classwork.apr21.lambda;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

interface IFunc
{
    int doSmthWithNumbers(int param1, int param2);
}

public class LambdaDemo
{
    public static void main(String[] args)
    {
        doAdd(1, 2, Integer::sum);

        doAdd(1, 2, (p1, p2) -> {
            return 0;
        });

        Set<Integer > set = new HashSet<>();
        set.add(1);
        set.add(3);
        set.add(2);
        set.forEach(System.out::println);


        List<Integer> list = new LinkedList<>();
        list.add(2);
        list.add(3);
        list.add(4);

        list.forEach(elem-> System.out.println(elem*2));

    }

    public static void doAdd(int param1, int param2, IFunc addFunc)
    {
        addFunc.doSmthWithNumbers(param1, param2);
    }

}
