package com.dbbest;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.CSVWriter;
import au.com.bytecode.opencsv.bean.ColumnPositionMappingStrategy;
import au.com.bytecode.opencsv.bean.CsvToBean;
import com.dbbest.entity.Points;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * CSV. Works with *.csv files.
 *
 * @author E.Andreiko
 */
public class CSV {

    /**
     * Returns all points.
     *
     * @return array list of points
     * @throws Exception
     */
    @SuppressWarnings({"rawtypes", "unchecked"})
    public ArrayList<Points> readFromCSV() throws Exception {
        ArrayList<Points> setOfPoints = new ArrayList();
        CsvToBean csv = new CsvToBean();
        String csvFilename = "input.csv";
        CSVReader csvReader = new CSVReader(new FileReader(csvFilename));
        List list = csv.parse(setColumnMapping(), csvReader);
        for (Object object : list) {
            Points employee = (Points) object;
            setOfPoints.add(employee);
        }
        return setOfPoints;
    }

    /**
     * Create *csv files and write in this file result.
     *
     * @param s the result that is written to the *csv file
     * @param fileName new file name
     * @throws IOException
     */
    public void creteAndWriteInCSV(String fileName, String s) throws IOException {
        CSVWriter writer = new CSVWriter(new FileWriter(fileName, true));
        String[] record = s.split(",");
        writer.writeNext(record);
        writer.close();
    }

    /**
     *Helper method for reading from a *.csv file
     * @return
     */
    @SuppressWarnings({"rawtypes", "unchecked"})
    private static ColumnPositionMappingStrategy setColumnMapping() {
        ColumnPositionMappingStrategy strategy = new ColumnPositionMappingStrategy();
        strategy.setType(Points.class);
        String[] columns = new String[]{"idA", "idB"};
        strategy.setColumnMapping(columns);
        return strategy;
    }
}
