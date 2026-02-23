public class DeluxeRoomPricing implements RoomPricing 
{
    @Override
    public Money getMonthlyFee() 
    {
        return new Money(16000.0);
    }

    @Override
    public String getRoomType() {
        return "DELUXE";
    }
}
// Ye specific room pricing implementation hai jo Deluxe ka monthly fee encapsulate karti hai, so new room types easily add ho sakte bina calculator ko modify kiye