package com.goevents.w2051767_goevents.CLI;

import javax.sound.midi.Soundbank;
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
    public static int addTicket(int totalPoolSize, int maxPoolSize, int ticketReleaseRate){
        int ticketCount = 0;

        while(ticketCount+1<=ticketReleaseRate){

            if(totalPoolSize+1<=maxPoolSize){
                TicketPool.ticketPool.add(1);
                System.out.println(totalPoolSize);
                System.out.println(TicketPool.getTicketPool().toString());
                totalPoolSize++;
                ticketCount++;
            }
            else{
                System.out.println("Can't add more ticket, Ticket Pool is full");
                break;
            }

            //or else we can assign the return value to the config class


        }
        System.out.println(Config.getTotalTicketCount());
        return totalPoolSize;
    }


}
