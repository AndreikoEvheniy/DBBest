package com.dbbest;

import com.dbbest.entity.Points;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Other methods and DB util for DBManager.
 *
 * @author E.Andreiko
 */

public class DBUtils {

    /**
     * Extract a points from result set.
     * @param resultSet rs Result set from which a points entity will be extracted.
     * @return Points entity.
     * @throws SQLException
     */
    public static Points extractPoints(ResultSet resultSet) throws SQLException {
        Points points = new Points();

        points.setIdA(resultSet.getString("IDA"));
        points.setIdB(resultSet.getString("IDB"));
        return points;
    }

    /**
     * Extract a idX from result set.
     * @param resultSet rs Result set from which a points entity will be extracted.
     * @return well.
     * @throws SQLException
     */
    public static String extractIDX(ResultSet resultSet) throws SQLException {
        String waterPipeline;
        waterPipeline =resultSet.getString("IDX");
        return waterPipeline;
    }

    /**
     * Extract a idY from result set.
     * @param resultSet rs Result set from which a points entity will be extracted.
     * @return well.
     * @throws SQLException
     */
    public static String extractIDY(ResultSet resultSet) throws SQLException{
        String waterPipeline;
        waterPipeline = resultSet.getString("IDY");
        return waterPipeline;
    }

    /**
     * Extract a length from result set.
     * @param resultSet rs Result set from which a points entity will be extracted.
     * @return distance between wells.
     * @throws SQLException
     */
    public static int extractLength(ResultSet resultSet) throws SQLException{
        int waterPipeline;
        waterPipeline = resultSet.getInt("LENGTH");
        return waterPipeline;
    }

    /**
     * Closes a connection.
     *
     * @param connection Connection to be closed.
     */
    public static void close(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Closes a result set object.
     *
     * @param rs Result set to be closed.
     */
    public static void close(ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Closes a statement object.
     *
     * @param stmt Statement to be closed.
     */
    public static void close(Statement stmt) {
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
