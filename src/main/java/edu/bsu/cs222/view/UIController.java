package edu.bsu.cs222.view;

import com.mashape.unirest.http.exceptions.UnirestException;
import edu.bsu.cs222.model.*;
import javafx.application.Application;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class UIController extends Application {

    private final int WIDTH = 600;
    private final int HEIGHT = 300;

    public SentimentAnalysisParser sentimentAnalysisParser = new SentimentAnalysisParser();
    public ArrayList<Response> responseList = new ArrayList<>();

    private Questions questions = new Questions();
    private HashMap<Integer, String> inputMap = new HashMap<>();
    private ErrorHandler errorHandler = new ErrorHandler();
    private TextField inputTextField = new TextField();
    private Mapper mapper = new Mapper();

    int currentQuestion = 1;


    //private Label appName = new Label("Character Designer");

    private Label questionLabel = new Label(questions.getQuestion(currentQuestion));
    private Label errorLabel = new Label();
    private Label resultLabel = new Label();

    //private VBox mainBox = new VBox();

    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Sentiment Analyzer v0.1");

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.TOP_CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Text scenetitle = new Text("Character Designer");
        GridPane.setHalignment(scenetitle, HPos.CENTER);
        scenetitle.setFont(Font.font("Tahoma", FontWeight.BOLD, 20));
        grid.add(scenetitle, 0, 0, 1, 2);
        GridPane.setHalignment(questionLabel, HPos.CENTER);
        grid.add(questionLabel, 0, 2);

        grid.add(inputTextField, 0, 3);
        inputTextField.setPrefWidth(550);
        inputTextField.setPrefHeight(100);

        GridPane.setHalignment(errorLabel, HPos.CENTER);

        grid.add(errorLabel, 0,4);

        Button nextButton = new Button("Next");
        Button backButton = new Button("Back");
        Button clearButton = new Button("Clear");
        backButton.setVisible(false);



        grid.add(nextButton, 0, 5);
        grid.add(backButton, 0, 7);
        grid.add(clearButton, 0, 6);







        /*
        mainBox = new VBox();


        mainBox.getChildren().add(appName).setAlignment(Pos.CENTER);
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
        */

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

        Scene scene = new Scene(grid, WIDTH, HEIGHT);
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