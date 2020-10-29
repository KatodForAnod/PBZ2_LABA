package sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class CreateTable {

    Connection c;
    Statement stmt;

    public void createTable() {
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://localhost:4444/2ndLab", "postgres", "12345678");
            c.setAutoCommit(false);
            System.out.println("-- Opened database successfully");
            String sql;

            //-------------- CREATE TABLE ---------------
            stmt = c.createStatement();
            sql = "CREATE TABLE DELIVERY_HISTORY " +
                    "(FIO                     TEXT  NOT NULL," +
                    " nameOfPublication       TEXT  NOT NULL, " +
                    " estimatedDeliveryDate   TEXT  NOT NULL, " +
                    " statusOfDelivery        BOOLEAN  NOT NULL, " +
                    " typeOfDelivery          TEXT  NOT NULL)";
            stmt.executeUpdate(sql);
            stmt.close();
            c.commit();
            System.out.println("-- Table created successfully");

            c.close();

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }
}
