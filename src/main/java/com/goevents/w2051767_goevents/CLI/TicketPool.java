package com.goevents.w2051767_goevents.CLI;

import java.util.Vector;

public class TicketPool {
    //private int incrementTickets = 0;
    private int totalPoolSize;
    private static int incPoolSize;
    private static Vector<Integer> ticketPool;

    public TicketPool(){
//        TicketManagement.totalPoolSize = totalPoolSize;
//        TicketManagement.incPoolSize = maxPoolSize - totalPoolSize;

        //TicketManagement.ticketPool((Config.getTotalTicketCount(),(Config.getMaxTicketCount() - Config.getTotalTicketCount()));
    }

    public static Vector<Integer> getTicketPool() {
        return ticketPool;
    }

    public static void setTicketPool(int totalPoolSize, int maxPoolSize) {
        TicketPool.incPoolSize = maxPoolSize - totalPoolSize;
        TicketPool.ticketPool = new Vector<>(totalPoolSize,incPoolSize);

        int ticketID = 0;
        while(ticketID<totalPoolSize){
            TicketPool.ticketPool.add(1);
            ticketID++;
        }
    }
    public static void addTicket(){

    }


}
