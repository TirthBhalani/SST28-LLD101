we made the constructor private of incident ticket. we introducted a new inner class called builder which has public setters. we removed setter of incident ticket. this inner class had a build method which first validates all fields and then makes a new object of ticket.

we will use this builder class to make new ticket and then tobuilder method to change the values which still keeps the ticket unchanged



11. IncidentTicket (The Object)
Fields: All fields are now private final. They must be initialized in the constructor and cannot be changed later.

Constructor: Changed from public to private. It now accepts a Builder object as its only argument.

No Setters: All setX() methods were deleted.

Defensive Copying: The tags list is now wrapped in Collections.unmodifiableList(new ArrayList<>(...)). This prevents anyone from adding/removing tags even if they have a reference to the list.

2. The Builder (The Creator)
Fluent API: Added a static inner Builder class with methods that return this, allowing for method chaining (.id().title().build()).

Validation: Moved all business logic (email checks, ID patterns, length limits) into the build() method.

toBuilder(): Added this method to the main class. It copies the current object's data back into a new Builder so you can "update" a field by creating a new instance.

3. TicketService (The Logic)
From Mutation to Transformation: Instead of modifying a ticket (void methods), the service now returns a new IncidentTicket for every operation.

Removed Validation: The service no longer needs to check if an email is valid because the Builder's build() method handles it automatically.

4. TryIt (The Proof)
State Integrity: It now proves that t1 remains exactly the same even after "assigning" or "escalating."

Error Handling: It now includes a try-catch block to show that the code will actively crash (throw UnsupportedOperationException) if someone tries to force a change to the tags list.