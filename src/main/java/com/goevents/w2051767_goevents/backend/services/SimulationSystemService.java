package com.goevents.w2051767_goevents.backend.services;

import com.goevents.w2051767_goevents.CLI.Config;
import com.goevents.w2051767_goevents.CLI.TicketPool;
import com.goevents.w2051767_goevents.backend.components.SystemConfigComponent;

import java.util.ArrayList;

public class SimulationSystemService {

    //this needs to be called in the controller after calling the configuration


    public void startSimulation() {
        System.out.println("Started");
        SystemConfigComponent newSystemConfig = new SystemConfigComponent(10,5,4,2);
        TicketManagementService.setTicketPool();
        System.out.println(newSystemConfig.getMaxTicketPoolSize());

        VendorService vendor1 = new VendorService("Geesad", 1);
        Thread threadGeesad = new Thread(vendor1);

        VendorService vendor2 = new VendorService("Geesad", 2);
        Thread threadGeesad2 = new Thread(vendor2);

        ArrayList<Thread> vendorThreads = new ArrayList<Thread>();
        vendorThreads.add(threadGeesad);
        vendorThreads.add(threadGeesad2);

        for (int i = 0; i < vendorThreads.size(); i++) {
            System.out.println("Started vendor threads");
            vendorThreads.get(i).start();
        }

        CustomerService consumer1 = new CustomerService("Puppy", 1);
        Thread threadPuppy = new Thread(consumer1);


        CustomerService consumer2 = new CustomerService("Puppy", 2);
        Thread threadPuppy2 = new Thread(consumer2);

        ArrayList<Thread> consumerThreads = new ArrayList<>();
        consumerThreads.add(threadPuppy);
        consumerThreads.add(threadPuppy2);

        for (int i = 0; i < consumerThreads.size(); i++) {
            System.out.println("Started consumer threads");
            consumerThreads.get(i).start();
        }
    }

}
