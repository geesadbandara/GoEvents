package com.goevents.w2051767_goevents.backend.services;

import com.goevents.w2051767_goevents.CLI.TicketPool;
import com.goevents.w2051767_goevents.backend.components.SystemConfigComponent;
import com.goevents.w2051767_goevents.backend.components.TicketComponent;

import java.util.NoSuchElementException;
import java.util.Vector;

public class TicketManagementService extends SystemConfigComponent{

    protected static Vector<Integer> ticketPool;

    public TicketManagementService(int maxTicketPoolSize, int totalTicketPool, int ticketRetrievalRate, int ticketReleaseRate) {
        super(maxTicketPoolSize, totalTicketPool, ticketRetrievalRate, ticketReleaseRate);
        //TicketManagementService.ticketPool = ticketPool;
    }

    public static void setTicketPool(){
        int incPoolSize = SystemConfigComponent.maxTicketPoolSize - SystemConfigComponent.totalTicketPool;
        ticketPool = new Vector<>(SystemConfigComponent.totalTicketPool,incPoolSize);

        for(int i = 0; i<totalTicketPool;i++){
            TicketManagementService.ticketPool.add(1);
        }
    }

    public static int addTicket(int totalPoolSize, int maxPoolSize, int ticketReleaseRate, String customerName){
        int loopCount = 0;
        System.out.println(TicketManagementService.ticketPool.size());


        while(loopCount<ticketReleaseRate){
            //if(SystemConfigComponent.totalTicketPool<SystemConfigComponent.maxTicketPoolSize){}
            if((SystemConfigComponent.getTotalTicketPool()+SystemConfigComponent.getTicketReleaseRate())>=SystemConfigComponent.getMaxTicketPoolSize()){
                continue;
            }
            TicketManagementService.ticketPool.add(1);
            System.out.println("Ticket Added");

            SystemConfigComponent.setSystemStatus("Added Tickets to the System");

            TicketComponent ticket = new TicketComponent(1,customerName);
            ticket.objectToJSON("/Users/geesadbandara/Desktop/Java/OOP CWK/w2051767_GoEvents/Loggins.json","Consumer","Purchased a ticket");
            ticket.addTicketDatabase();

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
                SystemConfigComponent.setSystemStatus("Purchased Ticket from the System");
                TicketComponent ticket = new TicketComponent();
                ticket.objectToJSON("/Users/geesadbandara/Desktop/Java/OOP CWK/w2051767_GoEvents/Loggins.json","Vendor","Added a ticket");
            }
            catch (ArrayIndexOutOfBoundsException e){
                //System.out.println("No such ticket available");
                e.printStackTrace();
                break;
            }
            loopCount++;
            totalPoolSize--;


        }
        return totalPoolSize;


    }


}
