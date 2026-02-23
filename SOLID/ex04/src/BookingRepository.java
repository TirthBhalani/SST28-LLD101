public interface BookingRepository 
{
    void save(String id, BookingRequest req, Money monthly, Money deposit);
}
// Ye repository abstraction booking persistence ko calculator se alag rakhta hai, so core logic storage se tightly coupled nahi hota