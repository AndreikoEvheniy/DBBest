package com.dbbest;

import com.dbbest.entity.Points;
import com.dbbest.entity.WaterPipeline;

import java.sql.*;
import java.util.*;

/**
 * DB manager. Works with H2 DB.  Only the required DAO methods are
 * defined!
 *
 * @author E.Andreiko
 */
public class DBManager {

    /**
     * Returns a DB connection from the Pool Connections.
     *
     * @return DB connection.
     */
    private Connection connection() throws SQLException {
        String url = "jdbc:h2:~/test";
        String user = "sa";
        String password = "";
        return DriverManager.getConnection(url, user, password);
    }

    /**
     * Returns a water pipeline system..
     *
     * @param idA First point.
     * @return Water pipeline entity.
     * @throws SQLException
     */
    public WaterPipeline getPointByIdA(String idA) {
        WaterPipeline waterPipeline = new WaterPipeline();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = connection();
            preparedStatement = connection.prepareStatement("SELECT * FROM PIPELINESYSTEM WHERE IDX=?");
            preparedStatement.setString(1, idA);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                waterPipeline.setPoint(DBUtils.extractIDX(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtils.close(resultSet);
            DBUtils.close(preparedStatement);
            DBUtils.close(connection);
        }
        return waterPipeline;
    }

    /**
     * Returns hash map connections and length.
     *
     * @param idX first point.
     * @return HashMap with connection and length
     * @throws SQLException
     */
    public HashMap<String, Integer> searchForConnection(String idX) throws SQLException {
        HashMap<String, Integer> waterPipeline = new HashMap<String, Integer>();
        Connection connection = connection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM PIPELINESYSTEM WHERE IDX=?");
            preparedStatement.setString(1, idX);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                waterPipeline.put(DBUtils.extractIDY(resultSet), DBUtils.extractLength(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtils.close(resultSet);
            DBUtils.close(preparedStatement);
            DBUtils.close(connection);
        }
        return waterPipeline;
    }

    /**
     * Return array list with points.
     * @return ArrayList.
     */
    public ArrayList<Points> getSetOfPoints() {
        ArrayList<Points> setOfPoints = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            connection = connection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM BETWEEN");
            while (resultSet.next()) {
                setOfPoints.add(DBUtils.extractPoints(resultSet));
            }
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        } finally {
            DBUtils.close(resultSet);
            DBUtils.close(statement);
            DBUtils.close(connection);
        }
        return setOfPoints;
    }
}

