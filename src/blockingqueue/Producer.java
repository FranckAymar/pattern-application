package blockingqueue;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable{

    private final BlockingQueue<Integer> blockingQueue;

    public Producer(BlockingQueue blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {

        while(true){
            try {
                blockingQueue.put(new Integer(1));
                System.out.println("Produced an item");

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
