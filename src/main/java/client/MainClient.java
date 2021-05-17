package client;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class MainClient extends Application {

    private static Parent root;
    private static Stage primaryStage;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        startLogin();
    }

    public static void startLogin() {
        try {
            int screen_width = 600;
            int screen_height = 440;
            primaryStage.setTitle("Human Cyber Lab: Portal");
            FXMLLoader loader = new FXMLLoader(MainClient.class.getClassLoader().getResource("view/login.fxml"));
            root = loader.load();
            Scene loginScene = new Scene(root, screen_width, screen_height);
            primaryStage.setX((Screen.getPrimary().getBounds().getWidth() - screen_width)/2);
            primaryStage.setY((Screen.getPrimary().getBounds().getHeight() - screen_height)/2);
            primaryStage.setResizable(false);
            primaryStage.setScene(loginScene);
            primaryStage.initStyle(StageStyle.DECORATED);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void startMain() {
        try {
            int screen_width = 1080;
            int screen_height = 720;
            primaryStage.setTitle("Human Cyber Lab: Portal");
            FXMLLoader loader = new FXMLLoader(MainClient.class.getClassLoader().getResource("view/base.fxml"));
            root = loader.load();
            Scene homeScene = new Scene(root, screen_width, screen_height);
            primaryStage.setX((Screen.getPrimary().getBounds().getWidth() - screen_width)/2);
            primaryStage.setY((Screen.getPrimary().getBounds().getHeight() - screen_height)/2);
            primaryStage.setResizable(true);
            primaryStage.setScene(homeScene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
