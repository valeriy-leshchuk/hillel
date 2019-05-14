package hw.sixteen;

import java.lang.reflect.*;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public final class ReflectionUtils
{
    public static Set<String> getModifiersAsSet(Member member)
    {
        return Arrays.stream(Modifier.toString(member.getModifiers()).split(" ")).collect(Collectors.toSet());
    }

    public static Set<String> getParamsAsSet(Member member)
    {
        if (member instanceof Constructor)
        {
            return Arrays.stream(((Constructor) member).getParameterTypes()).map(Class::getSimpleName).collect(Collectors.toSet());
        }
        if (member instanceof Method)
        {
            return Arrays.stream(((Method) member).getParameterTypes()).map(Class::getSimpleName).collect(Collectors.toSet());
        }
        return null;
    }

    public static Set<String> getAnnotationsAsSet(Member member)
    {
        if (member instanceof Constructor)
        {
            return Arrays.stream(((Constructor) member).getAnnotations()).map(mem -> mem.annotationType().getSimpleName()).collect(Collectors.toSet());
        }
        if (member instanceof Method)
        {
            return Arrays.stream(((Method) member).getAnnotations()).map(mem -> mem.annotationType().getSimpleName()).collect(Collectors.toSet());
        }
        if (member instanceof Field)
        {
            return Arrays.stream(((Field) member).getAnnotations()).map(mem -> mem.annotationType().getSimpleName()).collect(Collectors.toSet());
        }
        return null;
    }

    private ReflectionUtils()
    {
    }
}
