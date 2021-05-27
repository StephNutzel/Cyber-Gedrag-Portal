package client.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.StackPane;
import client.module.CircleChartGrade;
import server.MainServer;
import server.model.TestCase;
import server.model.TestUser;

import java.io.IOException;

public class TestPasswordController {

    @FXML private StackPane passwordStrength;
    @FXML private StackPane passwordRating;
    @FXML private StackPane passwordStatistics;

    private CircleChartController passwordChartController;
    private PasswordRatingController passwordRatingController;
    private PasswordRatingController passwordStatisticsController;

    private float avgGrade;
    private int amount;

    @FXML
    private void initialize() {
        initStrength();
        initRating();
        initStatistics();
    }

    private void initStrength() {
        System.out.println(MainServer.tester.getActiveTestCase());
        System.out.println(MainServer.tester.getActiveTestCase().getTestUserCatalog().findAll().size());

        for(TestUser user : MainServer.tester.getActiveTestCase().getTestUserCatalog().findAll()) {
            if (user.getPasswordTest() != null && user.getPasswordTest().getGrade() > 0) {
                float grade = user.getPasswordTest().getGrade();
                avgGrade = ((avgGrade * amount) + grade)/++amount;
                System.out.println(avgGrade);
            }
        }
        CircleChartGrade passwordChart = new CircleChartGrade(passwordStrength, "Password Strength", avgGrade, amount);
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
