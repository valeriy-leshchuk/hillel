package classwork.apr7;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Consumer;

interface Test
{
}

interface TestAnon
{
    void doSmth();
}

class A
{
    private int intVar = 10;
    private static int statInt = 1;

    class InnerA implements Test
    {
        int innerIntVar = 1;

        public int getParentPrivatVar()
        {
            return intVar;
        }
    }

    public static class InnerStatA
    {
        public int getOuterStatInt()
        {
            return statInt;
        }
    }

    public Test getPrivObj()
    {
        InnerA innerA = new InnerA();
        innerA.innerIntVar = 20;
        return innerA;
    }
}

public class InnerClassDemo
{
    public static void main(String[] args)
    {
        A a = new A();
        Object innerA = a.new InnerA();
        Test test = a.getPrivObj();
        A.InnerStatA innerStatA = new A.InnerStatA();

        TestAnon testAnon = () -> System.out.println("testanon doSmth");

        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        set.forEach(integer -> {
            if(integer==1)
            {
                System.out.println(integer);
            }
        });

    }
}
