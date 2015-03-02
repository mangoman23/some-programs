/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.trianglesoftware.dao;

import com.swcguild.trianglesoftware.dto.Triangle;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author apprentice
 */
public class TriangleDaoFileIOImpl implements TriangleDao {

    Map<Integer, Triangle> allTriangles = new HashMap<>();
    private static int idCounter = 1;
    private final String TARGET_FILE = "address.txt";
    private final String TARGET_FILE_COUNTER = "counter.txt";
    private final String DELIMITER = ":::";

    @Override
    public void addTriangleToDatabase(Triangle triangle) {
        triangle.setTriangleId(idCounter);
        idCounter++;
        allTriangles.put(triangle.getTriangleId(), triangle);

    }

    @Override
    public Triangle getTriangleFromDatabase(int triangleId) {
        return allTriangles.get(triangleId);
    }

    @Override
    public void getTrianglesFromDatabase() throws FileNotFoundException {
        Scanner sc = new Scanner(new BufferedReader(new FileReader(TARGET_FILE)));
        String currentLine;
        String[] currentTokens;
        while (sc.hasNextLine()) {
            currentLine = sc.nextLine();
            currentTokens = currentLine.split(DELIMITER);
            Triangle currentTriangle = new Triangle(0, 0, 0);
            currentTriangle.setSideOne(Integer.parseInt(currentTokens[0]));
            currentTriangle.setSideTwo(Integer.parseInt(currentTokens[1]));
            currentTriangle.setSideThree(Integer.parseInt(currentTokens[2]));
            currentTriangle.setTriangleType(currentTokens[3]);
            currentTriangle.setTriangleId(Integer.parseInt(currentTokens[4]));
            allTriangles.put(currentTriangle.getTriangleId(), currentTriangle);
        }
        sc.close();
    }

    @Override
    public void loadTrianglesToDatabase() throws IOException {
        Set<Integer> keys = allTriangles.keySet();
        PrintWriter out = new PrintWriter(new FileWriter(TARGET_FILE));
        for (int idCounter : keys) {
            Triangle currentTriangle = allTriangles.get(idCounter);
            out.println(currentTriangle.getSideOne() + DELIMITER
                    + currentTriangle.getSideTwo() + DELIMITER
                    + currentTriangle.getSideThree() + DELIMITER
                    + currentTriangle.getTriangleType() + DELIMITER
                    + currentTriangle.getTriangleId());
            out.flush();
        }
        out.close();
    }

    @Override
    public List<Triangle> getAllTrianglesInDatabase() {
        Collection c = allTriangles.values();
        return new ArrayList(c);
    }

    @Override
    public void getCounterFromDatabase() throws FileNotFoundException {
        Scanner sc = new Scanner(new BufferedReader(new FileReader(TARGET_FILE_COUNTER)));
        idCounter = sc.nextInt();
        sc.close();
    }

    @Override
    public void loadCounterToDatabase() throws IOException {
        PrintWriter out = new PrintWriter(new FileWriter(TARGET_FILE_COUNTER));
        out.println(idCounter);
        out.flush();
        out.close();
    }

}
