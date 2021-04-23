package main.java.client;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class MainThread implements Runnable {

    ThreadGroup threadGroup;
    ConcurrentHashMap<String, String> map;
    AtomicInteger currentIndex;
    List<String> ids;

    public MainThread() {
        threadGroup = new ThreadGroup("Main Thread Group");
        map = new ConcurrentHashMap<>();
        currentIndex = new AtomicInteger(0);
        ids = new ArrayList<>();

        // Get the list of id's which needs to be accessed
        ids.add("Pritam");
        ids.add("Helam");
        ids.add("Divyesh");
        ids.add("Bruyog");
        ids.add("Brahul");
        ids.add("Pritam1");
        ids.add("Helam1");
        ids.add("Divyesh1");
        ids.add("Bruyog1");
        ids.add("Brahul1");
        ids.add("Pritam");
        ids.add("Helam2");
        ids.add("Divyesh2");
        ids.add("Bruyog2");
        ids.add("Brahul2");
        ids.add("Pritam3");
        ids.add("Helam");
        ids.add("Divyesh3");
        ids.add("Bruyog3");
        ids.add("Brahul3");
    }

    public Map<String, String> getProductDetails() {
        return this.map;
    }

    @Override
    public void run() {
        System.out.println("The main thread is running");

        try {
            while (threadGroup.activeCount() < 5) {
                if (currentIndex.get() == ids.size()) {
                    return;
                }
                String id = ids.get(currentIndex.getAndIncrement());
                if (!map.containsKey(id)) {
                    map.put(id, "");
                    ClientUtil clientUtil = new ClientUtil(id);
                    Thread thread = new Thread(clientUtil);
                    thread.start();
                    thread.join();
                    map.put(id, clientUtil.getProductName());
                } else {
                    System.out.println("We are not creating any thread here :: " + id);
                }
            }
        } catch (Exception e) {
            System.out.println("Exception occured in MainThread");
            e.printStackTrace();
        }
    }
}



