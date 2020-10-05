package com.dbbest;

import com.dbbest.entity.Points;
import com.dbbest.entity.WaterPipeline;

import java.sql.SQLException;
import java.util.*;

public class Demo {
    static CSV csv = new CSV();
    static DBManager dbManager = new DBManager();
    static WaterPipeline waterPipeline;
    static String result;
    static int length;

    public static void main(String[] args) throws Exception {
        for (Points setOfPoints : csv.readFromCSV()) {
            csv.creteAndWriteInCSV("output.csv", findingPoints(setOfPoints.getIdA(), setOfPoints.getIdB()));
        }
    }

    /**
     * This method checks if the points are on the same line.
     * @param idA first point.
     * @param idB second point.
     * @return string with result.
     * @throws SQLException
     */
    public static String findingPoints(String idA, String idB) throws SQLException {
        boolean flag = false;
        int length1 = length;
        waterPipeline = dbManager.getPointByIdA(idA);
        waterPipeline.setTiesAndLength(dbManager.searchForConnection(waterPipeline.getPoint()));
        if (waterPipeline.getTiesAndLength().containsKey(idB)) {
            for (Map.Entry<String, Integer> entry : waterPipeline.getTiesAndLength().entrySet())
                if (entry.getKey().equals(idB)) {
                    length1 = length + entry.getValue();
                    result = "TRUE;" + length1;
                    length = 0;
                    return result;
                }
        } else {
            for (Map.Entry<String, Integer> entry : waterPipeline.getTiesAndLength().entrySet())
                if (entry.getKey().equals(idB)) {
                    length = length + entry.getValue();
                    result = "TRUE;" + length1;
                    length = 0;
                } else {
                    length = length + entry.getValue();
                    findingPoints(entry.getKey(), idB);
                    flag = true;
                }
        }
        if (!flag) {
            result = "FALSE;";
            length = 0;
        }
        return result;
    }
}
