package hw.three.people;

import hw.three.entities.Order;
import hw.three.entities.Product;

public class Customer implements ICustomer
{
    private double moneyInPocket_;

    public Customer(double moneyInPocket)
    {
        moneyInPocket_ = moneyInPocket;
    }

    /** Return true if customer has enough money to pay. */
    @Override
    public boolean pay(double amountToPay)
    {
        if (moneyInPocket_ - amountToPay > 0)
        {
            moneyInPocket_ -= amountToPay;
            return true;
        }
        return false;
    }

    /** There should be some random generator, but for now it generate the same order. */
    @Override
    public Order generateOrder()
    {
        Product[] products = new Product[]{new Product("item1", 5), new Product("item2", 10)};
        return new Order(products);
    }

    @Override
    public double calculateMoneyInPocket()
    {
        return moneyInPocket_;
    }
}
