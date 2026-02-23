public class StudentDiscountRules implements DiscountRules 
{
    @Override
    public double calcDisc(double subtotal, int distinctLines) 
    {
        if (subtotal >= 180.0) {
            return 10.0;
        }
        return 0.0;
    }
}