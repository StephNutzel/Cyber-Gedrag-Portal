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

import java.io.IOException;

public class TestCaseController {

    private Parent circleChartRoot;

    @FXML private VBox testCaseSidebar;
    @FXML private StackPane accountChartSlot;
    @FXML private StackPane averageChartSlot;
    @FXML private ScrollPane testCaseMain;

    private TestCase testCase;

    public TestCaseController() {
        testCase = MainServer.user.getTestCases().get(1L);
    }

    @FXML
    public void initialize() {
        CircleChartPercentage accountChart = new CircleChartPercentage(accountChartSlot, "Registered", 445, 254);
        CircleChartGrade averageChart = new CircleChartGrade(averageChartSlot, "Average Grade", 5.34F, 1);

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
