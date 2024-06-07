package AutoCloseable;

/**
 * The AutoCloseable interface in Java is designed for managing resources that
 * need to be closed after their use, such as files, database connections,
 * sockets, etc. It provides a single method:   
 */
public class Main {
    public static void main(String[] args) {
        // Using try-with-resources to manage MyResource
        try (MyResource res1 = new MyResource("Resource1");
                MyResource res2 = new MyResource("Resource2")) {

            res1.doSomething();
            res2.doSomething();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

class MyResource implements AutoCloseable {
    private String name;

    public MyResource(String name) {
        this.name = name;
        System.out.println(name + " opened.");
    }

    @Override
    public void close() {
        System.out.println(name + " closed.");
    }

    public void doSomething() {
        System.out.println("Doing something with " + name);
    }
}


