package com.goevents.w2051767_goevents.CLI;

import com.fasterxml.jackson.databind.util.JSONPObject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;

public class Config{
    protected static int totalTicketCount;
    //need to be the same value to others too
    private static int maxTicketCount;
    private static int ticketReleaseRate;
    private static int customerRetrivalRate;

    protected static final Logger logger = LogManager.getLogger();

    //Validator validateInput = new Validator();

    //for the Angulare part need to create a clean constructor then set each value there

    public Config(){
        setMaxTicketCount();
        setTotalTicketCount();;
        setTicketReleaseRate();
        setCustomerRetrivalRate();
    }

    public static int getTotalTicketCount() {
        return totalTicketCount;
    }

  public static void setTotalTicketCount(int totalTicketCount){
      Config.totalTicketCount = totalTicketCount;

  }

    public static void setTotalTicketCount() {
        //Validator validateInput = new Validator();
        //used static method here otherwise need to create multiple objects
        while(true){
            totalTicketCount = Validator.intValidator("\u001B[32mEnter Total Ticket Count : \u001B[0m","\u001B[31mTotal ticket count needs to be an integer\u001B[0m");
            if(totalTicketCount>0 && totalTicketCount<=Config.maxTicketCount){

                //Config.totalTicketCount = totalTicketCount;
                break;
            }
            else{
                System.out.println("\u001B[31mInvalid Total Ticket Count ! It should be less than or equal the Total ticket count and a positive number\u001B[0m");
            }
        }


    }

    public static int getMaxTicketCount() {
        return maxTicketCount;
    }

    public static void setMaxTicketCount(int maxTicketCount){
        Config.maxTicketCount = maxTicketCount;
    }

    public static void setMaxTicketCount() {
        while(true){
            maxTicketCount = Validator.intValidator("\u001B[32mEnter Max Ticket Count : \u001B[0m","\u001B[31mTotal ticket count needs to be an integer\u001B[0m");

            if(maxTicketCount>0 && maxTicketCount>=totalTicketCount){

                //Config.maxTicketCount = maxTicketCount;
                break;

            }
            else{
                System.out.println("\u001B[31mInvalid Max Ticket Count ! It should be higher than or equal the Total ticket count and a positive number\u001B[0m");

            }
        }

    }

    public static int getTicketReleaseRate() {
        return ticketReleaseRate;
    }
    public static void setTicketReleaseRate(int ticketReleaseRate){
        Config.ticketReleaseRate = ticketReleaseRate;
    }

    public static void setTicketReleaseRate() {
        while(true){
            ticketReleaseRate = Validator.intValidator("\u001B[32mEnter Ticket Release Rate per 1 second : \u001B[0m","\u001B[31mTotal Ticket Release Rate needs to be an integer\u001B[0m");
            if(ticketReleaseRate>0 && ticketReleaseRate<=maxTicketCount){
                //this.ticketReleaseRate = ticketReleaseRate;
                break;
            }
            else{
                System.out.println("\u001B[31mInvalid Ticket Release Rate ! It should be less than or equal the Total ticket count and a positive number\u001B[0m");
            }
        }

    }

    public static int getCustomerRetrivalRate() {
        return customerRetrivalRate;
    }

    public static void setCustomerRetrivalRate(int customerRetrivalRate){
        Config.customerRetrivalRate = customerRetrivalRate;
    }

    public static void setCustomerRetrivalRate() {

        while(true){
            customerRetrivalRate = Validator.intValidator("\u001B[32mEnter Customer Retrieve Rate per 1 second : \u001B[0m","\u001B[31mTotal Ticket Release Rate needs to be an integer\u001B[0m");

            if(customerRetrivalRate>0 && customerRetrivalRate<totalTicketCount){
                //this.customerRetrivalRate = customerRetrivalRate;
                break;
            }
            else{
                System.out.println("\u001B[31mInvalid Customer Retrieve Rate ! It should be higher than or equal the Total ticket count and a positive number\u001B[0m");
//                logger.info("\u001B[31mInvalid Customer Retrieve Rate ! It should be higher than or equal the Total ticket count and a positive number\u001B[0m");
            }
        }

    }


    public void objectToJSON(){
        JSONObject configDetails = new JSONObject();
        configDetails.put("Maximum Ticket Count ",Config.getMaxTicketCount());
        configDetails.put("Total Ticket Count ",Config.getTotalTicketCount());
        configDetails.put("Customer Retrieval Rate ",Config.getCustomerRetrivalRate());
        configDetails.put("Ticket Release Rate", Config.getTicketReleaseRate());

        try{
            FileWriter configDetailsFile = new FileWriter("/Users/geesadbandara/Desktop/Java/OOP CWK/w2051767_GoEvents/ConfigDetails.json");
            configDetailsFile.write(configDetails.toJSONString());
            configDetailsFile.close();

        }
        catch(IOException e){
            e.printStackTrace();

        }
    }


}
