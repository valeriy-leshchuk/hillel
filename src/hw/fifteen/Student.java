package hw.fifteen;

import lombok.*;

@Getter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@Builder
public class Student
{
    @NonNull private String name;
    private double age;
    private int mark;
}
