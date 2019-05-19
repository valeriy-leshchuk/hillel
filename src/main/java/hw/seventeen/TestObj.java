package hw.seventeen;

import lombok.Getter;
import lombok.ToString;

import java.util.Map;

@ToString
@Getter
public class TestObj
{
    private int property1;
    private double property2;
    private Map<String, Integer> property3;
    private Object[] property4;
}
