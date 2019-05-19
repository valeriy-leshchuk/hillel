package classwork.apr14.factory.entities;

import classwork.apr14.factory.entities.classic.ClassicChair;
import classwork.apr14.factory.entities.classic.ClassicTable;

public class ClassicFactory extends AbstractFactory
{
    @Override
    public IChair createChair()
    {
        return new ClassicChair();
    }

    @Override
    public ITable createTable()
    {
        return new ClassicTable();
    }
}
