public class NoDiscountRules implements DiscountRules 
{
    @Override
    public double calcDisc(double subtotal, int distinctLines)
    {
        return 0.0;
    }
}