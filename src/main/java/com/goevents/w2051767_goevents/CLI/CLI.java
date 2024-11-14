package com.goevents.w2051767_goevents.CLI;

public class CLI{
    public static void main(String args[]){
        System.out.println("Hello");
        //Validator validateInput = new Validator();



        //int getInt = validateInput.intValidator("Enter a integer", "This is not an integer");
        //System.out.println(getInt);

        //configValues.setTotalTicketCount();

       Config configValues = new Config();
       TicketPool.setTicketPool(Config.getTotalTicketCount(),Config.getMaxTicketCount());
       System.out.println(TicketPool.getTicketPool().toString());

//       Config.setTotalTicketCount(TicketPool.addTicket(Config.getTotalTicketCount(),Config.getMaxTicketCount(),5));
//        Config.setTotalTicketCount(TicketPool.addTicket(Config.getTotalTicketCount(),Config.getMaxTicketCount(),5));

        Vendor vendor1 = new Vendor("Geesad",1);
        Thread threadGeesad = new Thread(vendor1);
        threadGeesad.start();

        Vendor vendor2 = new Vendor("Geesad2",2);
        Thread threadGeesad2 = new Thread(vendor1);
        threadGeesad2.start();

        System.out.println(TicketPool.getTicketPool().toString());
       configValues.objectToJSON();


    }
}
