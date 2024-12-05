package com.goevents.w2051767_goevents.CLI;

import java.util.ArrayList;

public class Vendor extends User implements Runnable {
    public Vendor(String name, int vendorID){
        super(name,vendorID);
    }
    @Override
    public synchronized void run(){
//        Config.setTotalTicketCount(TicketPool.addTicket(Config.getTotalTicketCount(),Config.getMaxTicketCount(),Config.getTicketReleaseRate()));
        while(true){
            //Config.setTotalTicketCount(TicketPool.addTicket(Config.getTotalTicketCount(),Config.getMaxTicketCount(),Config.getTicketReleaseRate()));
            Config.totalTicketCount = TicketPool.addTicket(Config.getTotalTicketCount(),Config.getMaxTicketCount(),Config.getTicketReleaseRate(),super.getName());

            try{
                Thread.sleep(1000);
            }
            catch (InterruptedException e) {
                //throw new RuntimeException(e);
                System.out.println("Thread Interrupted");
                break;
            }
            catch (Exception k){
                System.out.println("Thread Interrupted");
            }
        }


    }

}
