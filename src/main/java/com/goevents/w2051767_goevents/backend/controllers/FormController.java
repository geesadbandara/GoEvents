package com.goevents.w2051767_goevents.backend.controllers;

import com.goevents.w2051767_goevents.backend.components.RequestBodyComponent;
import com.goevents.w2051767_goevents.backend.components.SystemConfigComponent;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class FormController {
    @PostMapping("/simulation")
    public void activateSimulation(@RequestBody RequestBodyComponent configBody){
        int maxPoolSize = configBody.getMaxTicketPool();
        int totalPoolSize = configBody.getTotalTicketPool();
        int releaseRate = configBody.getReleaseRate();
        int retrievalRate = configBody.getRetrievalRate();

        System.out.println(maxPoolSize +""+ totalPoolSize+" "+releaseRate+" "+retrievalRate);



    }
}
