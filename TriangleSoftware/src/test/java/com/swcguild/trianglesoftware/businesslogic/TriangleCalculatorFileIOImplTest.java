/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.trianglesoftware.businesslogic;

import com.swcguild.trianglesoftware.dto.Triangle;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author apprentice
 */
public class TriangleCalculatorFileIOImplTest {

    Triangle triangleOne;
    Triangle triangleTwo;
    Triangle triangleThree;
    Triangle triangleFour;
    
    TriangleCalculator tcalc = new TriangleCalculatorFileIOImpl();

    public TriangleCalculatorFileIOImplTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        triangleOne = new Triangle(3,3,3);
        triangleTwo = new Triangle(3,4,5);
        triangleThree = new Triangle(7,7,8);
        triangleFour = new Triangle(20,2,7);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void equilateralTest() {
        tcalc.determineTriangleType(triangleOne);
        assertEquals(triangleOne.getTriangleType(), "Equilateral");
    }
    
    @Test
    public void isoceleseTest() {
        tcalc.determineTriangleType(triangleThree);
        assertEquals(triangleThree.getTriangleType(), "Isoceles");
    }
    
    @Test
    public void scaleneTest() {
        tcalc.determineTriangleType(triangleTwo);
        assertEquals(triangleTwo.getTriangleType(), "Scalene");
    }
    
    @Test
    public void invalidTriangleTest() {
        tcalc.determineTriangleType(triangleFour);
        assertEquals(triangleFour.getTriangleType(), "INVALID TRIANGLE");
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}

}
