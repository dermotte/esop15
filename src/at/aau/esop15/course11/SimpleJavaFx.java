package at.aau.esop15.course11;

/**
 * Created by mlux on 15.12.2015.
 */

import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.stage.Stage;

public class SimpleJavaFx extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("My JavaFX Window");
        primaryStage.show();
    }
}
