/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.trianglesoftware.ui;

import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class SystemIO {

    Scanner kb = new Scanner(System.in);

    

    public int getInt(String prompt) {
        boolean badInput;
        int result = 0;
        do {
            try {
                System.out.println(prompt);
                result = Integer.parseInt(kb.nextLine());
                badInput = false;
            } catch (NumberFormatException nfe) {
                System.out.println("Please enter a numeric value.");
                badInput = true;
            } 
        
        } while (badInput == true);
        
        return result;
        
        
    }

    public int getInt(String prompt, int min) {
        int num = 0;
        do {
            num = getInt(prompt); //this checks and makes sure that the number is numeric value not something else!
        } while (num < min);
        return num;

    }

    public void printMessage(String prompt) {
        System.out.println(prompt);
    }
    
    public void printMessage(int prompt) {
        System.out.println(prompt);
    }
    
    public void printMessage(double prompt) {
        System.out.println(prompt);
    }
    
    public void printMessage(float prompt) {
        System.out.println(prompt);
    }
}
