/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.trianglesoftware.businesslogic;

import com.swcguild.trianglesoftware.dto.Triangle;

/**
 *
 * @author apprentice
 */
public class TriangleCalculatorFileIOImpl implements TriangleCalculator {

    
    

    @Override
    public void determineTriangleType(Triangle triangle) {
        int sideOne = triangle.getSideOne();
        int sideTwo = triangle.getSideTwo();
        int sideThree = triangle.getSideThree();
        int sideOnePlusTwo = sideOne + sideTwo;
        int sideOnePlusThree = sideOne + sideThree;
        int sideTwoPlusThree = sideTwo + sideThree;

        if (sideOnePlusTwo <= sideThree || sideOnePlusThree <= sideTwo || sideTwoPlusThree <= sideOne) { //checks if its a valid triangle
            triangle.setTriangleType("INVALID TRIANGLE");
        } else { 
            if (sideOne == sideTwo && sideTwo == sideThree) { //checks what type of triangle it is, assuming it is valid
                triangle.setTriangleType("equilateral");
            } else if (sideOne == sideThree || sideOne == sideTwo || sideTwo == sideThree) {
                triangle.setTriangleType("isoceles");
            } else {
                triangle.setTriangleType("scalene");
            }
        }
    }

}
