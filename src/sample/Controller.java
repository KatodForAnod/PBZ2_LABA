package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class Controller {

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
                "без професии", "Наука и жизнь", "полгода");
        CurrentSubscriptions object2 = new CurrentSubscriptions("Александр Сергеевич",
                "студент", "Красивые места СССР", "год");
        CurrentSubscriptions object3 = new CurrentSubscriptions("Семен Семенович",
                "инженер", "Юный радиолюбитель", "полгода");

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
        TableColumn periodOfSubscriptionCol
                = new TableColumn<CurrentSubscriptions, String>("periodOfSubscription");

        FIOCol.setCellValueFactory(new PropertyValueFactory<>("FIO"));
        postCol.setCellValueFactory(new PropertyValueFactory<>("post"));
        nameOfPublicationCol.setCellValueFactory(new PropertyValueFactory<>("nameOfPublication"));
        periodOfSubscriptionCol.setCellValueFactory(new PropertyValueFactory<>("periodOfSubscription"));

        table.setItems(getCurrentSubscriptions());

        table.getColumns().addAll(FIOCol, postCol, nameOfPublicationCol, periodOfSubscriptionCol);

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
}
