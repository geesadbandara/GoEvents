package com.goevents.w2051767_goevents.CLI;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Validator {

    public Validator(){

    }
    public static int intValidator(String displayText, String errorMsg) {
        int integerVal = 0;

        while (true) {
            try {
                System.out.println(displayText);
                Scanner intScan = new Scanner(System.in);
                integerVal = intScan.nextInt();
                break;

            } catch (InputMismatchException e) {
                System.out.println(errorMsg);

            }


        }
        return integerVal;


    }
    public boolean validateName(String name){
        int lengthOfName = name.length();
        if(name == ""){
            return false;
        }
        for(int i = 0; i<lengthOfName; i++){
            if(!Character.isLetter(name.charAt(i))){
                return false;

            }

        }
        return true;
    }
}
