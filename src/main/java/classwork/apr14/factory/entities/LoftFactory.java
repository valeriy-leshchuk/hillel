package classwork.apr14.factory.entities;

import classwork.apr14.factory.entities.loft.LoftChair;
import classwork.apr14.factory.entities.loft.LoftTable;

public class LoftFactory extends AbstractFactory
{
    @Override
    public IChair createChair()
    {
        return new LoftChair();
    }

    @Override
    public ITable createTable()
    {
        return new LoftTable();
    }
}
