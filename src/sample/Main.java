package sample;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class Main extends Application {
    private TableView table = new TableView();
    @Override
    public void start(Stage primaryStage) throws Exception {
        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Controller controller = new Controller();

        Button switchToTableAllPublication = new Button("AllPublication");
        Button switchToCurrentSubscriptions = new Button("CurrentSubscriptions");
        Button switchToDeliveryHistory = new Button("DeliveryHistory");


        HBox mainHBox = new HBox(switchToTableAllPublication,
                switchToCurrentSubscriptions, switchToDeliveryHistory);

        VBox tableBox = new VBox(table);
        VBox mainVBox = new VBox(mainHBox, tableBox);


        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(mainVBox, 600, 500));
        primaryStage.show();

        switchToTableAllPublication.setOnAction(e -> {
            tableBox.getChildren().clear();
            table = controller.getTableAllPublication();
            tableBox.getChildren().add(table);

        });
        switchToCurrentSubscriptions.setOnAction(e -> {
            tableBox.getChildren().clear();
            table = controller.getTableCurrentSubscriptions();
            tableBox.getChildren().add(table);
        });
        switchToDeliveryHistory.setOnAction(e -> {
            tableBox.getChildren().clear();
            table = controller.getTableDeliveryHistory();
            tableBox.getChildren().add(table);
        });

    }

    public static void main(String[] args) {
        launch(args);
    }
}
