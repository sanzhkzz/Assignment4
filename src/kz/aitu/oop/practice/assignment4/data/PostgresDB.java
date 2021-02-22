package kz.aitu.oop.practice.assignment4.data;

import kz.aitu.oop.practice.assignment4.data.interfaces.IDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class PostgresDB implements IDB {
    @Override
    public Connection getConnection() throws SQLException, ClassNotFoundException {
        String connectionUrl = "jdbc:postgresql://localhost:5432/assignment4";
        try {
            // Here we load the driver’s class file into memory at the runtime
            Class.forName("org.postgresql.Driver");

            // Here we make establish connection
            Connection con = DriverManager.getConnection(connectionUrl, "postgres", "Majorlazer228");
            return con;
        } catch (Exception e) {
            System.out.println(e);
            throw e;
        }
    }
}