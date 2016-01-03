package at.aau.esop15.course11.javafx;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/**
 * Created by mlux on 15.12.2015.
 */
public class JavafxSimple extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Button button = new Button("Hello World");
        StackPane rootPane = new StackPane();
        rootPane.getChildren().add(button);
        rootPane.getChildren().add(new Circle(50));
        Scene scene = new Scene(rootPane, 640, 480);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
