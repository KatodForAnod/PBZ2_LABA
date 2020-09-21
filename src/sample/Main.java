package sample;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;




public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));

        HBox mainHBox = new HBox();
        TableView table = createTableAboutWarehouses();
        VBox mainVBox = new VBox(mainHBox, table);


        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(mainVBox, 500, 500));
        primaryStage.show();
    }

    public TableView createTableAboutWarehouses() {
        Controller controller = new Controller();

        TableView table = new TableView<TableInformationAboutWarehouses>();

        TableColumn numberCol
                = new TableColumn<TableInformationAboutWarehouses, Integer>("Number");

        TableColumn nameCol
                = new TableColumn<TableInformationAboutWarehouses, String>("Name");

        TableColumn telephoneNumberCol
                = new TableColumn<TableInformationAboutWarehouses, String>("Telephone number");

        numberCol.setCellValueFactory(new PropertyValueFactory<>("number"));
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        telephoneNumberCol.setCellValueFactory(new PropertyValueFactory<>("telephoneNumber"));

        ObservableList<TableInformationAboutWarehouses> list
                = controller.getTableInformationAboutWarehouses();

        table.setItems(list);

        table.getColumns().addAll(numberCol, nameCol, telephoneNumberCol);

        return table;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
