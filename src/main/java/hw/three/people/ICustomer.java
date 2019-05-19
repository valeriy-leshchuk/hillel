package hw.three.people;

import hw.three.entities.Order;

public interface ICustomer
{
    Order generateOrder();

    boolean pay(double money);

    double calculateMoneyInPocket();
}
