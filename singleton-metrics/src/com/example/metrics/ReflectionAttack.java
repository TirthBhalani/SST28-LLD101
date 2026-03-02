package com.example.metrics;

import java.lang.reflect.Constructor;

public class ReflectionAttack {
    public static void main(String[] args) throws Exception {
        MetricsRegistry singleton = MetricsRegistry.getInstance();
        Constructor<MetricsRegistry> ctor = MetricsRegistry.class.getDeclaredConstructor();
        ctor.setAccessible(true);

        try {
            MetricsRegistry evil = ctor.newInstance();
            System.out.println("Evil identity: " + System.identityHashCode(evil));
        } catch (Exception e) {
            System.out.println("Attack blocked: " + e.getCause().getMessage());
        }
    }
}