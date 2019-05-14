package hw.sixteen;

public class ReflectionApp
{
    public static void main(String[] args)
    {
        //All Lombok annotations have retention=CLASS, so won't be found by analyzer
        TestClass clazz = new TestClass("foo", 1);
        System.out.println(clazz.analyzeClass(clazz.getClass()).toString(4));
    }
}
