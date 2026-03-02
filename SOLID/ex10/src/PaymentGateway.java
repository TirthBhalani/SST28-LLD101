public class PaymentGateway implements IPaymentGateway {
    @Override
    public String charge(String studentId, double amount) {
        // Logic to process the transaction
        return "TXN-9001";
    }
}