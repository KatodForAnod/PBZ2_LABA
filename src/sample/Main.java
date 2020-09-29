package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
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
        Button editDeliveryHistory = new Button("edit history");

        HBox mainHBox = new HBox(switchToTableAllPublication,
                switchToCurrentSubscriptions, switchToDeliveryHistory, addSubscriber, editDeliveryHistory);

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
            Button findBtn = new Button("find");
            Button editBtn = new Button("edit");
            Button deleteBtn = new Button("delete");

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

            HBox hBox = new HBox(forLabel, forField, btn, findBtn, editBtn, deleteBtn);
            hBox.setAlignment(Pos.CENTER);

            StackPane secondaryLayout = new StackPane();
            secondaryLayout.getChildren().add(hBox);

            Scene secondScene = new Scene(secondaryLayout, 450, 200);

            Stage newWindow = new Stage();
            newWindow.setTitle("Second Stage");

            newWindow.setScene(secondScene);
            newWindow.initModality(Modality.WINDOW_MODAL);

            newWindow.initOwner(primaryStage);

            newWindow.setX(primaryStage.getX() + 200);
            newWindow.setY(primaryStage.getY() + 100);
            newWindow.show();

            btn.setOnAction(er -> {
                controller.addSubscriberToDataBase(FIOField.getText(),
                        postField.getText(),
                        nameOfPublicationField.getText(),
                        periodOfSubscriptionFromField.getText(),
                        periodOfSubscriptionToField.getText());
            });
            findBtn.setOnAction(er -> {
                String[] dataFromDatabase =
                        controller.findDataFromCurrentSubscription(FIOField.getText());
                try {
                    nameOfPublicationField.setText(dataFromDatabase[1]);
                    postField.setText(dataFromDatabase[0]);
                    periodOfSubscriptionFromField.setText(dataFromDatabase[2]);
                    periodOfSubscriptionToField.setText(dataFromDatabase[3]);
                } catch (ArrayIndexOutOfBoundsException eq) {
                    eq.printStackTrace();
                }

            });
            editBtn.setOnAction(er -> {
                controller.editInformationToCurrentSubscription(FIOField.getText(),
                        postField.getText(),
                        nameOfPublicationField.getText(),
                        periodOfSubscriptionFromField.getText(),
                        periodOfSubscriptionToField.getText());
            });
            deleteBtn.setOnAction(er -> {
                controller.deleteInformationFromCurrentSubscription(FIOField.getText());
            });
        });
        editDeliveryHistory.setOnAction(e -> {
            Button btn = new Button("add");
            Button findBtn = new Button("find");
            Button editBtn = new Button("edit");
            Button deleteBtn = new Button("delete");

            ToggleGroup group = new ToggleGroup();

            Label FIOLabel = new Label("FIO");
            Label nameOfPublicationLabel = new Label("nameOfPublication");
            Label estimatedDeliveryDateLabel = new Label("estimatedDeliveryDate");
            Label statusOfDeliveryLabel = new Label("statusOfDelivery");
            Label typeOfDeliveryLabel = new Label("typeOfDelivery");

            TextField FIOField = new TextField();
            TextField nameOfPublicationField = new TextField();
            TextField estimatedDeliveryDateField = new TextField();
            TextField typeOfDeliveryField = new TextField();

            RadioButton trueBtn = new RadioButton("true");
            RadioButton falseBtn = new RadioButton("false");
            trueBtn.setToggleGroup(group);
            falseBtn.setToggleGroup(group);

            HBox forToggle = new HBox(trueBtn, falseBtn);
            VBox forLabel = new VBox(FIOLabel, nameOfPublicationLabel,
                    estimatedDeliveryDateLabel, statusOfDeliveryLabel,
                    typeOfDeliveryLabel);
            VBox forField = new VBox(FIOField, nameOfPublicationField,
                    estimatedDeliveryDateField, forToggle,
                    typeOfDeliveryField);

            forLabel.setSpacing(8);
            forLabel.setPadding(new Insets(2));

            HBox hBox = new HBox(forLabel, forField, btn, findBtn, editBtn, deleteBtn);
            hBox.setAlignment(Pos.CENTER);

            StackPane secondaryLayout = new StackPane();
            secondaryLayout.getChildren().add(hBox);

            Scene secondScene = new Scene(secondaryLayout, 450, 200);

            Stage newWindow = new Stage();
            newWindow.setTitle("Second Stage");

            newWindow.setScene(secondScene);
            newWindow.initModality(Modality.WINDOW_MODAL);

            newWindow.initOwner(primaryStage);

            newWindow.setX(primaryStage.getX() + 200);
            newWindow.setY(primaryStage.getY() + 100);
            newWindow.show();

            btn.setOnAction(er -> {
                controller.addInformationToDeliveryHistory(trueBtn.isSelected(), FIOField.getText(),
                        nameOfPublicationField.getText(),
                        estimatedDeliveryDateField.getText(),
                        typeOfDeliveryField.getText());
            });

            findBtn.setOnAction(er -> {
                String[] dataFromDatabase =
                        controller.findInformationFromDeliveryHistory(FIOField.getText());
                try {
                    nameOfPublicationField.setText(dataFromDatabase[0]);
                    estimatedDeliveryDateField.setText(dataFromDatabase[1]);
                    typeOfDeliveryField.setText(dataFromDatabase[2]);
                    //да, выглядит еще ужаснее чем все остальное
                    if (dataFromDatabase[3].equals("t")) {
                        trueBtn.fire();
                    } else {
                        falseBtn.fire();
                    }
                } catch (ArrayIndexOutOfBoundsException eq) {
                    eq.printStackTrace();
                }
            });

            editBtn.setOnAction(er -> {
                controller.editInformationToDeliveryHistory(trueBtn.isSelected(), FIOField.getText(),
                        nameOfPublicationField.getText(),
                        estimatedDeliveryDateField.getText(),
                        typeOfDeliveryField.getText());
            });
            /*
            deleteBtn.setOnAction(er -> {
                controller.deleteInformationFromCurrentSubscription(FIOField.getText());
            });

             */
        });

    }

    public static void main(String[] args) {
        launch(args);
    }
}
