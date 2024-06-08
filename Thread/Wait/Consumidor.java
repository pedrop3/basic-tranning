package Thread.Wait;

class Consumidor implements Runnable {
    private Estoque estoque;
    private int id;

    public Consumidor(Estoque estoque, int id) {
        this.estoque = estoque;
        this.id = id;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                estoque.get();
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}