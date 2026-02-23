import java.util.*;

public class Invoice 
{
    public final String invoiceId;
    public final List<OrderLineWithPrice> lines;
    public final double subtotal;
    public final double tax;
    public final double discount;
    public final double total;
    public final String taxDescription;

    public Invoice(String invoiceId, List<OrderLineWithPrice> lines, 
                   double subtotal, double tax, double discount, double total,
                   String taxDescription) 
    {
        this.invoiceId = invoiceId;
        this.lines = lines;
        this.subtotal = subtotal;
        this.tax = tax;
        this.discount = discount;
        this.total = total;
        this.taxDescription = taxDescription;
    }
}
// Ye Invoice ek pure data holder hai jo calculated values ko bundle karta hai, taaki formatting aur persistence layers cleanly is structured object pe kaam kare