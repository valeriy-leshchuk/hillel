package classwork.may12.annotations;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Doc
{
    String author();
    String version() default "1";
    String desc();

}
