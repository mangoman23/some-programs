/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.trianglesoftware.dao;

import com.swcguild.trianglesoftware.dto.Triangle;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author apprentice
 */
public class TriangleDaoFileIOImpl implements TriangleDao {
    
    Map<Integer, Triangle> allTriangles = new HashMap<>();
    private static int counter = 1;

    @Override
    public void addTriangleToDatabase(Triangle triangle) {
        triangle.setTriangleId(counter);
        counter ++;
        allTriangles.put(triangle.getTriangleId(), triangle);
        
    }

    @Override
    public Triangle getTriangleFromDatabase(int triangleId) {
        return allTriangles.get(triangleId);
    }

    @Override
    public void getTrianglesFromDatabase() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void loadTrianglesToDatabase() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
