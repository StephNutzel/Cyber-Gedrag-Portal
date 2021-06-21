package client.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import client.module.CircleChartGrade;
import client.module.CircleChartPercentage;
import org.junit.Test;
import server.MainServer;
import server.model.TestCase;
import server.model.TestUser;

import java.io.IOException;

public class TestCaseController {

    private Parent circleChartRoot;

    @FXML private VBox testCaseSidebar;
    @FXML private StackPane accountChartSlot;
    @FXML private StackPane averageChartSlot;
    @FXML private ScrollPane testCaseMain;

    private TestCase testCase;
    private float securityscore;

    public TestCaseController() {
        testCase = MainServer.tester.getActiveTestCase();
    }

    @FXML
    public void initialize() {
        CircleChartPercentage accountChart = new CircleChartPercentage(accountChartSlot, "Registered", MainServer.tester.getActiveTestCase().getParticipantGoal(), MainServer.tester.getActiveTestCase().getTestUserCatalog().findAll().size());
        System.out.println(MainServer.tester.getActiveTestCase());
        CircleChartGrade averageChart = new CircleChartGrade(averageChartSlot, "Average Grade", MainServer.tester.getActiveTestCase().avgGradeTotal, 1);

        FXMLLoader passwordLoader = new FXMLLoader(getClass().getClassLoader().getResource("view/test_password.fxml"));
        Parent passwordParent;
        try {
            passwordParent = passwordLoader.load();
            testCaseMain.setContent(passwordParent);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public TestCase getTestCase() {
        return testCase;
    }

    public void setTestCase(TestCase testCase) {
        this.testCase = testCase;
    }


}
