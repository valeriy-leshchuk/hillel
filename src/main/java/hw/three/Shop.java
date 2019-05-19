package hw.three;

public class Shop
{
    private static double cashbox_ = 0;
    private static Shop shop_;

    private Shop()
    {
    }

    public static Shop getShopInstance()
    {
        return shop_ == null ? new Shop() : shop_;
    }

    public void addMoneytoCashbox(double money)
    {
        cashbox_ += money;
    }

    public double calculateMoneyInCashbox()
    {
        return cashbox_;
    }
}
