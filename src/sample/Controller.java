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
        Controller controller = new Controller();

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
}
