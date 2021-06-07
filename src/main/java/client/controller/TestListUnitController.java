package client.controller;

import client.MainClient;
import client.module.TestListUnit;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import server.MainServer;
import server.model.TestCase;

import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.List;

public class TestListUnitController {
    @FXML private Label test_list_case;
    @FXML private Label test_list_participants;
    @FXML private Label test_list_percentage;
    @FXML private Label test_list_score;

    private int tested;
    private float securityscore;
    private TestCase testCase;

    public TestListUnitController(){

    }

    public void setTested(int tested){
        this.tested = tested;
    }

    public void setSecurityScore(float securityScore) {this.securityscore = securityScore;}

    public void populate() {
        test_list_case.setText("testcase");
        test_list_participants.setText(String.valueOf(tested));
        test_list_percentage.setText("10%");
        test_list_score.setText(String.valueOf(securityscore));
    }

    @FXML
    public void initialize(){


    }

    public void setTestCase(TestCase testCase){
        this.testCase = testCase;
    }

    public void handleTestCaseClicked(){
        MainServer.tester.setActiveTestCase(testCase);
        MainClient.baseController.handleTestCaseButtonAction();
    }


}

