package sample;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
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
        Button addSubscriber = new Button("Add subscriber");

        HBox mainHBox = new HBox(switchToTableAllPublication,
                switchToCurrentSubscriptions, switchToDeliveryHistory, addSubscriber);

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
        addSubscriber.setOnAction(e -> {
            Button btn = new Button("add");

            Label FIOLabel = new Label("FIO");
            Label postLabel = new Label("post");
            Label nameOfPublicationLabel = new Label("nameOfPublication");
            Label periodOfSubscriptionFromLabel = new Label("periodOfSubscriptionFrom");
            Label periodOfSubscriptionToLabel = new Label("periodOfSubscriptionTo");

            TextField FIOField = new TextField();
            TextField postField = new TextField();
            TextField nameOfPublicationField = new TextField();
            TextField periodOfSubscriptionFromField = new TextField();
            TextField periodOfSubscriptionToField = new TextField();

            VBox forLabel = new VBox(FIOLabel, postLabel,
                    nameOfPublicationLabel, periodOfSubscriptionFromLabel,
                    periodOfSubscriptionToLabel);
            VBox forField = new VBox(FIOField, postField,
                    nameOfPublicationField, periodOfSubscriptionFromField,
                    periodOfSubscriptionToField);

            forLabel.setSpacing(8);
            forLabel.setPadding(new Insets(2));

            HBox hBox = new HBox(forLabel, forField, btn);
            hBox.setAlignment(Pos.CENTER);

            StackPane secondaryLayout = new StackPane();
            secondaryLayout.getChildren().add(hBox);

            Scene secondScene = new Scene(secondaryLayout, 350, 200);

            Stage newWindow = new Stage();
            newWindow.setTitle("Second Stage");

            newWindow.setScene(secondScene);
            newWindow.initModality(Modality.WINDOW_MODAL);

            newWindow.initOwner(primaryStage);

            newWindow.setX(primaryStage.getX() + 200);
            newWindow.setY(primaryStage.getY() + 100);
            newWindow.show();

            btn.setOnAction(er -> {
                //вызов метода добавления

            });
        });

    }

    public static void main(String[] args) {
        launch(args);
    }
}
