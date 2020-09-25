package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Controller {
    Connection c;
    Statement stmt;

    public ObservableList<AllPublication> getAllPublication() {
        AllPublication object1 = new AllPublication(1,
                "Наука и жизнь", "дважды в месяц", 1.0);
        AllPublication object2 = new AllPublication(2,
                "Юный радиолюбитель", "дважды в неделю", 1.5);
        AllPublication object3 = new AllPublication(3,
                "Красивые места СССР", "один раз в неделю", (double) 20);

        return FXCollections.observableArrayList(object1, object2, object3);
    }

    public ObservableList<CurrentSubscriptions> getCurrentSubscriptions() {
        CurrentSubscriptions object1 = new CurrentSubscriptions("Иван Васильевич",
                "без професии", "Наука и жизнь",
                "13.02.20", "13.08.20");
        CurrentSubscriptions object2 = new CurrentSubscriptions("Александр Сергеевич",
                "студент", "Красивые места СССР",
                "13.03.20", "13.03.21");
        CurrentSubscriptions object3 = new CurrentSubscriptions("Семен Семенович",
                "инженер", "Юный радиолюбитель",
                "13.07.20", "13.10.20");

        return FXCollections.observableArrayList(object1, object2, object3);
    }

    public ObservableList<DeliveryHistory> getDeliveryHistory() {
        DeliveryHistory object1 = new DeliveryHistory("Иван Васильевич", "Наука и жизнь #1",
                "2 дня", false, "почтальон");
        DeliveryHistory object2 = new DeliveryHistory("Александр Сергеевич", "Красивые места СССР #1",
                "1 день", false, "почтальон");
        DeliveryHistory object3 = new DeliveryHistory("Семен Семенович", "Юный радиолюбитель #1",
                "0 дней", true, "бандероль на почте");

        return FXCollections.observableArrayList(object1, object2, object3);
    }

    public TableView getTableAllPublication() {

        TableView table = new TableView<AllPublication>();

        TableColumn indexOfPublicationCol
                = new TableColumn<AllPublication, Integer>("indexOfPublicationCol");
        TableColumn nameOfPublicationCol
                = new TableColumn<AllPublication, String>("nameOfPublicationCol");
        TableColumn periodOfPublicationCol
                = new TableColumn<AllPublication, String>("periodOfPublicationCol");
        TableColumn costOfSubscriptionCol
                = new TableColumn<AllPublication, Double>("costOfSubscriptionCol");

        indexOfPublicationCol.setCellValueFactory(new PropertyValueFactory<>("indexOfPublication"));
        nameOfPublicationCol.setCellValueFactory(new PropertyValueFactory<>("nameOfPublication"));
        periodOfPublicationCol.setCellValueFactory(new PropertyValueFactory<>("periodOfPublication"));
        costOfSubscriptionCol.setCellValueFactory(new PropertyValueFactory<>("costOfSubscription"));

        table.setItems(getAllPublication());

        table.getColumns().addAll(indexOfPublicationCol, nameOfPublicationCol,
                periodOfPublicationCol, costOfSubscriptionCol);

        return table;
    }

    public TableView getTableCurrentSubscriptions() {

        TableView table = new TableView<CurrentSubscriptions>();

        TableColumn FIOCol
                = new TableColumn<CurrentSubscriptions, String>("FIO");
        TableColumn postCol
                = new TableColumn<CurrentSubscriptions, String>("post");
        TableColumn nameOfPublicationCol
                = new TableColumn<CurrentSubscriptions, String>("nameOfPublication");
        TableColumn periodOfSubscriptionFromCol
                = new TableColumn<CurrentSubscriptions, String>("periodOfSubscriptionFrom");
        TableColumn periodOfSubscriptionToCol
                = new TableColumn<CurrentSubscriptions, String>("periodOfSubscriptionTo");

        FIOCol.setCellValueFactory(new PropertyValueFactory<>("FIO"));
        postCol.setCellValueFactory(new PropertyValueFactory<>("post"));
        nameOfPublicationCol.setCellValueFactory(new PropertyValueFactory<>("nameOfPublication"));
        periodOfSubscriptionFromCol.setCellValueFactory(new PropertyValueFactory<>("periodOfSubscriptionFrom"));
        periodOfSubscriptionToCol.setCellValueFactory(new PropertyValueFactory<>("periodOfSubscriptionTo"));

        table.setItems(getCurrentSubscriptions());

        table.getColumns().addAll(FIOCol, postCol, nameOfPublicationCol,
                periodOfSubscriptionFromCol, periodOfSubscriptionToCol);

        return table;
    }

    public TableView getTableDeliveryHistory() {

        TableView table = new TableView<DeliveryHistory>();

        TableColumn FIOCol
                = new TableColumn<DeliveryHistory, Integer>("FIO");
        TableColumn nameOfPublicationCol
                = new TableColumn<DeliveryHistory, String>("nameOfPublication");
        TableColumn estimatedDeliveryDateCol
                = new TableColumn<DeliveryHistory, String>("estimatedDeliveryDate");
        TableColumn statusOfDeliveryCol
                = new TableColumn<DeliveryHistory, Boolean>("statusOfDelivery");
        TableColumn typeOfDeliveryCol
                = new TableColumn<DeliveryHistory, String>("typeOfDelivery");

        FIOCol.setCellValueFactory(new PropertyValueFactory<>("FIO"));
        nameOfPublicationCol.setCellValueFactory(new PropertyValueFactory<>("nameOfPublication"));
        estimatedDeliveryDateCol.setCellValueFactory(new PropertyValueFactory<>("estimatedDeliveryDate"));
        statusOfDeliveryCol.setCellValueFactory(new PropertyValueFactory<>("statusOfDelivery"));
        typeOfDeliveryCol.setCellValueFactory(new PropertyValueFactory<>("typeOfDelivery"));

        table.setItems(getDeliveryHistory());

        table.getColumns().addAll(FIOCol, nameOfPublicationCol,
                estimatedDeliveryDateCol, statusOfDeliveryCol, typeOfDeliveryCol);

        return table;
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
                    .getConnection("jdbc:postgresql://localhost:5432/testbase", "postgres", "12345678");
            c.setAutoCommit(false);
            System.out.println("-- Opened database successfully");
            String sql;

            //--------------- INSERT ROWS ---------------
            stmt = c.createStatement();
            sql = "INSERT INTO CURRENT_SUBSCRIPTION (FIO, post, nameOfPublication," +
                    "periodOfSubscriptionFrom, periodOfSubscriptionTo) " +
                    "VALUES ();";
            //TO DO использовать String format
            //stmt.executeUpdate(sql);

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

}
