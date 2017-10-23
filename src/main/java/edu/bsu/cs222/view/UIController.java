package edu.bsu.cs222.view;

import com.mashape.unirest.http.exceptions.UnirestException;
import edu.bsu.cs222.model.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class UIController extends Application {

    private final int WIDTH = 500;
    private final int HEIGHT = 100;

    public SentimentAnalysisParser sentimentAnalysisParser = new SentimentAnalysisParser();
    public ArrayList<Response> responseList = new ArrayList<>();

    private Questions questions = new Questions();
    private HashMap<Integer, String> inputMap = new HashMap<>();
    private ErrorHandler errorHandler = new ErrorHandler();
    private TextField inputTextField = new TextField();
    private Mapper mapper = new Mapper();

    int currentQuestion = 1;

    private Label questionLabel = new Label(questions.getQuestion(currentQuestion));
    private Label errorLabel = new Label();
    private Label resultLabel = new Label();

    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Sentiment Analyzer v0.1");

        final VBox mainBox = new VBox();

        mainBox.getChildren().add(questionLabel);
        mainBox.getChildren().add(inputTextField);
        mainBox.getChildren().add(errorLabel);

        final Button backButton = new Button("Back");
        final Button clearButton = new Button("Clear");
        final Button nextButton = new Button("Next");
        backButton.setVisible(false);

        final HBox secBox = new HBox();

        secBox.getChildren().addAll(backButton, clearButton, nextButton);
        mainBox.getChildren().add(secBox);
        mainBox.getChildren().add(resultLabel);

        nextButton.setOnAction(event -> {
            if (inputTextField.getText().isEmpty()) {
                errorLabel.setText(errorHandler.returnError("blankField"));
                return;
            } else {
                errorLabel.setText(null);
                recordResponse();
                if (currentQuestion == 10) {
                    try {
                        parseForSentimentAnalysis();
                    } catch (UnirestException e) {
                        e.printStackTrace();
                    }
                }
                if (currentQuestion != 10) {
                    incrementQuestion();
                    if (currentQuestion == 10) {
                        nextButton.setText("Submit");
                    }
                }
                displayResult();
            }
            backButton.setVisible(true);
        });

        backButton.setOnAction(event -> {
            /*
            decrementQuestion();
            populateTextField();
            removeResponse();
            if (currentQuestion == 1) {
                backButton.setVisible(false);
            }
            */
            try {
                mapper.startMapper(responseList);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        clearButton.setOnAction(event -> inputTextField.setText(""));

        Scene scene = new Scene(mainBox, WIDTH, HEIGHT);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void recordResponse() {
        inputMap.put(currentQuestion, inputTextField.getText());
        inputTextField.setText("");
        System.out.println(inputMap.get(currentQuestion));
    }

    private void incrementQuestion() {
        currentQuestion++;
        populateQuestion();
    }

    private void decrementQuestion() {
        currentQuestion--;
        populateQuestion();
    }

    private void parseForSentimentAnalysis() throws UnirestException {
        responseList = sentimentAnalysisParser.createResponseObjects(inputMap);
    }

    private void populateQuestion() {
        questionLabel.setText(questions.getQuestion(currentQuestion));
    }

    private void populateTextField() {
        inputTextField.setText(inputMap.get(currentQuestion));
    }

    private void removeResponse() {
        inputMap.remove(currentQuestion);
    }

    private void displayResult() {
        resultLabel.setText("SUCCESS");
    }
}