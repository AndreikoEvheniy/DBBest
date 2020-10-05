package com.dbbest.entity;

import java.util.*;

/**
 * WaterPipeline entity.
 *
 * @author E.Andreiko
 */
public class WaterPipeline {
    private String point;
    private HashMap<String, Integer> tiesAndLength = new HashMap<>();

    public WaterPipeline() {
    }

    public Integer getIdBFromMap(String idB) {
        return tiesAndLength.get(idB);
    }

    public String getPoint() {
        return point;
    }

    public void setPoint(String point) {
        this.point = point;
    }

    public HashMap<String, Integer> getTiesAndLength() {
        return tiesAndLength;
    }

    public void setTiesAndLength(HashMap<String, Integer> tiesAndLength) {
        this.tiesAndLength = tiesAndLength;
    }

    @Override
    public String toString() {
        return point + ";" + tiesAndLength;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WaterPipeline that = (WaterPipeline) o;
        return Objects.equals(point, that.point) &&
                Objects.equals(tiesAndLength, that.tiesAndLength);
    }

    @Override
    public int hashCode() {
        return Objects.hash(point, tiesAndLength);
    }
}