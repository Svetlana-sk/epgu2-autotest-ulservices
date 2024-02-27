package ru.gosuslugi.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnection {
    public static void main(String[] args) {
        // Параметры подключения
        String url = "jdbc:oracle:thin:@p00svcdevdb01.m9.egov.local:1521:p00svc1";
        String username = "svcdevread";
        String password = "svcdevread";


        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select ORDER_STATUS_ID STATUS, SCOMMENT, SCOMMENT_EXT, UPDATE_SERVICE_CODE, SMEV_MESSAGE_ID from LK.STATUS_HISTORY where ORDER_ID = '3500610071' ORDER BY STATUS_DATE");

            while (resultSet.next()) {
                int status = resultSet.getInt("STATUS");
                System.out.println("Status: " + status);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
