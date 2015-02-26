/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.trianglesoftware.businesslogic;

/**
 *
 * @author apprentice
 */
public class TriangleCalculatorFileIOImpl implements TriangleCalculator {

    @Override
    public String determineTriangleType(int sideOne, int sideTwo, int sideThree) {
        int sideOnePlusTwo = sideOne + sideTwo;
        int sideOnePlusThree = sideOne + sideThree;
        int sideTwoPlusThree = sideTwo + sideThree;

        if (sideOnePlusTwo > sideThree || sideOnePlusThree > sideTwo || sideTwoPlusThree > sideOne) { //checks if its a valid triangle
            if (sideOne == sideTwo && sideTwo == sideThree) { //checks what type of triangle it is, assuming it is valid
                return "Equilateral";
            } else if (sideOne == sideThree || sideOne == sideThree || sideTwo == sideThree) {
                return "Isoceles";
            } else {
                return "Scalene";
            }
        } else {
            return "Not A Triangle";
        }
    }

}
