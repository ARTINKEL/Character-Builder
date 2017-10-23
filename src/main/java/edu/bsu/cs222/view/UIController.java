package edu.bsu.cs222.view;

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
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class UIController extends Application {

    private final int WIDTH = 500;
    private final int HEIGHT = 400;

    private InputMap inputMap = new InputMap();
    private ContentCreator contentCreator = new ContentCreator();

    private Questions questions = new Questions();
    private ErrorHandler errorHandler = new ErrorHandler();
    private TextField inputTextField = new TextField();

    private int currentQuestion = 1;

    private Label questionLabel = new Label(questions.getQuestion(currentQuestion));
    private Label errorLabel = new Label();
    private Label resultLabel = new Label();

    private String raceResult = "";
    private String classResult = "";

    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Character Designer v0.1");

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.TOP_CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Text sceneTitle = new Text("Character Designer");
        GridPane.setHalignment(sceneTitle, HPos.CENTER);
        sceneTitle.setFont(Font.font("Tahoma", FontWeight.BOLD, 20));
        grid.add(sceneTitle, 0, 0, 1, 2);
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

        grid.add(resultLabel, 0, 8);

        nextButton.setOnAction(event -> {
            if (inputTextField.getText().isEmpty()) {
                errorLabel.setText(errorHandler.returnError("blankField"));
                return;
            } else {
                errorLabel.setText(null);
                recordResponse();
                if (currentQuestion != 10) {
                    incrementQuestion();
                    if (currentQuestion == 10) {
                        nextButton.setText("Submit");
                    }
                } else {
                    try {
                        Mapper mapper = new Mapper(inputMap);
                        raceResult = mapper.calculateResult("race");
                        classResult = mapper.calculateResult("class");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    displayResult();
                }
            }
            backButton.setVisible(true);
        });

        backButton.setOnAction(event -> {
            decrementQuestion();
            populateTextField();
            removeResponse();
            if (currentQuestion == 1) {
                backButton.setVisible(false);
            }
        });

        clearButton.setOnAction(event -> inputTextField.setText(""));

        Scene scene = new Scene(grid, WIDTH, HEIGHT);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void recordResponse() {
        Response response = contentCreator.createResponse(inputTextField.getText());
        inputMap.addInput(currentQuestion, response);
        inputTextField.setText("");
    }

    private void incrementQuestion() {
        currentQuestion++;
        populateQuestion();
    }

    private void decrementQuestion() {
        currentQuestion--;
        populateQuestion();
    }

    private void populateQuestion() {
        questionLabel.setText(questions.getQuestion(currentQuestion));
    }

    private void populateTextField() {
        inputTextField.setText(inputMap.getInputMap().get(currentQuestion).getResponse());
    }

    private void removeResponse() {
        inputMap.removeInput(currentQuestion);
    }

    private void displayResult() {
        resultLabel.setText("Your race: " + raceResult + "\nYour class: " + classResult);
    }
}