Adapter Payments

We have FastPayClient and SafeCashClient which have diff method name and take diff attribute names. But both are for payments. Right now, we have if else,

if this payment method then implement this function and use constructors this way.

Instead we will have an Interface PaymentGateway.

We will make fastpay adapter and safecash adapter that make the clients compatible with the Payment Method Gateway.

In the OrderService, we will have a map/registry for paymentGateway which returns a paymentGateway for a string. Now we can directly call the charge method instead of if else

------------------------------------------------------------------------------------------------------------------------------------------------

OrderService directly depends on multiple payment SDKs like FastPayClient and SafeCashClient. Since their APIs are different, the service uses if/switch logic and 

custom glue code to call each one.

This tightly couples the service to specific providers and makes the code hard to extend.

Solution:

Introduce the Adapter Pattern. Define a common interface PaymentGateway with a method charge(customerId, amountCents). Create adapters like FastPayAdapter and 

SafeCashAdapter that implement this interface and internally call their respective SDKs. Now OrderService only depends on PaymentGateway, removing provider-specific 

logic and allowing new payment providers to be added without modifying OrderService.
