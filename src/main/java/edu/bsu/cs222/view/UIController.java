package edu.bsu.cs222.view;

import com.mashape.unirest.http.exceptions.UnirestException;
import edu.bsu.cs222.model.*;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.util.HashMap;
import java.io.IOException;

public class UIController {

    private Main main;

    public void setMain(Main main) {
        this.main = main;
    }

    private HashMap<Integer, Response> inputMap = new HashMap<>();

    private QuestionsMap questionsMap = new QuestionsMap();
    private ErrorHandler errorHandler = new ErrorHandler();

    private Label resultLabel = new Label();
    private Label helpLabel = new Label();
    private GridPane resultsGrid = new GridPane();

    private int currentQuestion = 1;
    private String raceResult = "";
    private String classResult = "";

    public Button nextButton;
    @FXML
    public TextArea inputTextArea;
    @FXML
    public Label errorLabel;
    @FXML
    public Button backButton;
    @FXML
    public Label questionLabel;
    @FXML
    public Button helpButton;
    @FXML
    public Button clearButton;

    @FXML
    private void clearButtonAction() {
        inputTextArea.setText("");
    }

    @FXML
    private void nextButtonAction() {
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
    }

    @FXML
    private void backButtonAction() {
        if (!inputTextArea.getText().isEmpty()) {
            recordResponse();
        }
        nextButton.setText("Next");
        decrementQuestion();
        if (firstQuestion()) {
            backButton.setVisible(false);
        }
        populateTextField();
    }

    @FXML
    private void populateQuestion() {
        questionLabel.setWrapText(true);
        questionLabel.setText(questionsMap.getQuestion(currentQuestion));
    }

    private void recordResponse() {
        Response response = new Response(inputTextArea.getText().toLowerCase());
        if (getQuestionResponse().isEmpty()) {
            inputMap.put(currentQuestion, response);
        } else {
            removeResponse();
            inputMap.put(currentQuestion, response);
        }
        inputTextArea.setText("");
    }

    private String getQuestionResponse() {
        Response response = inputMap.get(currentQuestion);
        if (response != null) {
            return response.getResponse();
        } else {
            return "";
        }
    }

    private void removeResponse() {
        inputMap.remove(currentQuestion);
    }

    private boolean finalQuestion() {
        return (currentQuestion == 10);
    }

    private boolean firstQuestion() {
        return (currentQuestion == 1);
    }

    private void incrementQuestion() {
        currentQuestion++;
        populateQuestion();
    }

    private void decrementQuestion() {
        currentQuestion--;
        populateQuestion();
    }

    private void calculateResult() {
        ResultCalculator mapper = null;
        try {
            mapper = new ResultCalculator(inputMap);
        } catch (IOException | UnirestException e) {
            e.printStackTrace();
        }
        if (mapper != null) {
            raceResult = mapper.calculateRaceResult();
            classResult = mapper.calculateClassResult();

        }
    }

    private void populateTextField() {
        inputTextArea.setText(getQuestionResponse());
    }

    @FXML
    private GridPane grid = new GridPane();

    @FXML
    public void openHelpWindow() {
        displayHelp();
        grid.add(helpLabel, 0, 2);

        StackPane thirdLayout = new StackPane();
        thirdLayout.getChildren().add(helpLabel);

        Scene thirdScene = new Scene(thirdLayout, 550, 350);

        Stage thirdStage = new Stage();
        thirdStage.setTitle("Help");
        thirdStage.setScene(thirdScene);

        thirdStage.show();
    }

    private void displayHelp() {
        helpLabel.setText("For best results please use full and complete sentences\n" +
                "The more you put into this, the more you will get out\n" +
                "Result will most likely take a minute to be calculated\n" +
                "Use American English (honor vs honour, gray vs grey, etc");
    }


    private void openResultWindow() {
        displayResult();
        grid.add(resultLabel, 0, 2);

        StackPane secondaryLayout = new StackPane();
        secondaryLayout.getChildren().add(resultsGrid);
        resultsGrid.add(resultLabel, 0, 1);


        Scene secondScene = new Scene(secondaryLayout, 300, 175);

        Stage secondStage = new Stage();
        secondStage.setTitle("Your results");
        secondStage.setScene(secondScene);

        secondStage.show();
    }

    private void displayResult() {
        resultLabel.setText("Your race: " + raceResult + "\nYour class: " + classResult);
    }


}

