package uos;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class FXApp extends Application {

    Pane root = new Pane();
    Scene scene = new Scene(root, 800, 600);
    Label helloLabel = new Label();
    Label outLabel = new Label();
    TextField inTextField = new TextField();
    Button submitButton = new Button();
    EventHandler<ActionEvent> bHandler = new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            String str = inTextField.getText();
            outLabel.setText(str);
        }
    };

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setScene(scene);
        primaryStage.show();
        helloLabel.setText("Hello");

        outLabel.setText("some result");
        outLabel.setLayoutX(10);
        outLabel.setLayoutY(100);

        inTextField.setText("enter something");
        inTextField.setLayoutX(10);
        inTextField.setLayoutY(200);

        submitButton.setText("Click Me");
        submitButton.setLayoutX(10);
        submitButton.setLayoutY(300);
        submitButton.setOnAction(bHandler);
        root.getChildren().addAll(helloLabel, outLabel, inTextField, submitButton);
    }
}
