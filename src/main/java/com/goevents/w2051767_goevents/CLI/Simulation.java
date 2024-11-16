package com.goevents.w2051767_goevents.CLI;

public class Simulation {

    private static int sellTicketCount = 0;

    public static int getSellTicketCount() {
        return sellTicketCount;
    }

    public static void setSellTicketCount(int sellTicketCount) {
        Simulation.sellTicketCount = sellTicketCount;
    }

    public void runSimulation(){
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
        while(Simulation.getSellTicketCount()<Config.getMaxTicketCount()){
            Vendor vendor1 = new Vendor("Geesad",1);
            Thread threadGeesad = new Thread(vendor1);
            threadGeesad.start();

            Consumer consumer1 = new Consumer("Puppy",1);
            Thread threadPuppy = new Thread(consumer1);
            threadPuppy.start();

            Vendor vendor2 = new Vendor("Geesad",2);
            Thread threadGeesad2 = new Thread(vendor1);
            threadGeesad2.start();

            try {
                threadGeesad.join();
                threadGeesad2.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }




            Consumer consumer2 = new Consumer("Puppy",2);
            Thread threadPuppy2 = new Thread(consumer2);
            threadPuppy2.start();
            try {
                threadPuppy.join();
                threadPuppy2.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }




        System.out.println(TicketPool.getTicketPool().toString());
        configValues.objectToJSON();


    }
}
