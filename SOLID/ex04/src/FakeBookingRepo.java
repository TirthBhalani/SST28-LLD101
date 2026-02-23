public class FakeBookingRepo implements BookingRepository 
{
    @Override
    public void save(String id, BookingRequest req, Money monthly, Money deposit) 
    {
        System.out.println("Saved booking: " + id);
    }
}
// Ye fake repo demo/testing ke liye hai, taaki real DB ke bina bhi booking flow run ho sake aur abstraction maintain rahe