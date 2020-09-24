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
        TableView table = new TableView();
        Controller controller = new Controller();
        table = controller.getTableDeliveryHistory();
        VBox mainVBox = new VBox(mainHBox, table);


        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(mainVBox, 600, 500));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
