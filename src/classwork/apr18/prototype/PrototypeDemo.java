package classwork.apr18.prototype;

import hw.utils.Logger;

interface CloneA extends Cloneable
{
    A createCopy();

    A createCopyClonable() throws CloneNotSupportedException;
}

class A implements CloneA
{
    private int intVar_ = 3;
    private B bVar_;

    public A(int intVar, B bVar)
    {
        intVar_ = intVar;
        bVar_ = bVar;
    }

    @Override
    public A createCopy()
    {
        B b = new B();
        b.setVal(this.bVar_.getVal());
        return new A(this.intVar_, b);
    }

    public int getIntVar()
    {
        return intVar_;
    }

    public B getbVar()
    {
        return bVar_;
    }

    @Override
    public A createCopyClonable() throws CloneNotSupportedException
    {
        return (A) super.clone();
    }

    @Override
    public A clone() throws CloneNotSupportedException
    {
        return (A) super.clone();
    }

}

class B
{
    private String val_ = "test";

    public String getVal()
    {
        return val_;
    }

    public void setVal(String val)
    {
        val_ = val;
    }
}

public class PrototypeDemo
{
    public static void main(String[] args) throws CloneNotSupportedException
    {
        A a = new A(1, new B());
        A aClone = a.createCopy();
        Logger.info(aClone.getbVar() == a.getbVar() ? "true" : "false");
        a.getbVar().setVal("test2");
        Logger.info(aClone.getbVar() == a.getbVar() ? "true" : "false");

        a.createCopy();
        a.createCopyClonable();
        a.clone();

        Object aObj = a;
        ((A) aObj).clone();
    }
}
