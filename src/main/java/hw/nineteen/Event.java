package hw.nineteen;

import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class Event
{
    private String id;
    private String date;
    private EventParameter eventParameter;
}
