package MethodHandles;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

public class MethodHandlesExample {

    public static void main(String[] args) throws Throwable {
        // Create a method handle for the add method of Calculator class
        MethodHandles.Lookup lookup = MethodHandles.lookup();
        MethodHandle addHandle = lookup.findVirtual(Calculator.class, "add",
                MethodType.methodType(int.class, int.class, int.class));

        // Create an instance of Calculator
        Calculator calculator = new Calculator();

        // Invoke the add method using method handle
        int result = (int) addHandle.invokeExact(calculator, 5, 3);

        System.out.println("Result: " + result);
    }
}
