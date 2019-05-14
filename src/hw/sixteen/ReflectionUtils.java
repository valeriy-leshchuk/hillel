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

    public static Set<String> getConstructorParamsAsSet(Constructor constructor)
    {
        return Arrays.stream(constructor.getParameterTypes()).map(Class::getSimpleName).collect(Collectors.toSet());
    }

    public static Set<String> getMethodParamsAsSet(Method method)
    {
        return Arrays.stream(method.getParameterTypes()).map(Class::getSimpleName).collect(Collectors.toSet());
    }

    public static Set<String> getConstructorAnnotationsAsSet(Constructor constructor)
    {
        return Arrays.stream(constructor.getAnnotations()).map(constr -> constr.annotationType().getSimpleName()).collect(Collectors.toSet());
    }

    public static Set<String> getMethodAnnotationsAsSet(Method method)
    {
        return Arrays.stream(method.getAnnotations()).map(constr -> constr.annotationType().getSimpleName()).collect(Collectors.toSet());
    }

    public static Set<String> getFieldAnnotationsAsSet(Field field)
    {
        return Arrays.stream(field.getAnnotations()).map(annotation -> annotation.annotationType().getSimpleName()).collect(Collectors.toSet());
    }

    private ReflectionUtils()
    {
    }
}
