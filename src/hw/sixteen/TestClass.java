package hw.sixteen;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

@Getter
@AllArgsConstructor
@Analyzable
public class TestClass implements ICodeAnalyzer
{
    @Analyzable @NonNull private String strVar;

    @Analyzable private static final Double doubleVar = 1.2;

    public int intVar;

    @Analyzable @Deprecated
    public void setStrVar(String strVar, double doubleValue)
    {
        this.strVar = strVar;
    }

    @Analyzable
    public static final void testMethod()
    {
    }

    @Analyzable
    protected final String testMethod2()
    {
        return null;
    }

    @Analyzable
    public TestClass(int intVar, double doubleParam)
    {
        this.intVar = intVar;
        strVar = "bar";
    }
}
