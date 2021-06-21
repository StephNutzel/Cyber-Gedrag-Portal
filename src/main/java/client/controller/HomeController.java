package client.controller;

import javafx.fxml.FXML;
import javafx.scene.layout.VBox;
import server.MainServer;
import server.model.TestCase;

public class HomeController {
    @FXML private VBox list2;


    public HomeController(){
    }

    @FXML
    public void initialize(){
        for (TestCase testCase : MainServer.tester.getTestCaseCatalog().findAll()){
            double tested = testCase.getTestUserCatalog().findAll().size();
            float securityScore  = testCase.avgGradeTotal;
            double test_goal = testCase.getParticipantGoal();
            double percentageOfGoal = tested/test_goal*100;
            TestListController.populateInfo(testCase, tested, securityScore, percentageOfGoal, list2);
        }
    }
}
