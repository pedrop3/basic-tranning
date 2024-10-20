package DesignPatterns.AbstractFactory;

// Animal é a interface para os produtos (animais) que serão criados.
// Cachorro e Gato são classes concretas que implementam a interface Animal.
// AnimalFactory é a interface da fábrica abstrata que declara um método para criar um animal.
// CachorroFactory e GatoFactory são fábricas concretas que implementam AnimalFactory e são responsáveis por criar instâncias específicas de Cachorro e Gato, respectivamente.

// Abstract Product: Animal
interface Animal {
    String getNome();

    String fazerSom();
}

// Concrete Products
class Cachorro implements Animal {

    @Override
    public String getNome() {
        return "Cachorro";
    }

    @Override
    public String fazerSom() {
        return "Au au!";
    }
}

class Gato implements Animal {

    @Override
    public String getNome() {
        return "Gato";
    }

    @Override
    public String fazerSom() {
        return "Miau!";
    }
}

// Abstract Factory
public class AbstractFactory {
    // Static Concrete Factories
    static class CachorroFactory implements AnimalFactory {
        @Override
        public Animal criarAnimal() {
            return new Cachorro();
        }
    }

    static class GatoFactory implements AnimalFactory {
        @Override
        public Animal criarAnimal() {
            return new Gato();
        }
    }

    // Interface of the Abstract Factory
    interface AnimalFactory {
        Animal criarAnimal();
    }

    public static void main(String[] args) {
        AnimalFactory fabricaCachorro = new CachorroFactory();
        Animal cachorro = fabricaCachorro.criarAnimal();
        System.out.println("Tipo: " + cachorro.getNome() + ", Som: " + cachorro.fazerSom());

        AnimalFactory fabricaGato = new GatoFactory();
        Animal gato = fabricaGato.criarAnimal();
        System.out.println("Tipo: " + gato.getNome() + ", Som: " + gato.fazerSom());
    }
}
