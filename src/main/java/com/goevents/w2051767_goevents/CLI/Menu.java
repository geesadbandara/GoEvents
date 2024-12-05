package com.goevents.w2051767_goevents.CLI;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Menu implements Runnable {
    private ArrayList<Thread> consumerThreads;
    private ArrayList<Thread> vendorThreads;
    public Menu(ArrayList<Thread> consumerThreads,ArrayList<Thread> vendorThreads){
        this.consumerThreads = consumerThreads;
        this.vendorThreads = vendorThreads;

    }

    @Override
    public synchronized void run() {

        while(Simulation.getSellTicketCount()<Config.getMaxTicketCount()){
            try{
                Scanner trigScan = new Scanner(System.in);
                //System.out.println("Checking Now");

                if(System.in.available()>0){
                    //Thread.sleep(1000);

                    System.out.println("System is quiting......");
                    System.exit(0);
//                    try{
////                        for(int i = 0; i <consumerThreads.size(); i++){
////                            consumerThreads.get(i).wait();
////                        }
////                        for(int i = 0; i <vendorThreads.size(); i++){
////                            vendorThreads.get(i).wait();
////
////                        }
//                        //consumerThreads.forEach(Thread::interrupt);
//                        vendorThreads.forEach(Thread::interrupt);
//
//                        //since we are gonna interact this in the ui what is suggest is lets not stop the
//                        //current threads rather than that creat another thread and run that.
//
//                    }
//                    catch (Exception e){
//                        e.printStackTrace();
//                    }
//                    int menueInput = trigScan.nextInt();
//                    switch (menueInput){
//                        case 1: //quit the simulation
//                        {
//                            System.out.println("System is quiting...");
//                            //wait(1000);
//                            System.exit(0);
//                        }
//                        case 2: //add a vendor
//                            //we have to get the vendor id to increment
//                        //can make it to get name
//                        {Vendor newVendor = new Vendor("HelloVendor", 3);
//                            Thread incVendor = new Thread(newVendor);
//                            vendorThreads.add(incVendor);
//                            incVendor.start();
//
//
//                            break;
//
//                        }
//                        case 3 :
//                            if(!vendorThreads.isEmpty()){
//                                vendorThreads.getFirst().interrupt();
//                                vendorThreads.removeFirst();
//                            }
//
//                    }



                    TimeUnit.MILLISECONDS.sleep(500);
                }
                //Thread.sleep(1000);


            }
            catch(IOException | InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
