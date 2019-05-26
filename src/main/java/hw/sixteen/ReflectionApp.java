package hw.sixteen;

import lombok.extern.log4j.Log4j;

@Log4j
public class ReflectionApp
{
    public static void main(String[] args)
    {
        //All Lombok annotations have retention=CLASS, so won't be found by analyzer
        TestClass clazz = new TestClass("foo", 1);
        log.debug(clazz.analyzeClass(clazz.getClass()).toString(4));
    }
}
