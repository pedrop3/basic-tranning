import java.lang.reflect.Array;
import java.util.ArrayList;

interface Calculadora {
    int calcular(int a, int b);
}

public class InterfaceFuncional implements Calculadora{
    public static void main(String[] args) {
        // Usando uma expressão lambda para implementar a interface funcional
        Calculadora soma = (a, b) -> a + b;
        
        System.out.println(soma.calcular(3, 4)); // Saída: 7
    }

    @Override
    public int calcular(int a, int b) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'calcular'");
    }
}
