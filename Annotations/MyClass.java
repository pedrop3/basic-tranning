package Annotations;

public class MyClass {

    @MyAnnotation(value = "Hello, World!", number = 5)
    public void myMethod() {
        System.out.println("This is myMethod");
    }

    public static void main(String[] args) {
        MyClass obj = new MyClass();
        obj.myMethod();

        // Accessing the annotation using reflection
        try {
            MyAnnotation annotation = obj.getClass()
                    .getMethod("myMethod")
                    .getAnnotation(MyAnnotation.class);
            if (annotation != null) {
                System.out.println("value: " + annotation.value());
                System.out.println("number: " + annotation.number());
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

}
