/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.trianglesoftware.dto;

import java.util.Objects;

/**
 *
 * @author apprentice
 */
public class Triangle {
    
    private int sideOne;
    private int sideTwo;
    private int sideThree;
    private int triangleId;
    private String triangleType;

    public int getSideOne() {
        return sideOne;
    }

    public void setSideOne(int sideOne) {
        this.sideOne = sideOne;
    }

    public int getSideTwo() {
        return sideTwo;
    }

    public void setSideTwo(int sideTwo) {
        this.sideTwo = sideTwo;
    }

    public int getSideThree() {
        return sideThree;
    }

    public void setSideThree(int sideThree) {
        this.sideThree = sideThree;
    }

    public int getTriangleId() {
        return triangleId;
    }

    public void setTriangleId(int triangleId) {
        this.triangleId = triangleId;
    }

    public String getTriangleType() {
        return triangleType;
    }

    public void setTriangleType(String triangleType) {
        this.triangleType = triangleType;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + this.sideOne;
        hash = 79 * hash + this.sideTwo;
        hash = 79 * hash + this.sideThree;
        hash = 79 * hash + this.triangleId;
        hash = 79 * hash + Objects.hashCode(this.triangleType);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Triangle other = (Triangle) obj;
        if (this.sideOne != other.sideOne) {
            return false;
        }
        if (this.sideTwo != other.sideTwo) {
            return false;
        }
        if (this.sideThree != other.sideThree) {
            return false;
        }
        if (this.triangleId != other.triangleId) {
            return false;
        }
        if (!Objects.equals(this.triangleType, other.triangleType)) {
            return false;
        }
        return true;
    }
    
    
    
}
