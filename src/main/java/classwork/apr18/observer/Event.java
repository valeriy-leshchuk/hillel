package classwork.apr18.observer;

import java.util.Objects;

public class Event
{
    private String type_;

    public Event(String type)
    {
        type_ = type;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return type_.equals(event.type_);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(type_);
    }

    @Override
    public String toString()
    {
        return "Event {type_='" + type_ + "'}";
    }
}
