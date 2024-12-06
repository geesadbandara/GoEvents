package com.goevents.w2051767_goevents.backend.services;

import com.goevents.w2051767_goevents.CLI.TicketPool;
import com.goevents.w2051767_goevents.backend.components.SystemConfigComponent;
import com.goevents.w2051767_goevents.backend.components.TicketComponent;

import java.util.NoSuchElementException;
import java.util.Vector;

public class TicketManagementService extends SystemConfigComponent{

    private static Vector<Integer> ticketPool;

    public TicketManagementService(int maxTicketPoolSize, int totalTicketPool, int ticketRetrievalRate, int ticketReleaseRate) {
        super(maxTicketPoolSize, totalTicketPool, ticketRetrievalRate, ticketReleaseRate);
        //TicketManagementService.ticketPool = ticketPool;
    }

    public static void setTicketPool(){
        int incPoolSize = SystemConfigComponent.maxTicketPoolSize - SystemConfigComponent.totalTicketPool;
        ticketPool = new Vector<>(SystemConfigComponent.totalTicketPool,incPoolSize);
    }

    public static int addTicket(int totalPoolSize, int maxPoolSize, int ticketReleaseRate, String vendorName){
        int loopCount = 0;
        while(loopCount<ticketReleaseRate){
            TicketManagementService.ticketPool.add(1);
            System.out.println("Ticket Added");
            loopCount++;
            totalPoolSize++;


        }

        return totalPoolSize;
    }

    public static int buyTicket(int totalPoolSize, String consumerName, int ticketRetrievalRate) {
        int loopCount = 0;
        while(loopCount<ticketRetrievalRate){
            try{
                TicketManagementService.ticketPool.removeFirst();
                System.out.println("Removed a ticket");
            }
            catch (ArrayIndexOutOfBoundsException e){
                System.out.println("No such ticket available");
                break;
            }
            catch(NoSuchElementException k){
                System.out.println("No such ticket available");
                break;
            }
            loopCount++;
            totalPoolSize--;


        }
        return totalPoolSize;


    }


}
