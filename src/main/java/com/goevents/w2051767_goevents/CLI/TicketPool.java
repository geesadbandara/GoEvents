package com.goevents.w2051767_goevents.CLI;

import com.goevents.w2051767_goevents.MongoDB.Ticket;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.sound.midi.Soundbank;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Vector;

public class TicketPool {
    //private int incrementTickets = 0;
    private int totalPoolSize;
    private static int incPoolSize;
    private static Vector<Integer> ticketPool;
    protected static final Logger logger = LogManager.getLogger();

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
    public static int addTicket(int totalPoolSize, int maxPoolSize, int ticketReleaseRate, String vendorName){
        int loopCount = 0;
        while(loopCount<ticketReleaseRate){
            //System.out.println("Ticket Added");
            TicketPool.ticketPool.add(1);
            //System.out.println("Ticket Added by " +vendorName);
            logger.info("Ticket Added by " +vendorName);
            loopCount++;
            totalPoolSize++;


        }

        return totalPoolSize;
    }
    public static int removeTicket(int totalPoolSize, String consumerName, int ticketRetrivalRate) {
        int loopCount = 0;
        while(loopCount<ticketRetrivalRate){
            try{
            TicketPool.ticketPool.removeFirst();
            }
            catch (ArrayIndexOutOfBoundsException e){
                System.out.println("No such ticket available");
                break;
            }
            catch(NoSuchElementException k){
                System.out.println("No such ticket available");
                break;
            }
            //System.out.println("Ticket Purchased");
            //System.out.println("Ticket Purchased by "+ consumerName);
            logger.info("Ticket Purchased by "+ consumerName);
            loopCount++;
            totalPoolSize--;

//            catch (ArrayIndexOutOfBoundsException e){
//                System.out.println("No such ticket available");
//                break;
//            }


        }
        return totalPoolSize;


    }
    public void increseVendorCount(){
        //add the vendor to the existing array for that take , the array as well as the created vendor as the input
        //in vendorclass create a method call create a vendor and inside that call this one also ? so the
        //vendor class method needs to take the array as the parameter.
    }

}
