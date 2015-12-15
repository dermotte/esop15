package at.aau.esop15.course11.javafx;

import at.aau.esop15.course07.NameGenerator;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * Created by mlux on 15.12.2015.
 */
public class ExtendedJavafxNameGenerator extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        // setting up the grid:
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setHgap(10);
        grid.setVgap(10);

        // creating the components
        Label labelTitle = new Label("Fantasy Name Generator v2.0");
        labelTitle.setFont(Font.font("Roboto", 22d));
        Label labelPattern = new Label("Please specify a pattern:");
        ComboBox<String> comboBox = new ComboBox<>();
        comboBox.getItems().addAll("t Cvc Cvcc",
                "Cvcvvc Cvcc, known as .the t",
                "Vccv Cvvcvcc",
                "Cc'Vc Ccvcv",
                "t C'Cv Vccvcv",
                "Vcvcv Vcvvcvcvv",
                "Vvccvc",
                "Cvccvc");
        comboBox.setEditable(true);
        Button buttonGenerate = new Button("Generate");
        TextArea outArea = new TextArea();

        // adding event handlers:
        buttonGenerate.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                outArea.appendText(NameGenerator.getRandomName(comboBox.getEditor().getText()) + "\n");
            }
        });

        // maximizing the middle column:
        ColumnConstraints col1 = new ColumnConstraints();
        ColumnConstraints col2 = new ColumnConstraints(100, 100, Double.MAX_VALUE, Priority.ALWAYS, HPos.CENTER, true);
        grid.getColumnConstraints().addAll(col1, col2);

        // maximizing the last row
        RowConstraints row1 = new RowConstraints();
        RowConstraints row2 = new RowConstraints();
        RowConstraints row3 = new RowConstraints(100, 200, Double.MAX_VALUE, Priority.ALWAYS, VPos.TOP, true);
        grid.getRowConstraints().addAll(row1, row2, row3);

        // adding the components
        grid.add(labelTitle, 0, 0, 3, 1);
        grid.add(labelPattern, 0, 1);
        grid.add(comboBox, 1, 1);
        grid.add(buttonGenerate, 2, 1);
        grid.add(outArea, 0, 2, 3, 1);

        Scene scene = new Scene(grid, 640, 480);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Name Generator");
        primaryStage.show();
    }
}