package DesignPatterns.Singleton;

import java.lang.reflect.InaccessibleObjectException;

import org.w3c.dom.ls.LSException;

import arrays.TheBirhdayBar;

public class SingletonSimple extends Thread {

    public static void main(String[] args) {
        System.out.println("If you see the same value, then singleton was reused (yay!)" + "\n" +
                "If you see different values, then 2 singletons were created (booo!!)" + "\n\n" +
                "RESULT:" + "\n");

        // Singleton singleton = Singleton.getInstance("FOO");
        // Singleton anotherSingleton = Singleton.getInstance("BAR");

        Thread threadFoo = new Thread(new ThreadFoo());
        Thread threadBar = new Thread(new ThreadBar());

        threadFoo.start();
        threadBar.start();

        // System.out.println(singleton.value);
        // System.out.println(anotherSingleton.value);
    }

    public final static class Singleton {
        private static  Singleton instance;
        private String value;

        private Singleton(String value) {
            this.value = value;
        }

        public static Singleton getInstance(String vale) {

          
            if (instance != null) {
                return instance;
            }

            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new  Singleton(vale);
                }
            }

            return instance;
        }

    }

    static class ThreadBar implements Runnable {
        @Override
        public void run() {
            Singleton singleton = Singleton.getInstance("BAR");
            System.out.println(singleton.value);
        }
    }

    static class ThreadFoo implements Runnable {
        @Override
        public void run() {
            Singleton singleton = Singleton.getInstance("FOO");
            System.out.println(singleton.value);
        }
    }

}
