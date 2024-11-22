package Interview;

class Animal {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void generateReport() {
        System.out.println("Animal report: " + name);
    }

    public void walk() {
        System.out.println(name + " is moving!");
    }
}

class Fish extends Animal {

    @Override
    public void walk() {
        System.out.println("Fish is moving!");
    }
}

public class Ex01 {
    public static void main(String[] args) {
        Animal tiger = new Animal();
        tiger.setName("Tiger");
        tiger.generateReport();
        tiger.walk();

        Animal goldfish = new Fish();
        goldfish.setName("Goldfish");
        goldfish.walk();
    }
}
