package com.example.metrics;


import java.io.Serial;
import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


public class MetricsRegistry implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    // volatile ensures visibility across threads for Double-Checked Locking
    private static volatile MetricsRegistry instance;
    
    // Using ConcurrentHashMap for better thread safety without locking the whole map
    private final Map<String, Long> counters = new ConcurrentHashMap<>();

    /*
      Private constructor to prevent external instantiation.
      Guarded against reflection-based attacks.
     */
    private MetricsRegistry() {
        if (instance != null) {
            throw new RuntimeException("Use getInstance() method to get the single instance of this class.");
        }
    }

    /*
      Lazy-initialized Singleton using Double-Checked Locking.
     */
    public static MetricsRegistry getInstance() {
        if (instance == null) { // First check (no locking)
            synchronized (MetricsRegistry.class) {
                if (instance == null) { // Second check (with locking)
                    instance = new MetricsRegistry();
                }
            }
        }
        return instance;
    }

    public void setCount(String key, long value) {
        counters.put(key, value);
    }

    public void increment(String key) {
        // compute is atomic in ConcurrentHashMap
        counters.compute(key, (k, v) -> (v == null) ? 1L : v + 1);
    }

    public long getCount(String key) {
        return counters.getOrDefault(key, 0L);
    }

    public Map<String, Long> getAll() {
        return Collections.unmodifiableMap(new HashMap<>(counters));
    }

    /*
      Preserves Singleton property during Deserialization.
     */
    @Serial
    protected Object readResolve() {
        return getInstance();
    }
}