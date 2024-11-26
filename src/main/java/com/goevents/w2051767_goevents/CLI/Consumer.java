package com.goevents.w2051767_goevents.CLI;

import java.util.Random;

public class Consumer extends User implements Runnable{
    public Consumer(String name, int ConsumerId){
        super(name,ConsumerId);

    }

    @Override
    public synchronized void run() {
        while(Simulation.getSellTicketCount()<Config.getMaxTicketCount()){
        int loopCount = 0;
        while (loopCount < Config.getCustomerRetrivalRate()) {
            Random randomNum = new Random();
            int randomTicket = randomNum.nextInt(Config.getTotalTicketCount());
            TicketPool.removeTicket(randomTicket, Config.getTotalTicketCount(), super.getName());

            loopCount++;

        }
        try {
            //System.out.println("Consumer Sleeping");
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


    }
}
