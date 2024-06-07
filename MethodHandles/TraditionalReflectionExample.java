package MethodHandles;

import java.lang.reflect.Method;

public class TraditionalReflectionExample {

    public static void main(String[] args) throws Exception {
        // Get the class object for Calculator
        Class<?> calculatorClass = Calculator.class;

        // Get the method object for the add method
        Method addMethod = calculatorClass.getMethod("add", int.class, int.class);

        // Create an instance of Calculator
        Calculator calculator = new Calculator();

        // Invoke the add method using reflection
        int result = (int) addMethod.invoke(calculator, 5, 3);

        System.out.println("Result: " + result);
    }

}
