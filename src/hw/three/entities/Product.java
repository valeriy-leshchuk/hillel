package hw.three.entities;

public class Product
{
    private String name_;
    private double price_;

    public Product(String name, double price)
    {
        name_ = name;
        price_ = price;
    }

    public String getName()
    {
        return name_;
    }

    public double getPrice()
    {
        return price_;
    }
}
