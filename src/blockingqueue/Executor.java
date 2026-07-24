package blockingqueue;

import java.util.concurrent.BlockingQueue;

public class Executor {

    static void main() {

        BlockingQueue<Integer> blockingQueue = new java.util.concurrent.ArrayBlockingQueue<>(10);
        Producer producer = new Producer(blockingQueue);
        Consumer consumer = new Consumer(blockingQueue);


        Thread producerThread = new Thread(producer);
        Thread consumerThread = new Thread(consumer);

        producerThread.start();
        consumerThread.start();
    }
}
