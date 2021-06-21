package client.controller;

import client.MainClient;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import server.MainServer;
import server.model.TestCase;

public class TestListUnitController {
    @FXML private Label test_list_case;
    @FXML private Label test_list_participants;
    @FXML private Label test_list_percentage;
    @FXML private Label test_list_score;

    private int tested;
    private float securityscore;
    private String testname;
    private double percentage;

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }

    private TestCase testCase;

    public TestListUnitController(){

    }

    public void setTestCase(TestCase testCase){
        this.testCase = testCase;

    }



    public void setTested(double tested){
        this.tested = (int) tested;
    }

    public void setSecurityScore(float securityScore) {this.securityscore = securityScore;}

    public void setTestName(String testName){this.testname=testName;}





    /**
     * fills the testlistUnits
     */
    public void populate() {
        test_list_case.setText(testname);
        test_list_participants.setText(String.valueOf(tested));
        test_list_percentage.setText(percentage+"%");
        test_list_score.setText(String.format("%3.1f", securityscore));
    }

    @FXML
    public void initialize(){


    }



    /**
     * when the testlistunit is clicked this will redirect the user to the page of that test case
     */
    public void handleTestCaseClicked(){
        MainServer.tester.setActiveTestCase(testCase);
        MainClient.baseController.handleTestCaseButtonAction();
    }


}

