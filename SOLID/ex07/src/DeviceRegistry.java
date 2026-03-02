import java.util.*;

public class DeviceRegistry {
    private final List<Object> devices = new ArrayList<>();

    public void add(Object d) { devices.add(d); }

    @SuppressWarnings("unchecked") //this is to avoid classcastexception
    public <T> T getFirstOfType(Class<T> type) {  //generic type paramter T
        for (Object d : devices) {
            if (type.isInstance(d)) return (T) d;   //checks if d is the instance of type that we passed
        }
        throw new IllegalStateException("Missing device of type: " + type.getSimpleName());
    }
}