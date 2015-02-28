/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.trianglesoftware.dao;

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
public class TriangleDaoFileIOImplTest {
    
    TriangleDao dao = new TriangleDaoFileIOImpl();
    
    public TriangleDaoFileIOImplTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    @Test
    public void addGetGetAllTest() {
        Triangle testTriangle = new Triangle(3,4,5);
        testTriangle.setTriangleType("test triangle");
        
        dao.addTriangleToDatabase(testTriangle);
        assertEquals(dao.getAllTrianglesInDatabase().size(), 1);
        int triangleId = testTriangle.getTriangleId();
        
        Triangle copiedTriangle = new Triangle(1,2,3);
        copiedTriangle = dao.getTriangleFromDatabase(triangleId);
        assertEquals(copiedTriangle, testTriangle);
        dao.addTriangleToDatabase(copiedTriangle);
        assertEquals(dao.getAllTrianglesInDatabase().size(), 2);
    }
}
