package main.java.client;

public class ClientUtil implements Runnable {

    String id;
    String productName;

    public ClientUtil() { }

    public ClientUtil(String id) {
        this.id = id;
    }

    @Override
    public void run() {
        System.out.println("Running Client Thread");
        // Curl request to get the name of the id
        productName = "Get Product Name here";
    }

    public String getProductName() {
        return productName;
    }
}
