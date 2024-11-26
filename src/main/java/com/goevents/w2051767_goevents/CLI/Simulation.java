package com.goevents.w2051767_goevents.CLI;

import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Simulation {

    private static int sellTicketCount = 0;

    public static int getSellTicketCount() {
        return sellTicketCount;
    }

    public static void setSellTicketCount(int sellTicketCount) {
        Simulation.sellTicketCount = sellTicketCount;
    }

    public void runSimulation(){
        System.out.println(
                "░██████╗░░█████╗░███████╗██╗░░░██╗███████╗███╗░░██╗████████╗░██████╗░░░██╗░░░░░██╗░░██╗\n" +
                "██╔════╝░██╔══██╗██╔════╝██║░░░██║██╔════╝████╗░██║╚══██╔══╝██╔════╝░░░██║░░░░░██║░██╔╝\n" +
                "██║░░██╗░██║░░██║█████╗░░╚██╗░██╔╝█████╗░░██╔██╗██║░░░██║░░░╚█████╗░░░░██║░░░░░█████═╝░\n" +
                "██║░░╚██╗██║░░██║██╔══╝░░░╚████╔╝░██╔══╝░░██║╚████║░░░██║░░░░╚═══██╗░░░██║░░░░░██╔═██╗░\n" +
                "╚██████╔╝╚█████╔╝███████╗░░╚██╔╝░░███████╗██║░╚███║░░░██║░░░██████╔╝██╗███████╗██║░╚██╗\n" +
                "░╚═════╝░░╚════╝░╚══════╝░░░╚═╝░░░╚══════╝╚═╝░░╚══╝░░░╚═╝░░░╚═════╝░╚═╝╚══════╝╚═╝░░╚═╝");
        //Validator validateInput = new Validator();

        System.out.println("Press any key to quit the simulation after configuring the system!");

        System.out.println("System is configuring .........");


        //int getInt = validateInput.intValidator("Enter a integer", "This is not an integer");
        //System.out.println(getInt);

        //configValues.setTotalTicketCount();

        Config configValues = new Config();
        TicketPool.setTicketPool(Config.getTotalTicketCount(),Config.getMaxTicketCount());

        System.out.println("System Configured Successfully");
        System.out.println(TicketPool.getTicketPool().toString());





        //add a text to get input and the system rules
        //then can use scanner to get a input evrytime bfore an change the logic



//       Config.setTotalTicketCount(TicketPool.addTicket(Config.getTotalTicketCount(),Config.getMaxTicketCount(),5));
//        Config.setTotalTicketCount(TicketPool.addTicket(Config.getTotalTicketCount(),Config.getMaxTicketCount(),5));

        Scanner scanTrig = new Scanner(System.in);

        String systemTrigger = "";

        while((Simulation.getSellTicketCount()<Config.getMaxTicketCount())){
            Vendor vendor1 = new Vendor("Geesad",1);
            Thread threadGeesad = new Thread(vendor1);
            threadGeesad.start();

            Consumer consumer1 = new Consumer("Puppy",1);
            Thread threadPuppy = new Thread(consumer1);
            //consumer1.sleep(1000);
            threadPuppy.start();

            Vendor vendor2 = new Vendor("Geesad",2);
            Thread threadGeesad2 = new Thread(vendor2);
            threadGeesad2.start();

            Thread trigThread = new Thread(() -> {
                try{
                    Scanner trigScan = new Scanner(System.in);
                    //System.out.println("Checking Now");

                        if(System.in.available()>0){
                            System.out.println("System is quitting.......");
                            //threadGeesad.interrupt();
                            //threadGeesad2.interrupt();
                            //threadPuppy.interrupt();
                            System.exit(0);
                            //String trigValue = trigScan.nextLine();

//                            if(trigValue.equalsIgnoreCase("x")){
//                                System.exit(0);
//                                threadGeesad.interrupt();
//                                threadGeesad2.interrupt();
//                                threadPuppy.interrupt();
//                            }
//                            switch(trigValue){
//                                case "x":{
//                                    System.exit(0);
//                                }
//                            }
                            TimeUnit.MILLISECONDS.sleep(500);
                        }


                }
                catch(IOException | InterruptedException e){
                    e.printStackTrace();
                }
            }

            );
            //trigThread.setPriority(10);
            trigThread.start();



            try {
                threadGeesad.join();
                threadGeesad2.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }




            Consumer consumer2 = new Consumer("Puppy",2);
            Thread threadPuppy2 = new Thread(consumer2);
            threadPuppy2.start();

            //used join to make extra safe of accesing the pool at sam etime
            try {
                threadPuppy.join();
                threadPuppy2.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }




        //System.out.println(TicketPool.getTicketPool().toString());
        configValues.objectToJSON();


    }
}
