package hw.fifteen;

import lombok.*;

@ToString
@EqualsAndHashCode
@AllArgsConstructor
@Builder
public class Student
{
    @NonNull @Getter private String name;
    @Getter double age;
    private int mark;
}
