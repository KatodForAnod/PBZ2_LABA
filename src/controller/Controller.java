package controller;

import database.PostgreSQL;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.AllPublication;
import model.CurrentSubscriptions;
import model.DeliveryHistory;

public class Controller {

    private PostgreSQL postgreSQL = new PostgreSQL();

    public ObservableList<AllPublication> getAllPublication() {

        AllPublication object1 = new AllPublication(1,
                "Наука и жизнь", "дважды в месяц", 1.0);
        AllPublication object2 = new AllPublication(2,
                "Юный радиолюбитель", "дважды в неделю", 1.5);
        AllPublication object3 = new AllPublication(3,
                "Красивые места СССР", "один раз в неделю", (double) 20);

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

        table.setItems(postgreSQL.getCurrentSubscriptions());

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

        table.setItems(postgreSQL.getDeliveryHistory());

        table.getColumns().addAll(FIOCol, nameOfPublicationCol,
                estimatedDeliveryDateCol, statusOfDeliveryCol, typeOfDeliveryCol);

        return table;
    }

    public void addSubscriberToDataBase(String... textFields) {
        postgreSQL.addSubscriberToDataBase(textFields);
    }

    public String[] findDataFromCurrentSubscription(String FIO) {
        return postgreSQL.findDataFromCurrentSubscription(FIO);
    }

    public void editInformationToCurrentSubscription(String... textFields) {
        postgreSQL.editInformationToCurrentSubscription();
    }

    public void deleteInformationFromCurrentSubscription(String FIO) {
        postgreSQL.deleteInformationFromCurrentSubscription(FIO);
    }

    public void addInformationToDeliveryHistory(boolean statusOfDelivery, String... textFields) {
        postgreSQL.addInformationToDeliveryHistory(statusOfDelivery, textFields);
    }

    public String[] findInformationFromDeliveryHistory(String FIO) {
        return postgreSQL.findInformationFromDeliveryHistory(FIO);
    }

    public void editInformationToDeliveryHistory(boolean statusOfDelivery, String... textFields) {
        postgreSQL.editInformationToDeliveryHistory(statusOfDelivery, textFields);
    }

    public void deleteInformationFromDeliveryHistory(String FIO) {
        postgreSQL.deleteInformationFromDeliveryHistory(FIO);
    }
}
