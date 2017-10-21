package edu.bsu.cs222.view;

import edu.bsu.cs222.model.ResponseParser;
import edu.bsu.cs222.model.SentimentAnalysisParser;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class UIController extends Application{

    private final int WIDTH = 500;
    private final int HEIGHT = 100;

    private ResponseParser responseParser = new ResponseParser();
    private SentimentAnalysisParser sentimentAnalysisParser = new SentimentAnalysisParser();

    public void start (Stage primaryStage) throws Exception {
        primaryStage.setTitle("Sentiment Analyzer");

        final VBox mainBox = new VBox();
        final Label titleLabel = new Label("??? Question here ???");
        mainBox.getChildren().add(titleLabel);

        final TextField inputTextField = new TextField();
        mainBox.getChildren().add(inputTextField);

        final Button submitButton = new Button("Submit");
        // Add a Clear button?
        final Label errorLabel = new Label();
        final HBox secBox = new HBox();
        secBox.getChildren().addAll(submitButton, errorLabel);
        mainBox.getChildren().add(secBox);

        submitButton.setOnAction(event -> {
            if (inputTextField.getText().isEmpty()) {
                errorLabel.setText("Text field must not be blank.");
                return;
            }
        });

        Scene scene = new Scene(mainBox, WIDTH, HEIGHT);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
