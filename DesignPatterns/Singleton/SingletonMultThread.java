package DesignPatterns.Singleton;

import DesignPatterns.Singleton.SingletonMultThread.Singleton.ThreadBar;
import DesignPatterns.Singleton.SingletonMultThread.Singleton.ThreadFoo;


public class SingletonMultThread {

    public static void main(String[] args) {
        System.out.println("If you see the same value, then singleton was reused (yay!)" + "\n" +
                "If you see different values, then 2 singletons were created (booo!!)" + "\n\n" +
                "RESULT:" + "\n");

        Thread threadFoo = new Thread(new ThreadFoo());
        Thread threadBar = new Thread(new ThreadBar());

        threadFoo.start();
        threadBar.start();

    }

    public final static class Singleton {
        private static Singleton instance;
        public String value;

        private Singleton(String value) {
            // The following code emulates slow initialization.
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            this.value = value;
        }

        public static Singleton getInstance(String value) {
            if (instance == null) {
                instance = new Singleton(value);
            }
            return instance;
        }

        static class ThreadFoo implements Runnable {
            @Override
            public void run() {
                Singleton singleton = Singleton.getInstance("FOO");
                System.out.println(singleton.value);
            }
        }

        static class ThreadBar implements Runnable {
            @Override
            public void run() {
                Singleton singleton = Singleton.getInstance("BAR");
                System.out.println(singleton.value);
            }
        }
    }

}
