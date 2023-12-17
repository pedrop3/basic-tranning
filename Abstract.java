import java.lang.reflect.AnnotatedArrayType;

/**
 * Abstract
 */
public class Abstract {

    public static void main(String[] args) {

        Dog dog = new Dog(true);
        dog.makeSoud();
        dog.isMammal();


    }

    abstract static class Aninal {

        private boolean mammal;

        public Aninal(boolean mammal) {
            this.mammal = mammal;
        }

        public abstract void makeSoud();

        public void isMammal() {
            System.out.println("Mammal: " + this.mammal);
        }

    }

    public static class Dog extends Aninal {

        public Dog(boolean mammal) {
            super(mammal);
        }

        @Override
        public void makeSoud() {
            System.out.println("Auau");
        }

    }

}
