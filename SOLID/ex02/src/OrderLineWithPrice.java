public class OrderLineWithPrice 
{
    public final String itemName;
    public final int qty;
    public final double unitPrice;
    public final double lineTotal;

    public OrderLineWithPrice(String itemName, int qty, double unitPrice) 
    {
        this.itemName = itemName;
        this.qty = qty;
        this.unitPrice = unitPrice;
        this.lineTotal = qty * unitPrice;
    }
}
// Ye enriched order line hai jo price calculation ko encapsulate karta hai, taaki checkout method me raw math scatter na ho aur responsibility clear rahe