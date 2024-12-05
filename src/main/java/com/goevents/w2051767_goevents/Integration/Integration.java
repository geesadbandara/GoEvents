package com.goevents.w2051767_goevents.Integration;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class Integration {
    String path;
    String[] commands;
    public Integration(String path,String[] commands){
        try{
            //String[] commands = {"ng","serve"};
            ProcessBuilder process = new ProcessBuilder(commands);
            process.directory(new File(path));

            System.out.println("" + process.directory());
            Process newProcess = process.start();

            BufferedReader reader = new BufferedReader(new InputStreamReader(newProcess.getInputStream()));
            String line;

            while((line = reader.readLine()) !=null){
                System.out.println(line);
            }

        }
        catch(IOException e){
            throw new RuntimeException(e);
        }
    }
}
