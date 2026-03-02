LLD Refactoring: Student Club Management System
1. Problem Statement
The system manages administrative tasks for a student club, including financial tracking, meeting minutes, and event planning. Different roles (Treasurer, Secretary, Event Lead) use specific tools to perform these tasks.

2. Initial Design Architecture
Interface: A single "Fat Interface" named ClubAdminTools contained all administrative methods.

Linkage: Every role-specific tool class (TreasurerTool, SecretaryTool, EventLeadTool) was forced to implement this entire interface.

Usage: The ClubConsole instantiated these tools but treated them all as the same generic type, despite only calling subset of methods on each.

3. Issues with the Initial Design
ISP Violation: Objects were forced to depend on methods they did not use. An EventLeadTool had to have addIncome and addMinutes methods.

Dummy/No-op Implementations: Classes were filled with /* irrelevant */ comments and empty methods just to satisfy the compiler.

Fragility: Adding a new administrative capability (like "Member Management") would require modifying every single tool class to add a new dummy method.

Poor Readability: The intent of each tool was obscured by a "polluted" API containing unrelated methods.

Runtime Risks: A developer could accidentally call financial methods on a SecretaryTool, leading to silent failures or logically incorrect behavior.

4. The Solution: Interface Segregation
We applied the Interface Segregation Principle to create a cleaner, more modular architecture:

Splitting the Interface: We decomposed the fat interface into three lean, capability-based interfaces: FinanceTools, SecretaryTools, and EventTools.

Clean Implementation: Tools now only implement the interfaces that correspond to their actual responsibilities. TreasurerTool only deals with finance; it no longer "knows" about minutes or events.

Targeted Usage: The ClubConsole now interacts with tools through these specific interfaces. This provides better compile-time safety and ensures that a tool can only be used for its intended purpose.