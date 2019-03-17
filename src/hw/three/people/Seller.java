package hw.three.people;

import hw.three.Shop;
import hw.three.entities.Order;
import hw.three.entities.Product;

public class Seller implements ISeller
{
    /** Return amount of money needed to pay for entire order. */
    @Override
    public double calculateOrderCost(Order order)
    {
        double price = 0;
        for (Product product : order.getProductsInOrder())
        {
            price += product.getPrice();
        }
        return price;
    }

    /** Simply add some money to cachbox, supposing nothing can go wrong during this operation. */
    @Override
    public void addMoneyToCashbox(double money)
    {
        Shop.getShopInstance().addMoneytoCashbox(money);
    }

    /** Return current amount of money in cashbox. */
    @Override
    public double calculateMoneyInCashbox()
    {
        return Shop.getShopInstance().calculateMoneyInCashbox();
    }
}
