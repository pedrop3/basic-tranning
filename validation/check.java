package validation;

public class check {
    public static void main(String[] args) {

        Pessoa pessoa1 = new Pessoa();
        pessoa1.setId(1);
        pessoa1.setString("Pedro");

        Pessoa pessoa2 = new Pessoa();
        pessoa2.setId(1);
        pessoa2.setString("pedro");

        Carro carro = new Carro();
        carro.setId(1);
        carro.setString("Pedro");

        if (pessoa1.equals(pessoa1)) {
            System.out.println("true equals Object ");
        }

        if (pessoa1.equals(pessoa2)) {
            System.out.println("true equals Object ");
        }

        if (pessoa1 == pessoa2) {
            System.out.println("true");
        }

        if (pessoa1.getId() == pessoa2.getId()) {
            System.out.println("true getId ==");
        }

        if (pessoa1.getName() == pessoa2.getName()) { // Referencia do objeto
            System.out.println("true getName == ");
        }
        if (pessoa1.getName().equals(pessoa2.getName())) {
            System.out.println("true equals getName");
        }

        if (pessoa1.getName().equals(carro.getName())) {
            System.out.println("true equals getName carro");
        }

        if (pessoa1.getName() == carro.getName()) {
            System.out.println("true == getName carro");
        }

    }

}
