package com.goevents.w2051767_goevents.backend.controllers;

import com.goevents.w2051767_goevents.backend.components.RequestBodyComponent;
import com.goevents.w2051767_goevents.backend.components.SystemConfigComponent;
import com.goevents.w2051767_goevents.backend.services.SimulationSystemService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class FormController {

    private SimulationSystemService newSimulation = new SimulationSystemService();
    private SystemConfigComponent systemConfigFront;


    @PostMapping("/simulation")
    public void activateSimulation(@RequestBody RequestBodyComponent configBody){
        int maxPoolSize = configBody.getMaxPool();
        int totalPoolSize = configBody.getTotalPool();
        int releaseRate = configBody.getReleaseRate();
        int retrievalRate = configBody.getRetrievalRate();

        //System.out.println(maxPoolSize +" "+ totalPoolSize+" "+releaseRate+" "+retrievalRate);
        System.out.println(configBody.toString());
        systemConfigFront = new SystemConfigComponent(maxPoolSize,totalPoolSize,retrievalRate,releaseRate);


        newSimulation.objectToJSON();
        newSimulation.startSimulation(systemConfigFront);





    }

    @PostMapping("/simulationend")
    public void deactivatedSimulation(){
            newSimulation.stopSimulation();

    }

}
