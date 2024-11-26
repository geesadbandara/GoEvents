package com.goevents.w2051767_goevents.CLI;

public class Vendor extends User implements Runnable {
    public Vendor(String name, int vendorID){
        super(name,vendorID);
    }
    @Override
    public synchronized void run(){
//        Config.setTotalTicketCount(TicketPool.addTicket(Config.getTotalTicketCount(),Config.getMaxTicketCount(),Config.getTicketReleaseRate()));
        while(Simulation.getSellTicketCount()<Config.getMaxTicketCount()){
            Config.setTotalTicketCount(TicketPool.addTicket(Config.getTotalTicketCount(),Config.getMaxTicketCount(),Config.getTicketReleaseRate()));


            try{
                Thread.sleep(1000);
            }
            catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }


    }

}
