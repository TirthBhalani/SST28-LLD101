First make the constructor private. so that no one can call the Constructor
Double-Checked Locking
added the volatile keyword -> instead of local cache, we push the changes directly. all 3 steps of new object creation happen in one go.

using a concurrent hashmap ->Moves locking from the method level to the bucket level, allowing multiple threads to read/write different keys simultaneously without blocking the whole class.


we make the class implement serializable


Reflection Attack
What it is: Java Reflection is a powerful API that allows a program to inspect and modify its own behavior at runtime. Even if a constructor is private, an attacker can use setAccessible(true) to bypass that visibility and call new MetricsRegistry().

How we prevented it: In our new constructor, we check if instance is already set:

private MetricsRegistry() {
    if (instance != null) {
        throw new RuntimeException("Use getInstance()...");
    }
}


------------------------------------------------------------------------------------------

Serialization & Deserialization Attack
What it is: * Serialization: Converting an object into a stream of bytes (to save to a file or send over a network).

Deserialization: Converting those bytes back into a Java object.

The "Attack": By default, the readObject() method used during deserialization creates a brand new instance of the class, completely ignoring the private constructor and the static instance variable. This breaks the Singleton contract.

How you prevented it:
You added the readResolve() method:

Java
protected Object readResolve() {
    return getInstance();
}
When Java's deserialization mechanism sees this method, it ignores the newly created "ghost" object and returns the existing getInstance() instead. The ghost object is then garbage collected.


xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
Thread-Safety (Double-Checked Locking)
The way you implemented getInstance() is the gold standard for lazy-loaded singletons.

First Check: If the instance exists, return it immediately (no expensive locking).

Synchronized Block: If not, lock the class so only one thread can proceed.

Second Check: Inside the lock, check again. This is crucial because a second thread might have been waiting at the lock while the first thread finished creating the instance.