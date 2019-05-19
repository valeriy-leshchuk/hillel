package classwork.may12.reflection;

import classwork.may12.annotations.Doc;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Arrays;

public class ReflectionTest
{
    public static void main(String[] args) throws Exception
    {
        User user = new User("str", "var");

        Arrays.stream(user.getClass().getDeclaredFields()).forEach(field ->
            {
                System.out.println(field);

                field.setAccessible(true);
                try
                {
                    System.out.println(field.get(user));
                }
                catch (IllegalAccessException ex)
                {
                    System.out.println("field is not accessible.");
                }

            });


        Constructor constructor = User.class.getDeclaredConstructor(String.class);
        constructor.setAccessible(true);
        constructor.newInstance("a");

        Arrays.stream(User.class.getDeclaredAnnotations()).forEach(System.out::println);

        Doc docAnnot = User.class.getDeclaredAnnotation(Doc.class);
        System.out.println(docAnnot.toString());

        System.out.println(docAnnot.author());

    }
}
