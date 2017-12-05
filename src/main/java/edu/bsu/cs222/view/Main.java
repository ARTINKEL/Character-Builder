package edu.bsu.cs222.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    Pane pane;
    private Stage primaryStage;

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        mainWindow();
    }

    public void mainWindow(){
        try{
            System.out.println(Main.class.getResource("/DesignerView.fxml"));
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/DesignerView.fxml"));
            pane = loader.load();

            UIController mainWindowController = loader.getController();
            //mainWindowController.setMain(this);

            Scene scene = new Scene(pane);

            primaryStage.setTitle("Character Designer v0.3.0");

            primaryStage.setScene(scene);
            primaryStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        launch(args);
    }
}