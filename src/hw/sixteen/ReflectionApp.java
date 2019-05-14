package hw.sixteen;

import hw.utils.Logger;

public class ReflectionApp
{
    public static void main(String[] args)
    {
        //All Lombok annotations have retention=CLASS, so won't be found by analyzer
        TestClass clazz = new TestClass("foo", 1);
        Logger.getLogger().info(clazz.analyzeClass(clazz.getClass()).toString(4));
    }
}
