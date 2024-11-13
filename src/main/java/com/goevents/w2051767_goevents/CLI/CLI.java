package com.goevents.w2051767_goevents.CLI;

public class CLI {
    public static void main(String args[]){
        System.out.println("Hello");
        //Validator validateInput = new Validator();



        //int getInt = validateInput.intValidator("Enter a integer", "This is not an integer");
        //System.out.println(getInt);

        //configValues.setTotalTicketCount();

       Config configValues = new Config();
       TicketPool.setTicketPool(Config.getTotalTicketCount(),Config.getTotalTicketCount());
       System.out.println(TicketPool.getTicketPool().toString());

       configValues.objectToJSON();


    }
}
