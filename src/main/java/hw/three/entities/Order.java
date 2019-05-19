package hw.three.entities;

public class Order
{
    private Product[] productsInOrder_;

    public Order(Product[] productsInOrder)
    {
        productsInOrder_ = productsInOrder;
    }

    public Product[] getProductsInOrder()
    {
        return productsInOrder_;
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("Order consist of:");
        for (Product product : productsInOrder_)
        {
            sb.append(" ").append(product.getName()).append(" @").append(product.getPrice());
        }
        return sb.toString();
    }
}
