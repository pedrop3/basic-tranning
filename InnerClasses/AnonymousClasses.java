package InnerClasses;

/**
 * An anonymous class is a type of inner class with no name and is used to
 * instantiate objects with certain modifications, usually for immediate use. It
 * is often used when a class is needed only once, typically for implementing
 * interfaces or abstract classes.
 */
public class AnonymousClasses {

    interface Greeting {
        void sayHello();
    }

    public static void main(String[] args) {
        
        Greeting greeting = new Greeting() {
            @Override
            public void sayHello() {
                System.out.println("Hello from anonymous class!");
            }
        };

        greeting.sayHello();
    }


}
