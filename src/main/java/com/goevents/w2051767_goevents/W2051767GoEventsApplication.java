package com.goevents.w2051767_goevents;

import com.goevents.w2051767_goevents.CLI.Simulation;
import com.goevents.w2051767_goevents.Integration.Integration;
import com.goevents.w2051767_goevents.backend.components.SystemConfigComponent;
import com.goevents.w2051767_goevents.backend.services.SimulationSystemService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import java.util.Scanner;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class W2051767GoEventsApplication {

    public static void main(String[] args) {
        SpringApplication.run(W2051767GoEventsApplication.class, args);
        Scanner userPreferenceScan = new Scanner(System.in);
        System.out.println("1. GoEvents Website");
        System.out.println("2. GoEvents Command Line Interface");
        System.out.println("Enter your preference : ");
        int userPref = userPreferenceScan.nextInt();
        switch (userPref) {
            case 1 :
                String[] ngCommands = {"ng","serve"};
                Integration newFrontendInt = new Integration("/Users/geesadbandara/Desktop/Java/OOP CWK/w2051767_GoEvents/frontend/GoEvents",ngCommands);
                break;
            case 2 :
                Simulation newSim = new Simulation();
                newSim.runSimulation();
                //Integration newCLIInt = new Integration();
        }

        //System.out.println("Hello world");

    }

}
