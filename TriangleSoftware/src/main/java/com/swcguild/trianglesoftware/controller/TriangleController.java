/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.trianglesoftware.controller;

import com.swcguild.trianglesoftware.businesslogic.TriangleCalculator;
import com.swcguild.trianglesoftware.businesslogic.TriangleCalculatorFileIOImpl;
import com.swcguild.trianglesoftware.dao.TriangleDao;
import com.swcguild.trianglesoftware.dao.TriangleDaoFileIOImpl;
import com.swcguild.trianglesoftware.dto.Triangle;
import com.swcguild.trianglesoftware.ui.SystemIO;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author apprentice
 */
public class TriangleController {

    SystemIO sio = new SystemIO();
    TriangleDao dao = new TriangleDaoFileIOImpl();
    TriangleCalculator tcalc = new TriangleCalculatorFileIOImpl();

    public void run() throws FileNotFoundException, IOException {
        dao.getCounterFromDatabase();
        dao.getTrianglesFromDatabase();
        menu();
    }

    private void menu() throws IOException {
        int userChoice;
        do {
            sio.printMessage("-----TRIANGLE SOFTWARE-----");
            sio.printMessage(" ");
            sio.printMessage("\tPlease pick an option");
            sio.printMessage("\t\t1) Evaluate a triangle");
            sio.printMessage("\t\t2) Review all triangles in the database");
            sio.printMessage("\t\t3) Exit");
            sio.printMessage(" ");
            sio.printMessage("----------------------------");
            userChoice = sio.getInt(" ", 1, 3);

            switch (userChoice) {
                case 1:
                    evaluateTriangle();
                    break;
                case 2:
                    getAllTriangles();
                    break;
                case 3:
                    sio.printMessage("Exiting program...");
                    break;
                default:
                    sio.printMessage("ERROR");
            }
        } while (userChoice != 3);
        sio.printMessage("Have a great day!");
        dao.loadTrianglesToDatabase();
        dao.loadCounterToDatabase();
    }

    private void evaluateTriangle() {
        int sideOne = sio.getInt("What is the first side of the triangle?", 0);
        int sideTwo = sio.getInt("What is the second side of the triangle?", 0);
        int sideThree = sio.getInt("What is the third side of the triangle?", 0);
        
        Triangle triangleToBeEvaluated = new Triangle(sideOne, sideTwo, sideThree);
        
        tcalc.determineTriangleType(triangleToBeEvaluated);
        
        if (triangleToBeEvaluated.getTriangleType().equalsIgnoreCase("INVALID TRIANGLE")) {
            sio.printMessage("This is not a valid triangle!");
        } else {
            dao.addTriangleToDatabase(triangleToBeEvaluated);
            sio.printMessage("The triangle's type is: " + triangleToBeEvaluated.getTriangleType());
            sio.printMessage("We will add this triangle to the database!");
        }
    }

    private void getAllTriangles() {
        List<Triangle> allTriangles = dao.getAllTrianglesInDatabase();
        if (allTriangles.isEmpty()) {
            sio.printMessage("-----");
            sio.printMessage("There are no triangles in the database!");
            sio.printMessage("-----");
        } else {
            for(Triangle currentTriangle : allTriangles) {
                sio.printMessage("-----");
                sio.printMessage(currentTriangle.toString());
                sio.printMessage("-----");
            }
        }
    }
}
