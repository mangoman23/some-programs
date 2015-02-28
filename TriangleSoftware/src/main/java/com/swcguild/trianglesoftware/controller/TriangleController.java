/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.trianglesoftware.controller;

import com.swcguild.trianglesoftware.ui.SystemIO;

/**
 *
 * @author apprentice
 */
public class TriangleController {
    
    SystemIO sio = new SystemIO();
    
    public void run() {
        displayMenu();
    }
    
    private void displayMenu() {
        sio.printMessage("-----TRIANGLE SOFTWARE-----");
        sio.printMessage(" ");
        sio.printMessage("\tPlease pick an option");
        sio.printMessage("\t\t1) Evaluate a triangle");
        sio.printMessage("\t\t2) Review all triangles in the database");
        sio.printMessage("\t\t3) Exit");
        sio.printMessage(" ");
        sio.printMessage("----------------------------");
    }
    
}
