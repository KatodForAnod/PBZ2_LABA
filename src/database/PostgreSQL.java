package database;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.CurrentSubscriptions;
import model.DeliveryHistory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class PostgreSQL {
    private Connection c;
    private Statement stmt;

    public ObservableList<CurrentSubscriptions> getCurrentSubscriptions() {
        ObservableList<CurrentSubscriptions> list = FXCollections.observableArrayList();

        try {

            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://localhost:4444/2ndLab", "postgres", "12345678");
            c.setAutoCommit(false);
            System.out.println("-- Opened database successfully");

            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM CURRENT_SUBSCRIPTIONS;");
            while (rs.next()) {
                String FIO = rs.getString("FIO");
                String post = rs.getString("post");
                String nameOfPublication = rs.getString("nameOfPublication");
                String periodOfSubscriptionFrom = rs.getString("periodOfSubscriptionFrom");
                String periodOfSubscriptionTo = rs.getString("periodOfSubscriptionTo");

                list.add(new CurrentSubscriptions(FIO, post, nameOfPublication,
                        periodOfSubscriptionFrom, periodOfSubscriptionTo));
            }
            rs.close();
            stmt.close();
            c.commit();
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }

        return list;
    }

    public ObservableList<DeliveryHistory> getDeliveryHistory() {
        ObservableList<DeliveryHistory> list = FXCollections.observableArrayList();

        try {

            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://localhost:4444/2ndLab", "postgres", "12345678");
            c.setAutoCommit(false);
            System.out.println("-- Opened database successfully");

            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM DELIVERY_HISTORY;");
            while (rs.next()) {
                String FIO = rs.getString("FIO");
                String nameOfPublication = rs.getString("nameOfPublication");
                String estimatedDeliveryDate = rs.getString("estimatedDeliveryDate");
                String typeOfDelivery = rs.getString("typeOfDelivery");
                Boolean statusOfDelivery = rs.getBoolean("statusOfDelivery");

                list.add(new DeliveryHistory(FIO, nameOfPublication, estimatedDeliveryDate,
                        statusOfDelivery, typeOfDelivery));
            }

            rs.close();
            stmt.close();
            c.commit();
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        /*
        DeliveryHistory object1 = new DeliveryHistory("Иван Васильевич", "Наука и жизнь #1",
                "2 дня", false, "почтальон");
        DeliveryHistory object2 = new DeliveryHistory("Александр Сергеевич", "Красивые места СССР #1",
                "1 день", false, "почтальон");
        DeliveryHistory object3 = new DeliveryHistory("Семен Семенович", "Юный радиолюбитель #1",
                "0 дней", true, "бандероль на почте");
        */
        return list;
    }

    public void addSubscriberToDataBase(String... textFields) {
        try {
            String FIO = textFields[0];
            String post = textFields[1];
            String nameOfPublication = textFields[2];
            String periodOfSubscriptionFrom = textFields[3];
            String periodOfSubscriptionTo = textFields[4];

            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://localhost:4444/2ndLab", "postgres", "12345678");
            c.setAutoCommit(false);
            System.out.println("-- Opened database successfully");
            String sql;
            //--------------- INSERT ROWS ---------------
            stmt = c.createStatement();
            sql = String.format("INSERT INTO CURRENT_SUBSCRIPTIONS (FIO, post, nameOfPublication," +
                            "periodOfSubscriptionFrom, periodOfSubscriptionTo) " +
                            "VALUES ('%s', '%s', '%s'," +
                            "'%s', '%s');",
                    FIO, post, nameOfPublication, periodOfSubscriptionFrom, periodOfSubscriptionTo);
            stmt.executeUpdate(sql);

            stmt.close();
            c.commit();
            System.out.println("-- Records created successfully");
            c.close();

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

    public String[] findDataFromCurrentSubscription(String FIO) {
        String[] dataFromDatabase = new String[4];

        try {

            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://localhost:4444/2ndLab", "postgres", "12345678");
            c.setAutoCommit(false);
            System.out.println("-- Opened database successfully");

            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM CURRENT_SUBSCRIPTIONS " +
                    "WHERE fio = '" + FIO + "' ;");
            while (rs.next()) {
                dataFromDatabase[0] = rs.getString("post");
                dataFromDatabase[1] = rs.getString("nameOfPublication");
                dataFromDatabase[2] = rs.getString("periodOfSubscriptionFrom");
                dataFromDatabase[3] = rs.getString("periodOfSubscriptionTo");
            }
            rs.close();
            stmt.close();
            c.commit();
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return dataFromDatabase;
    }

    public void editInformationToCurrentSubscription(String... textFields) {
        try {
            String FIO = textFields[0];
            String post = textFields[1];
            String nameOfPublication = textFields[2];
            String periodOfSubscriptionFrom = textFields[3];
            String periodOfSubscriptionTo = textFields[4];

            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://localhost:4444/2ndLab", "postgres", "12345678");
            c.setAutoCommit(false);
            System.out.println("-- Opened database successfully");
            String sql;
            //--------------- INSERT ROWS ---------------
            stmt = c.createStatement();
            sql = String.format("UPDATE CURRENT_SUBSCRIPTIONS set post = '%s', nameOfPublication= '%s'," +
                            "periodOfSubscriptionFrom= '%s', periodOfSubscriptionTo= '%s' " +
                            "WHERE FIO = '%s';",
                    post, nameOfPublication, periodOfSubscriptionFrom, periodOfSubscriptionTo, FIO);
            stmt.executeUpdate(sql);

            stmt.close();
            c.commit();
            System.out.println("-- Records created successfully");
            c.close();

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

    public void deleteInformationFromCurrentSubscription(String FIO) {
        try {

            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://localhost:4444/2ndLab", "postgres", "12345678");
            c.setAutoCommit(false);
            System.out.println("-- Opened database successfully");

            stmt = c.createStatement();
            stmt.executeUpdate("DELETE FROM CURRENT_SUBSCRIPTIONS " +
                    "WHERE fio = '" + FIO + "' ;");

            stmt.close();
            c.commit();
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

    public void addInformationToDeliveryHistory(boolean statusOfDelivery, String... textFields) {
        try {

            String FIO = textFields[0];
            String nameOfPublication = textFields[1];
            String estimatedDeliveryDate = textFields[2];
            String typeOfDelivery = textFields[3];

            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://localhost:4444/2ndLab", "postgres", "12345678");
            c.setAutoCommit(false);
            System.out.println("-- Opened database successfully");
            String sql;
            //--------------- INSERT ROWS ---------------
            stmt = c.createStatement();
            sql = String.format("INSERT INTO DELIVERY_HISTORY (FIO, nameOfPublication," +
                            "estimatedDeliveryDate, typeOfDelivery, statusOfDelivery) " +
                            "VALUES ('%s', '%s', '%s'," +
                            "'%s', %b);",
                    FIO, nameOfPublication, estimatedDeliveryDate, typeOfDelivery, statusOfDelivery);
            stmt.executeUpdate(sql);

            stmt.close();
            c.commit();
            System.out.println("-- Records created successfully");
            c.close();

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

    public String[] findInformationFromDeliveryHistory(String FIO) {
        String[] dataFromDatabase = new String[4];

        try {

            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://localhost:4444/2ndLab", "postgres", "12345678");
            c.setAutoCommit(false);
            System.out.println("-- Opened database successfully");

            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM DELIVERY_HISTORY " +
                    "WHERE fio = '" + FIO + "' ;");
            while (rs.next()) {
                dataFromDatabase[0] = rs.getString("nameOfPublication");
                dataFromDatabase[1] = rs.getString("estimatedDeliveryDate");
                dataFromDatabase[2] = rs.getString("typeOfDelivery");
                dataFromDatabase[3] = rs.getString("statusOfDelivery");
            }
            rs.close();
            stmt.close();
            c.commit();
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return dataFromDatabase;
    }

    public void editInformationToDeliveryHistory(boolean statusOfDelivery, String... textFields) {
        try {
            String FIO = textFields[0];
            String nameOfPublication = textFields[1];
            String estimatedDeliveryDate = textFields[2];
            String typeOfDelivery = textFields[3];

            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://localhost:4444/2ndLab", "postgres", "12345678");
            c.setAutoCommit(false);
            System.out.println("-- Opened database successfully");
            String sql;
            //--------------- INSERT ROWS ---------------
            stmt = c.createStatement();
            sql = String.format("UPDATE DELIVERY_HISTORY set nameOfPublication= '%s'," +
                            "estimatedDeliveryDate = '%s', typeOfDelivery= '%s', statusOfDelivery = %b " +
                            "WHERE FIO = '%s';",
                    nameOfPublication, estimatedDeliveryDate, typeOfDelivery, statusOfDelivery, FIO);
            stmt.executeUpdate(sql);

            stmt.close();
            c.commit();
            System.out.println("-- Records created successfully");
            c.close();

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

    public void deleteInformationFromDeliveryHistory(String FIO) {
        try {

            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://localhost:4444/2ndLab", "postgres", "12345678");
            c.setAutoCommit(false);
            System.out.println("-- Opened database successfully");

            stmt = c.createStatement();
            stmt.executeUpdate("DELETE FROM DELIVERY_HISTORY " +
                    "WHERE fio = '" + FIO + "' ;");

            stmt.close();
            c.commit();
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }
}
