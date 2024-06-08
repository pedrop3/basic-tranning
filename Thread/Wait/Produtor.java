package Thread.Wait;

class Produtor implements Runnable {
    private Estoque estoque;
    private int id;

    public Produtor(Estoque estoque, int id) {
        this.estoque = estoque;
        this.id = id;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Produto produto = new Produto("Produto " + id + "-" + i);
                estoque.put(produto);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}