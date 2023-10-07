public class Idempotente {
    private int contador = 0;

    public synchronized void incrementarContador() {
        contador++;
    }

    public int obterContador() {
        return contador;
    }

    public static void main(String[] args) {
        Idempotente exemplo = new Idempotente();

        exemplo.incrementarContador();

        exemplo.incrementarContador();

        int valor = exemplo.obterContador();
        System.out.println("Valor do contador: " + valor);
    }
}