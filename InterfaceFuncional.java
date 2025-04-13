import java.util.List;
import java.util.stream.Collectors;


@FunctionalInterface
interface Calculadora<T> {
    T calcular(T a, T b);
}

@FunctionalInterface
interface NumberPair<T> {
    boolean isEven(T t);
}

@FunctionalInterface
interface StringLength<T> {
    int length(T t);
}

@FunctionalInterface
interface ConsumerString<T> {
    void consume(T t);
}


public class InterfaceFuncional {

    public static void main(String[] args) {
        Calculadora<Integer> soma = (a, b) -> a + b;
        System.out.println("Soma: " + soma.calcular(3, 4));

        predicateAction();
        functionAction();
        consumerAction();
    }

    // Método demonstrando o uso da interface NumberPair com Stream.filter
    private static void predicateAction() {
        List<Integer> integerList = List.of(1, 2, 3, 4, 5);
        NumberPair<Integer> isEven = number -> number % 2 == 0;

        List<Integer> pares = integerList.stream()
                .filter(isEven::isEven)
                .collect(Collectors.toList());

        System.out.println("Números pares: " + pares); // Saída: [2, 4]
    }

    // Método demonstrando o uso da interface StringLength com Stream.map
    private static void functionAction() {
        List<String> names = List.of("Pedro", "Ana", "Carlos");
        StringLength<String> stringLength = s -> s.length();

        List<Integer> lengths = names.stream()
                .map(stringLength::length)
                .collect(Collectors.toList());

        System.out.println("Tamanhos dos nomes: " + lengths); // Saída: [5, 3, 6]
    }

    // Método demonstrando o uso da interface ConsumerString com Stream.forEach
    private static void consumerAction() {
        List<String> names = List.of("Pedro", "Ana", "Carlos");
        ConsumerString<String> stringConsumer = s -> System.out.println("Nome: " + s);

        names.forEach(stringConsumer::consume);
    }
}
