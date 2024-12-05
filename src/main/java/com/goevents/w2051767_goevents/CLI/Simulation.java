package com.goevents.w2051767_goevents.CLI;

import java.io.IOException;
import java.util.ArrayList;
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

        //Scanner scanTrig = new Scanner(System.in);

        //String systemTrigger = "";

        Vendor vendor1 = new Vendor("Geesad",1);
            Thread threadGeesad = new Thread(vendor1);
            //threadGeesad.start();

        Vendor vendor2 = new Vendor("Geesad",2);
            Thread threadGeesad2 = new Thread(vendor2);

        ArrayList<Thread> vendorThreads = new ArrayList<Thread>();
            vendorThreads.add(threadGeesad);
            vendorThreads.add(threadGeesad2);

        for(int i = 0; i <vendorThreads.size(); i++){
                vendorThreads.get(i).start();

            }

            //threadGeesad2.start();
//            ArrayList<Thread> consumerThreads = new ArrayList<>();
//            consumerThreads.add(threadPuppy);

        Consumer consumer1 = new Consumer("Puppy",1);
            Thread threadPuppy = new Thread(consumer1);
            //consumer1.sleep(1000);
            //threadPuppy.start();

        Consumer consumer2 = new Consumer("Puppy",2);
            Thread threadPuppy2 = new Thread(consumer2);

        ArrayList<Thread> consumerThreads = new ArrayList<>();
           consumerThreads.add(threadPuppy);
           consumerThreads.add(threadPuppy2);

        for(int i = 0; i <consumerThreads.size(); i++){
               consumerThreads.get(i).start();
          }
        Menu menu =new Menu(consumerThreads,vendorThreads);
        Thread menuThread = new Thread(menu);
        menuThread.start();

//        Thread trigThread = new Thread(() -> {
//            while(Simulation.getSellTicketCount()<Config.getMaxTicketCount()){
//                try{
//                    Scanner trigScan = new Scanner(System.in);
//                    //System.out.println("Checking Now");
//
//                        if(System.in.available()>0){
//                            System.out.println("Opening the menu.......");
//                            try{
//                                for(int i = 0; i <consumerThreads.size(); i++){
//                                    consumerThreads.get(i).wait();
//                                }
//                                for(int i = 0; i <vendorThreads.size(); i++){
//                                    vendorThreads.get(i).wait();
//
//                                }
//
//                            }
//                            catch (Exception e){
//                                e.printStackTrace();
//                            }
//                            int menueInput = trigScan.nextInt();
//                            switch (menueInput){
//                                case 1: //quit the simulation
//                                {System.exit(0);}
//                                case 2:
//                                {Vendor newVendor = new Vendor("HelloVendor", 3);
//                                    //ArrayList<Thread> newVendorArrayList = new ArrayList<>();
//                               newVendor.addVendor(newVendor,vendorThreads);
//                                    System.out.println(newVendor);
//                                    notifyAll();
//                                break;
//
//
//                                }
//                            }
//
//
//
//                            TimeUnit.MILLISECONDS.sleep(500);
//                        }
//                    Thread.sleep(1000);
//
//
//                }
//                catch(IOException | InterruptedException e){
//                    e.printStackTrace();
//                }
//            }
//    }
//
//            );
            //trigThread.setPriority(10);
            //trigThread.start();


//        while((Simulation.getSellTicketCount()<Config.getMaxTicketCount())){
//            Vendor vendor1 = new Vendor("Geesad",1);
//            Thread threadGeesad = new Thread(vendor1);
//            //threadGeesad.start();
//
//            Consumer consumer1 = new Consumer("Puppy",1);
//            Thread threadPuppy = new Thread(consumer1);
//            //consumer1.sleep(1000);
//            //threadPuppy.start();
//
//            Vendor vendor2 = new Vendor("Geesad",2);
//            Thread threadGeesad2 = new Thread(vendor2);
//            //threadGeesad2.start();
//            ArrayList<Thread> consumerThreads = new ArrayList<>();
//            consumerThreads.add(threadPuppy);
//
//
//            ArrayList<Thread> vendorThreads = new ArrayList<Thread>();
//            vendorThreads.add(threadGeesad);
//            vendorThreads.add(threadGeesad2);
//            for(int i = 0; i <vendorThreads.size(); i++){
//                vendorThreads.get(i).start();
//
//            }
//
//            Thread trigThread = new Thread(() -> {
//                try{
//                    Scanner trigScan = new Scanner(System.in);
//                    //System.out.println("Checking Now");
//
//                        if(System.in.available()>0){
//                            System.out.println("System is quitting.......");
//                            //threadGeesad.interrupt();
//                            //threadGeesad2.interrupt();
//                            //threadPuppy.interrupt();
//                            System.exit(0);
//                            //String trigValue = trigScan.nextLine();
//
////                            if(trigValue.equalsIgnoreCase("x")){
////                                System.exit(0);
////                                threadGeesad.interrupt();
////                                threadGeesad2.interrupt();
////                                threadPuppy.interrupt();
////                            }
////                            switch(trigValue){
////                                case "x":{
////                                    System.exit(0);
////                                }
////                            }
//                            TimeUnit.MILLISECONDS.sleep(500);
//                        }
//
//
//                }
//                catch(IOException | InterruptedException e){
//                    e.printStackTrace();
//                }
//            }
//
//            );
//            //trigThread.setPriority(10);
//            trigThread.start();
//
//
//
//            try {
//                for(Thread threadJoin : vendorThreads){
//                    threadJoin.join();
//                }
////                threadGeesad.join();
////                threadGeesad2.join();
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//
//
//
//
//            Consumer consumer2 = new Consumer("Puppy",2);
//            Thread threadPuppy2 = new Thread(consumer2);
//            //threadPuppy2.start();
//
//            consumerThreads.add(threadPuppy2);
//
//            for(int i = 0; i <consumerThreads.size(); i++){
//                consumerThreads.get(i).start();
//
//            }
//
//            //used join to make extra safe of accesing the pool at sam etime
//            try {
//                for(Thread threadJoin : consumerThreads){
//                    threadJoin.join();
//                }
////                threadPuppy.join();
////                threadPuppy2.join();
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//
//        }




        //System.out.println(TicketPool.getTicketPool().toString());
        configValues.objectToJSON();


    }
}
