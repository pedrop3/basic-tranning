public class Hiding {

    static class BaseClass {
        public int dataMember = 10;

        public void display() {
            System.out.println("Base Class Data Member: " + dataMember);
        }
    }

    static class DerivedClass extends BaseClass {
        public int dataMember = 20; // 'hiding''or 'shadowing' 

        public void display() {
            System.out.println("Derived Class Data Member: " + dataMember);
        }
    }

    public static void main(String[] args) {
        BaseClass baseObject = new BaseClass();
        DerivedClass derivedObject = new DerivedClass();

        System.out.println("Accessing Base Class Data Member from Base Class: " + baseObject.dataMember);
        System.out.println("Accessing Derived Class Data Member from Derived Class: " + derivedObject.dataMember);

        // Accessing through base class reference
        BaseClass reference = derivedObject;
        System.out.println("Accessing Base Class Data Member from Derived Class Reference: " + reference.dataMember);

        // Calling overridden methods
        baseObject.display();
        derivedObject.display();
        reference.display();
    }

}
