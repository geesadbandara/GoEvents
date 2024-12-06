package com.goevents.w2051767_goevents.backend.services;

import com.goevents.w2051767_goevents.CLI.Consumer;
import com.goevents.w2051767_goevents.CLI.Vendor;

import java.util.ArrayList;

public class Simulation {

    //this needs to be called in the controller after calling the configuration

    public void startSimulation() {
        VendorService vendor1 = new VendorService("Geesad", 1);
        Thread threadGeesad = new Thread(vendor1);

        VendorService vendor2 = new VendorService("Geesad", 2);
        Thread threadGeesad2 = new Thread(vendor2);

        ArrayList<Thread> vendorThreads = new ArrayList<Thread>();
        vendorThreads.add(threadGeesad);
        vendorThreads.add(threadGeesad2);

        for (int i = 0; i < vendorThreads.size(); i++) {
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
            consumerThreads.get(i).start();
        }
    }

}
