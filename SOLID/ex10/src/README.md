LLD Refactoring: Campus Transport Booking (DIP)
1. Problem Statement
The system handles campus ride bookings by coordinating distance calculations, driver assignments, and payments.

2. Initial Design Architecture
Initially, the TransportBookingService was a monolithic orchestrator:

The Linkage: It directly instantiated DistanceCalculator, DriverAllocator, and PaymentGateway inside its book() method.

The Coupling: The high-level booking flow was hostage to the specific implementations of these three services.

The Complexity: Business rules (pricing) were tangled with infrastructure calls (payment/allocation).

3. Issues with the Initial Design
DIP Violation: The high-level module depended on low-level concretes. If you wanted to swap a GPS-based distance calculator for a Manhattan-based one, you had to edit the core booking service.

Untestable Code: You couldn't test the book() method without triggering a "real" (simulated) payment or allocation.

Rigidity: Adding a new payment method (e.g., UPI vs. Card) required breaking open the TransportBookingService class.

Mixed Responsibilities: The service was responsible for both creating its tools and using them.

Violation of OCP: The system was not "open for extension" regarding new infrastructure providers.

4. The Fix: Dependency Inversion & Injection
We refactored the design to adhere to the Dependency Inversion Principle:

Abstractions Over Concretes: We introduced three interfaces (IDistanceCalculator, IDriverAllocator, IPaymentGateway). The TransportBookingService now only speaks to these interfaces.

Constructor Injection: Instead of the service creating its own dependencies, they are "injected" from the outside (in Main).

Decoupled Pricing: The pricing logic was isolated into a helper method, separating business math from infrastructure coordination.

Plug-and-Play: We can now swap out any component (e.g., using a MockPaymentGateway for testing) without touching a single line of code in the TransportBookingService.