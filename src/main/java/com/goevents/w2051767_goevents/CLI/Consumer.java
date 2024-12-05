package com.goevents.w2051767_goevents.CLI;

import java.util.Random;

public class Consumer extends User implements Runnable{
    public Consumer(String name, int ConsumerId){
        super(name,ConsumerId);

    }

    @Override
    public synchronized void run() {
        while(true) {

            Config.totalTicketCount = TicketPool.removeTicket(Config.getTotalTicketCount(), super.getName(), Config.getCustomerRetrivalRate());

            try {
                //System.out.println("Consumer Sleeping");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                //throw new RuntimeException(e);
                System.out.println("Thread Interrupted");
                break;
            }
            catch (Exception k){
                System.out.println("Thread Interrupted");
            }
            notifyAll();
        }


    }
}
