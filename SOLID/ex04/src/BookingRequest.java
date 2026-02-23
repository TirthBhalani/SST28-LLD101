import java.util.*;

public class BookingRequest {
    public final int roomType;
    public final List<AddOn> addOns;

    public BookingRequest(int roomType, List<AddOn> addOns) {
        this.roomType = roomType;
        this.addOns = addOns;
    }
}
// Ye simple request model hai jo booking input data hold karta hai, taaki calculation logic clean aur structured data ke saath kaam kare