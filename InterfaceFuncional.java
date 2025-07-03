import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.*;
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

@FunctionalInterface
interface BiPredicate<T, U> {
    boolean consume(T t, U u);
}

@FunctionalInterface
interface BiComsumer<T, U> {
    boolean consume(T t, U u);
}

public class InterfaceFuncional {

    public static void main(String[] args) {
        Calculadora<Integer> soma = (a, b) -> a + b;
        System.out.println("Soma: " + soma.calcular(3, 4));

        predicateAction();
        functionAction();
        consumerAction();
        biPredicateAction();
        biComsumerAction();
        unaryBinaryOperator();
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

    private static void biPredicateAction() {
        BiPredicate<String, String> stringBiPredicate = (s1, s2) -> s1.equals(s2);
        var case1 =  stringBiPredicate.consume("Pedro", "Pedro");
        var case2 = stringBiPredicate.consume("Pedro", "Ana");

        System.out.println(case1);
        System.out.println(case2);

    }

    private static void biComsumerAction() {
        // Consumer<T> is a functional interface i.e. one abstract method:
        //      void accept(T t)
        Consumer<String> printC = s -> System.out.println(s);// lambda
        printC.accept("To be or not to be, that is the question");

        List<String> names = new ArrayList<>();
        names.add("John");names.add("Mary");
        names.forEach(printC);  // John, Mary

        // BiConsumer<T, U> is a functional interface i.e. one abstract method:
        //      void accept(T t, U u)
        Map mapCapitalCities = new HashMap<String, String>();
        // Note: The return value of put(k,v) is just ignored (and not returned from the lambda)
        BiConsumer<String, String> biCon = (key, value) -> mapCapitalCities.put(key, value);

        biCon.accept("Dublin", "Ireland");
        biCon.accept("Washington D.C.", "USA");
        System.out.println(mapCapitalCities);// {Dublin=Ireland, Washington D.C.=USA}

        BiConsumer<String, String> mapPrint = (key, value) ->
                System.out.println(key + " is the capital of: "+value);
        mapCapitalCities.forEach(mapPrint); // Dublin is the capital of: Ireland


        // Washington D.C. is the capital of: USA
    }

    private static void biFuctionAction() {
        // Function<T, R> is a functional interface i.e. one abstract method:
        //      R apply(T t)
        Function<String, Integer> fn2 = s -> s.length();
        System.out.println("Function: " + fn2.apply("Moscow"));// 6

        // BiFunction<T, U, R> is a functional interface i.e. one abstract method:
        //      R apply(T t, U u)
        BiFunction<String, String, Integer> biFn   = (s1, s2) -> s1.length() + s2.length();
        System.out.println("BiFunction: " + biFn.apply("William", "Shakespeare"));// 18

        BiFunction<String, String, String> biFn2   = (s1, s2) -> s1.concat(s2);
        System.out.println("BiFunction: " + biFn2.apply("William ", "Shakespeare"));// William Shakespeare
    }

    public static void unaryBinaryOperator() {
        // UnaryOperator<T> extends Function<T, T> is a functional interface i.e. one abstract method:
        //      T apply(T t)
        UnaryOperator<String> unaryOp = name -> "My name is "+name;
        System.out.println("UnaryOperator: " + unaryOp.apply("Sean"));// My name is Sean

        // BinaryOperator<T> extends BiFunction<T, T, T> is a functional interface i.e. one abstract method:
        //      T apply(T t1, T t2)
        BinaryOperator<String> binaryOp   = (s1, s2) -> s1.concat(s2);
        System.out.println("BinaryOperator: " + binaryOp.apply("William ", "Shakespeare"));// William Shakespeare
    }
}
