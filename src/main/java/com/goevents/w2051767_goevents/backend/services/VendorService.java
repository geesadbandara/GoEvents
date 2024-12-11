package com.goevents.w2051767_goevents.backend.services;

import com.goevents.w2051767_goevents.backend.components.PersonComponent;
import com.goevents.w2051767_goevents.backend.components.SystemConfigComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class VendorService extends PersonComponent implements Runnable {

    @Autowired
    public VendorService(@Value("") String vendorName,@Value("0") int vendorId){
        super(vendorName,vendorId);
    }

    public synchronized void run(){
        while(true){
            SystemConfigComponent.setTotalTicketPool(TicketManagementService.addTicket(SystemConfigComponent.getTotalTicketPool(),SystemConfigComponent.getMaxTicketPoolSize(),SystemConfigComponent.getTicketReleaseRate(),super.getName()));

            try{

                Thread.sleep(1000);
            }
            catch (InterruptedException e) {
                //throw new RuntimeException(e);
                System.out.println("Thread Interrupted");
                break;
            }
            catch (Exception k){
                System.out.println("Thread Interrupted");
            }
        }


    }

}
