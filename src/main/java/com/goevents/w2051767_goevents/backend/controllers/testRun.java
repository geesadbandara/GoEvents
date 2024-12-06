package com.goevents.w2051767_goevents.backend.controllers;

import com.goevents.w2051767_goevents.backend.components.SystemConfigComponent;
import com.goevents.w2051767_goevents.backend.services.SimulationSystemService;

public class testRun {
    public static void main(String[] args){

        SimulationSystemService newSimulationSystem = new SimulationSystemService();
        newSimulationSystem.startSimulation();


    }
}
