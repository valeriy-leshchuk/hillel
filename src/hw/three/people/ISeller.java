package hw.three.people;

import hw.three.entities.Order;

public interface ISeller
{
    void addMoneyToCashbox(double money);

    double calculateMoneyInCashbox();

    double calculateOrderCost(Order order);
}