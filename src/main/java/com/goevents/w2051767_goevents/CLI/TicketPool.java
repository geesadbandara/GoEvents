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
        int ticketCount = 1;
        System.out.println(maxPoolSize);
        while(ticketCount<=ticketReleaseRate){

            if(totalPoolSize<maxPoolSize){
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
    public static void removeTicket(int selectedNumber,int totalPoolSize){

        if(selectedNumber<totalPoolSize && TicketPool.ticketPool.elementAt(selectedNumber)==1){
            //TicketPool.ticketPool.add(selectedNumber,0);
            System.out.println("Ticket Reserved : " +selectedNumber);
            TicketPool.ticketPool.removeElementAt(selectedNumber);
            TicketPool.ticketPool.insertElementAt(0,selectedNumber);
        }
        else{
            System.out.println("Ticket "+ selectedNumber +" Not Available !");
        }
    }

}
