package sample;

import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class Controller {

    public ObservableList<AllPublication> getAllPublication() {
        return null;
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
                = new TableColumn<AllPublication, String>("costOfSubscriptionCol");

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
                = new TableColumn<AllPublication, Integer>("FIO");
        TableColumn postCol
                = new TableColumn<AllPublication, String>("post");
        TableColumn nameOfPublicationCol
                = new TableColumn<AllPublication, String>("nameOfPublication");
        TableColumn periodOfSubscriptionCol
                = new TableColumn<AllPublication, String>("periodOfSubscription");

        FIOCol.setCellValueFactory(new PropertyValueFactory<>("FIO"));
        postCol.setCellValueFactory(new PropertyValueFactory<>("post"));
        nameOfPublicationCol.setCellValueFactory(new PropertyValueFactory<>("nameOfPublication"));
        periodOfSubscriptionCol.setCellValueFactory(new PropertyValueFactory<>("periodOfSubscription"));

        table.setItems(getAllPublication());

        table.getColumns().addAll(FIOCol, nameOfPublicationCol,
                nameOfPublicationCol, periodOfSubscriptionCol);

        return table;
    }

    public TableView getTableDeliveryHistory() {

        TableView table = new TableView<DeliveryHistory>();

        TableColumn FIOCol
                = new TableColumn<AllPublication, Integer>("FIO");
        TableColumn nameOfPublicationCol
                = new TableColumn<AllPublication, String>("nameOfPublication");
        TableColumn estimatedDeliveryDateCol
                = new TableColumn<AllPublication, String>("estimatedDeliveryDate");
        TableColumn statusOfDeliveryCol
                = new TableColumn<AllPublication, String>("statusOfDelivery");
        TableColumn typeOfDeliveryCol
                = new TableColumn<AllPublication, String>("typeOfDelivery");

        FIOCol.setCellValueFactory(new PropertyValueFactory<>("FIO"));
        nameOfPublicationCol.setCellValueFactory(new PropertyValueFactory<>("nameOfPublication"));
        estimatedDeliveryDateCol.setCellValueFactory(new PropertyValueFactory<>("estimatedDeliveryDate"));
        statusOfDeliveryCol.setCellValueFactory(new PropertyValueFactory<>("statusOfDelivery"));
        typeOfDeliveryCol.setCellValueFactory(new PropertyValueFactory<>("typeOfDelivery"));

        table.setItems(getAllPublication());

        table.getColumns().addAll(FIOCol, nameOfPublicationCol,
                estimatedDeliveryDateCol, statusOfDeliveryCol, typeOfDeliveryCol);

        return table;
    }
}
