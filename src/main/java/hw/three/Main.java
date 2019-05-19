package hw.three;

import hw.three.entities.Order;
import hw.three.people.Customer;
import hw.three.people.ICustomer;
import hw.three.people.ISeller;
import hw.three.people.Seller;

public class Main
{
    public static void main(String[] args)
    {
        //Considering we can only have one shop
        Shop shop = Shop.getShopInstance();

        ICustomer customer = new Customer(2);
        ISeller seller = new Seller();
        performPurchase(customer, seller);

        ICustomer customer2 = new Customer(20);
        ISeller seller2 = new Seller();
        performPurchase(customer2, seller2);
    }

    /** Perform some purchasing operations for demonstration purposes. */
    static private void performPurchase(ICustomer customer, ISeller seller)
    {
        System.out.println("Initial state. Shop has " + seller.calculateMoneyInCashbox() + ". Customer has " + customer.calculateMoneyInPocket());

        Order order = customer.generateOrder(); //currently generate order of item1 @5 and item2 @10
        double orderCost = seller.calculateOrderCost(order);
        if (customer.pay(orderCost))
        {
            seller.addMoneyToCashbox(orderCost);
            System.out.println("Order completed. " + order.toString());
        }
        else
        {
            System.out.println("Customer doesn't have enough money to pay for his order.");
        }

        System.out.println("Final state. Shop has " + seller.calculateMoneyInCashbox() + ". Customer has " + customer.calculateMoneyInPocket() + "\n");
    }
}
