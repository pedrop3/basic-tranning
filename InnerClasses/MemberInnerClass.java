package InnerClasses;

public class MemberInnerClass {
    public static void main(String[] args) {
        OuterClass outer = new OuterClass();
        OuterClass.InnerClass inner = outer.new InnerClass();
        inner.display();
    }
}

class OuterClass {
    private String outerField = "Outer field";

    class InnerClass {
        void display() {
            System.out.println("Accessing from inner class: " + outerField);
        }
    }
}