package main.java.client;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Starting Process");
        try {
            MainThread mainThread = new MainThread();
            Thread thread = new Thread(mainThread);
            thread.start();
            thread.join();
            System.out.println(mainThread.getProductDetails());
        } catch (InterruptedException e) {
            System.out.println("Exception in Main class");
            e.printStackTrace();
        }
    }

}
