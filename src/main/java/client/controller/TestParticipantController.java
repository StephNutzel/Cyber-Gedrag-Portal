//package client.controller;
//
//import client.module.CircleChartGrade;
//import javafx.fxml.FXML;
//import javafx.fxml.FXMLLoader;
//import javafx.scene.Parent;
//import javafx.scene.layout.StackPane;
//import server.MainServer;
//import server.model.TestUser;
//
//import java.io.IOException;
//
//public class TestParticipantController {
//
//    @FXML
//    private StackPane passwordStrength;
//    @FXML private StackPane passwordRating;
//    @FXML private StackPane passwordStatistics;
//
//    private CircleChartController passwordChartController;
//    private ParticipantController participantController;
////    private ParticipantController passwordStatisticsController;
//
//    private float avgGrade;
//    private int amount;
//
//    @FXML
//    private void initialize() {
//        initStrength();
//        initRating();
//        initStatistics();
//    }
//
//    private void initStrength() {
//        for(TestUser user : MainServer.tester.getActiveTestCase().getTestUserCatalog().findAll()) {
//            if (user.getPasswordTest() != null && user.getPasswordTest().getGrade() > 0) {
//                float grade = user.getPasswordTest().getGrade();
//                avgGrade = ((avgGrade * amount) + grade)/++amount;
//                System.out.println(avgGrade);
//            }
//        }
//        CircleChartGrade passwordChart = new CircleChartGrade(passwordStrength, "Password Strength", avgGrade, amount);
//        passwordChartController = passwordChart.getController();
//    }
//
//    private void initRating() {
//        FXMLLoader ratingLoader = new FXMLLoader(getClass().getClassLoader().getResource("view/module/password_rating.fxml"));
//        Parent ratingParent;
//        try {
//            ratingParent = ratingLoader.load();
//            passwordRating.getChildren().setAll(ratingParent);
//            participantController = ratingLoader.getController();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    private void initStatistics() {
//    }
//
//}
