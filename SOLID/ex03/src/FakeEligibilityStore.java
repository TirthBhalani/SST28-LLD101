public class FakeEligibilityStore implements EligibilityRepository 
{
    @Override
    public void save(String rollNo, String status) 
    {
        System.out.println("Saved evaluation for roll=" + rollNo);
    }
}
// Ye fake implementation sirf demo/testing ke liye hai, taaki real database ke bina bhi repository contract follow ho sake