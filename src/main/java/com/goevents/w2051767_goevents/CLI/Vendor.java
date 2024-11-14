package com.goevents.w2051767_goevents.CLI;

public class Vendor extends User implements Runnable {
    public Vendor(String name, int vendorID){
        super(name,vendorID);
    }

    public synchronized void run(){
        Config.setTotalTicketCount(TicketPool.addTicket(Config.getTotalTicketCount(),Config.getMaxTicketCount(),Config.getTicketReleaseRate()));
        System.out.println(TicketPool.getTicketPool().toString());

        try{
            Thread.sleep(1000);
        }
        catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
