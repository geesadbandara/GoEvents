package com.goevents.w2051767_goevents.CLI;

import com.fasterxml.jackson.databind.util.JSONPObject;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;

public class Config {
    private static int totalTicketCount;
    //need to be the sam evalue to others too
    private static int maxTicketCount;
    private static int ticketReleaseRate;
    private static int customerRetrivalRate;

    //Validator validateInput = new Validator();

    public Config(){
        setMaxTicketCount();
        setTotalTicketCount();;
        setTicketReleaseRate();
        setCustomerRetrivalRate();
    }

    public static int getTotalTicketCount() {
        return totalTicketCount;
    }

    public static void setTotalTicketCount() {
        //Validator validateInput = new Validator();
        //used static method here otherwise need to create multiple objects
        while(true){
            totalTicketCount = Validator.intValidator("Enter Total Ticket Count","Total ticket count needs to be an integer");
            if(totalTicketCount>0 && totalTicketCount<=Config.maxTicketCount){

                //Config.totalTicketCount = totalTicketCount;
                break;
            }
            else{
                System.out.println("Invalid Total Ticket Count ! It should be less than or equal the Total ticket count and a positive number");
            }
        }


    }

    public static int getMaxTicketCount() {
        return maxTicketCount;
    }

    public static void setMaxTicketCount() {
        while(true){
            maxTicketCount = Validator.intValidator("Enter Max Ticket Count","Total ticket count needs to be an integer");

            if(maxTicketCount>0 && maxTicketCount>=totalTicketCount){

                //Config.maxTicketCount = maxTicketCount;
                break;

            }
            else{
                System.out.println("Invalid Max Ticket Count ! It should be higher than or equal the Total ticket count and a positive number");

            }
        }

    }

    public static int getTicketReleaseRate() {
        return ticketReleaseRate;
    }

    public static void setTicketReleaseRate() {
        while(true){
            ticketReleaseRate = Validator.intValidator("Enter Ticket Release Rate per []","Total Ticket Release Rate needs to be an integer");
            if(ticketReleaseRate>0 && ticketReleaseRate<(maxTicketCount-totalTicketCount)){
                //this.ticketReleaseRate = ticketReleaseRate;
                break;
            }
            else{
                System.out.println("Invalid Ticket Release Rate ! It should be higher than or equal the Total ticket count and a positive number");
            }
        }

    }

    public static int getCustomerRetrivalRate() {
        return customerRetrivalRate;
    }

    public static void setCustomerRetrivalRate() {

        while(true){
            customerRetrivalRate = Validator.intValidator("Enter Customer Retrieve Rate per []","Total Ticket Release Rate needs to be an integer");

            if(customerRetrivalRate>0 && customerRetrivalRate<totalTicketCount){
                //this.customerRetrivalRate = customerRetrivalRate;
                break;
            }
            else{
                System.out.println("Invalid Customer Retrieve Rate ! It should be higher than or equal the Total ticket count and a positive number");
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
