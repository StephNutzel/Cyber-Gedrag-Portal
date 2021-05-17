package client.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.StackPane;
import client.module.CircleChartGrade;
import server.model.PasswordTest;

import java.io.IOException;

public class TestPasswordController {

    @FXML private StackPane passwordStrength;
    @FXML private StackPane passwordRating;
    @FXML private StackPane passwordStatistics;

    private CircleChartController passwordChartController;
    private PasswordRatingController passwordRatingController;
    private PasswordRatingController passwordStatisticsController;

    @FXML
    private void initialize() {
        initStrength();
        initRating();
        initStatistics();
    }

    private void initStrength() {
        CircleChartGrade passwordChart = new CircleChartGrade(passwordStrength, "Password Strength", 6.3F, 50);
        passwordChartController = passwordChart.getController();
    }

    private void initRating() {
        FXMLLoader ratingLoader = new FXMLLoader(getClass().getClassLoader().getResource("view/module/password_rating.fxml"));
        Parent ratingParent;
        try {
            ratingParent = ratingLoader.load();
            passwordRating.getChildren().setAll(ratingParent);
            passwordRatingController = ratingLoader.getController();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void initStatistics() {

    }

}
