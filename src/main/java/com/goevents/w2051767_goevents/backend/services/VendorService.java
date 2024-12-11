package com.goevents.w2051767_goevents.backend.services;

import com.goevents.w2051767_goevents.CLI.Config;
import com.goevents.w2051767_goevents.CLI.TicketPool;
import com.goevents.w2051767_goevents.backend.components.PersonComponent;
import com.goevents.w2051767_goevents.backend.components.SystemConfigComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class VendorService extends PersonComponent implements Runnable {
    private String vendorName;
    private int vendorId;

    @Autowired
    public VendorService(@Value("") String vendorName,@Value("0") int vendorId){
        super(vendorName,vendorId);
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    public int getVendorId() {
        return vendorId;
    }

    public void setVendorId(int vendorId) {
        this.vendorId = vendorId;
    }

    public synchronized void run(){
//        Config.setTotalTicketCount(TicketPool.addTicket(Config.getTotalTicketCount(),Config.getMaxTicketCount(),Config.getTicketReleaseRate()));
        while(true){
            //Config.setTotalTicketCount(TicketPool.addTicket(Config.getTotalTicketCount(),Config.getMaxTicketCount(),Config.getTicketReleaseRate()));
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
