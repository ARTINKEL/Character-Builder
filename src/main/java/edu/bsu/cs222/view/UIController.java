package edu.bsu.cs222.view;

import com.mashape.unirest.http.exceptions.UnirestException;
import edu.bsu.cs222.model.*;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.HashMap;
import java.io.IOException;

public class UIController extends Application {

    private final int WIDTH = 500;
    private final int HEIGHT = 430;

    private HashMap<Integer, Response> inputMap = new HashMap<>();

    private QuestionsMap questionsMap = new QuestionsMap();
    private ErrorHandler errorHandler = new ErrorHandler();
    private TextArea inputTextArea = new TextArea();
    private StatGenerator statGenerator = new StatGenerator();

    private int currentQuestion = 1;

    private Label questionLabel = new Label(questionsMap.getQuestion(currentQuestion));
    private Label errorLabel = new Label();
    private Label resultLabel = new Label();
    private Label helpLabel = new Label();
    private Label abilityScoreLabel = new Label();

    private String raceResult = "";
    private String classResult = "";

    private GridPane grid = new GridPane();
    private GridPane resultsGrid = new GridPane();

    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Character Designer v0.2.0");

        grid.setAlignment(Pos.TOP_CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Text sceneTitle = new Text("Character Designer");
        GridPane.setHalignment(sceneTitle, HPos.CENTER);
        sceneTitle.setFont(Font.font("Castellar", FontWeight.BOLD, 20));
        grid.add(sceneTitle, 0, 0, 1, 2);
        GridPane.setHalignment(questionLabel, HPos.CENTER);
        grid.add(questionLabel, 0, 2);

        grid.add(inputTextArea, 0, 3);
        inputTextArea.setPrefWidth(550);
        inputTextArea.setPrefHeight(100);
        inputTextArea.setPromptText("Enter Response Here.");
        inputTextArea.setWrapText(true);

        GridPane.setHalignment(errorLabel, HPos.CENTER);

        grid.add(errorLabel, 0,4);

        Button nextButton = new Button("Next");
        Button backButton = new Button("Back");
        Button clearButton = new Button("Clear");
        Button helpButton = new Button("Help");
        backButton.setVisible(false);

        primaryStage.setOnCloseRequest(e -> Platform.exit());

        grid.add(nextButton, 0, 5);
        grid.add(clearButton, 0, 6);
        grid.add(backButton, 0, 7);
        grid.add(helpButton, 0, 8);


        nextButton.setOnAction(event -> {
            if (inputTextArea.getText().isEmpty()) {
                errorLabel.setText(errorHandler.returnError("blankField"));
            } else {
                errorLabel.setText(null);
                recordResponse();
                if (finalQuestion()) {
                    calculateResult();
                    openResultWindow();
                } else {
                    incrementQuestion();
                    if (!getQuestionResponse().isEmpty()) {
                        populateTextField();
                    }
                    backButton.setVisible(true);
                    if (finalQuestion()) {
                        nextButton.setText("Get Results");
                    }
                    Label blankLabel = new Label("");
                    StackPane placeholderLayout = new StackPane();
                    placeholderLayout.getChildren().add(blankLabel);
                }
            }
        });


        backButton.setOnAction(event -> {
            if (!inputTextArea.getText().isEmpty()) {
                recordResponse();
            }
            nextButton.setText("Next");
            decrementQuestion();
            if (firstQuestion()) {
                backButton.setVisible(false);
            }
            populateTextField();
        });

        clearButton.setOnAction(event -> inputTextArea.setText(""));
        helpButton.setOnAction(event -> openHelpWindow());
        Scene scene = new Scene(grid, WIDTH, HEIGHT);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private boolean finalQuestion() { return (currentQuestion == 10); }

    private boolean firstQuestion() { return (currentQuestion == 1); }

    private void recordResponse() {
        Response response = new Response(inputTextArea.getText().toLowerCase());
        if (getQuestionResponse().isEmpty()) {
            inputMap.put(currentQuestion, response);
        }
        else {
            removeResponse();
            inputMap.put(currentQuestion, response);
        }
        inputTextArea.setText("");
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
        questionLabel.setWrapText(true);
        questionLabel.setText(questionsMap.getQuestion(currentQuestion));
    }

    private void populateTextField() {
        inputTextArea.setText(getQuestionResponse());
    }

    private String getQuestionResponse() {
        Response response = inputMap.get(currentQuestion);
        if (response != null) {
            return response.getResponse();
        }
        else {
            return "";
        }
    }

    private void removeResponse() {
        inputMap.remove(currentQuestion);
    }

    private void calculateResult() {
        Mapper mapper = null;
        try {
            mapper = new Mapper(inputMap);
        } catch (IOException | UnirestException e) {
            e.printStackTrace();
        }
        if (mapper != null) {
            raceResult = mapper.calculateRaceResult();
            classResult = mapper.calculateClassResult();
            HashMap<String, Integer> rawAbilityScores = statGenerator.generateStandardArray(classResult);
            HashMap<String, Integer> adjustedAbilityScores = statGenerator.applyRacialBonus(rawAbilityScores, raceResult);
            populateAbilityScoreText(adjustedAbilityScores);
        }
    }

    private void populateAbilityScoreText(HashMap<String, Integer> map) {

        String result = "Strength: " + map.get("Strength").toString() + "\n" +
                        "Dexterity: " + map.get("Dexterity").toString() + "\n" +
                        "Constitution: " + map.get("Constitution").toString() + "\n" +
                        "Intelligence: " + map.get("Intelligence").toString() + "\n" +
                        "Wisdom: " + map.get("Wisdom").toString() + "\n" +
                        "Charisma: " + map.get("Charisma").toString();

        abilityScoreLabel.setText(result);
    }

    private void openResultWindow() {
        displayResult();
        grid.add(resultLabel, 0, 2);

        StackPane secondaryLayout = new StackPane();
        secondaryLayout.getChildren().add(resultsGrid);
        resultsGrid.add(resultLabel, 0, 1);
        resultsGrid.add(abilityScoreLabel, 0, 2);

        Scene secondScene = new Scene(secondaryLayout, 300, 175);

        Stage secondStage = new Stage();
        secondStage.setTitle("Your results");
        secondStage.setScene(secondScene);

        secondStage.show();
    }

    private void openHelpWindow() {
        displayHelp();
        grid.add(helpLabel, 0, 2);

        StackPane thirdLayout = new StackPane();
        thirdLayout.getChildren().add(helpLabel);

        Scene thirdScene = new Scene(thirdLayout, 300, 100);

        Stage thirdStage = new Stage();
        thirdStage.setTitle("Help");
        thirdStage.setScene(thirdScene);

        thirdStage.show();
    }

    private void displayResult() {
        resultLabel.setText("Your race: " + raceResult + "\nYour class: " + classResult);
    }

    private void displayHelp() {
        helpLabel.setText("For best results please use full and complete sentences\n" +
                "The more you put into this, the more you will get out\n" +
                "Result will most likely take a minute to be calculated\n" +
                "Use American English (honor vs honour, gray vs grey, etc");
    }
}