package com.goevents.w2051767_goevents.backend.services;

import com.goevents.w2051767_goevents.CLI.Config;
import com.goevents.w2051767_goevents.CLI.TicketPool;
import com.goevents.w2051767_goevents.backend.components.PersonComponent;
import com.goevents.w2051767_goevents.backend.components.SystemConfigComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class CustomerService extends PersonComponent implements Runnable {

    //validations need to be done in frontend

    @Autowired
    public CustomerService(@Value("0") String name,@Value("0") int CustomerId) {
        super(name, CustomerId);
    }

    public synchronized void run(){
        while(true) {

            SystemConfigComponent.setTotalTicketPool(TicketManagementService.buyTicket(SystemConfigComponent.getTotalTicketPool(), super.getName(), SystemConfigComponent.getTicketRetrievalRate()));

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                //throw new RuntimeException(e);
                System.out.println("Thread Interrupted");
                break;
            }
        }


    }




}
