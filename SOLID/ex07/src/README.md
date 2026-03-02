LLD Refactoring: Smart Classroom Device System
1. Problem Statement
The system is designed to control various smart devices in a classroom (Projector, AC, Lights, Scanners) through a central ClassroomController. The goal is to automate the "Start Class" and "End Class" sequences by interacting with these devices.

2. Initial Design Architecture
Initially, the design utilized a Single Fat Interface strategy:

The SmartClassroomDevice Interface: This was a monolithic interface containing every possible method a device might need (powerOn, setBrightness, setTemperatureC, scanAttendance, connectInput).

Concrete Classes: Classes like AirConditioner and AttendanceScanner were forced to implement the entire interface.

The Controller: The ClassroomController treated every device as a generic SmartClassroomDevice, even though it knew it was calling specific methods like setTemperatureC only on certain objects.

3. Issues with the Initial Design
ISP (Interface Segregation Principle) Violation: This is the primary issue. No client (device) should be forced to depend on methods it does not use.

Dummy Implementations/Polluted Code: Classes like AirConditioner had to provide empty or "dummy" returns for scanAttendance() and setBrightness(). This clutters the codebase and leads to "Documentation-as-code" where we have to comment /* irrelevant */ everywhere.

Runtime Fragility: If a developer accidentally calls scanAttendance() on an AirConditioner object, the system won't crash, but it will return a misleading 0, leading to silent bugs.

Rigidity: Adding a new type of device (e.g., a Smart Blind) would require adding a method to the main interface, forcing a recompilation and update of every single other device class in the system.

Poor Modeling: The interface didn't represent a "contract" of what a device can do; it was just a bucket of all possible actions.

4. The Fix: Capability-Based Design
We refactored the design by moving from "What the object is" to "What the object can do":

Decomposition of Interfaces: We split the "Fat Interface" into five lean, focused interfaces: Powerable, BrightnessControllable, TemperatureControllable, AttendanceScannable, and InputConnectable.

Composition over Inheritance: Devices now pick and choose (implement) only the behaviors relevant to them.

Type-Safe Registry: We updated the DeviceRegistry to use Java Generics. Instead of passing strings like "Projector", we pass the actual class literal (Projector.class). This allows the controller to receive a typed object directly, eliminating the need for casting and reducing runtime errors.

Clean Controller: The ClassroomController now interacts with devices based on their specific capabilities. It is clear that the Projector is being used for its input capabilities, while the LightsPanel is used for its brightness.


explanation for device registry code change
1. The Argument: Projector.class
Instead of passing a String (like "Projector"), we are passing the Class Literal. In Java, this is a special object that contains the metadata for the Projector class. It tells the registry exactly what "blueprint" it is looking for.

2. The Generic Method Call
When you call getFirstOfType, the Registry's generic parameter <T> is automatically identified as Projector.

Registry Side: It sees you want something that matches the Projector type.

Search: It iterates through its internal list and uses type.isInstance(d) to find an object that was created as a Projector.

3. Automatic Type Casting
In previous versions of this exercise, you might have had to write:
Projector pj = (Projector) reg.getFirstOfType("Projector");