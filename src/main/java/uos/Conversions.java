package uos;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Conversions extends Application {
    Pane root = new Pane();
    Scene scene = new Scene(root, 800, 600);
    ObservableList<String> list = FXCollections.observableArrayList("1. Kilograms to Pounds", "2. Metres to Yards", "3. Celsius to Fahrenheit");
    ComboBox<String> comboBox = new ComboBox<>(list);
    Button submitButton = new Button();
    TextField textField = new TextField();
    Label titleLabel = new Label("Conversion Program");
    Label textFieldLabel = new Label("enter a number:");
    Label resultLabel = new Label();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setScene(scene);
        primaryStage.show();
        titleLabel.setLayoutX(10);
        titleLabel.setLayoutY(10);
        comboBox.setLayoutX(10);
        comboBox.setLayoutY(100);

        textFieldLabel.setLayoutX(10);
        textFieldLabel.setLayoutY(180);
        textField.setLayoutX(10);
        textField.setLayoutY(200);

        submitButton.setText("Convert");
        submitButton.setLayoutX(10);
        submitButton.setLayoutY(300);

        resultLabel.setLayoutX(10);
        resultLabel.setLayoutY(400);
        resultLabel.setVisible(false);

        root.getChildren().addAll(titleLabel, comboBox, textFieldLabel, textField, submitButton, resultLabel);

        submitButton.setOnAction(event -> {
            double result;
            double number;
            try {
                number = Double.parseDouble(textField.getText());
            } catch (Exception e){
                new Alert(Alert.AlertType.ERROR, "Enter a number!").show();
                return;
            }

            String option = comboBox.getSelectionModel().getSelectedItem();
            if (option.startsWith("1.")){
                result = number * 2.2046;
            } else if (option.startsWith("2.")) {
                result = number * 1.0936;
            } else if (option.startsWith("3.")){
                result = ((number * 9) / 5) + 32;
            } else {
                result = 0;
            }
            if (result == 0){
                resultLabel.setText("Choose an option!");
            } else {
                resultLabel.setText("" + result);
                resultLabel.setVisible(true);
            }
        });
    }
}
