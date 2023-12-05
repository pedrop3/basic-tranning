package Datas;

class Main extends Thread {
    public static void main(String[] args) {
        Main thread = new Main();
        thread.start();
        for (int k = 1; k <= 5; k++) {
            System.out.println("A" + k);
            try {
                Thread.sleep(1100);
            } catch (InterruptedException ex) {
            }
        }
    }

    public void run() {
        for (int k = 1; k <= 5; k++) {
            try {
                Thread.sleep(700);
            } catch (InterruptedException ex) {
            }
            System.out.println("B" + k);
        }
    }

    

}