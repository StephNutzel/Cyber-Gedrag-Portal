package client.controller;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import server.util.Communication;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

import static java.lang.Integer.parseInt;

public class NewTestController {

    @FXML private TextField testNameBox;
    @FXML private TextField testAmountBox;
    @FXML private TextField departmentNameBox;
    @FXML private TextField questionOneBox;
    @FXML private TextField questionTwoBox;
    @FXML private TextField questionThreeBox;
    @FXML private TextField questionFourBox;
    @FXML private TextField questionFiveBox;
    @FXML private Label newTestWeb;
    @FXML private TextField companyBox;

    public void handleNewTestButton() {
        String testName = testNameBox.getText();
        int testAmount = parseInt(testAmountBox.getText());
        String departmentName = departmentNameBox.getText();
        String questionOne = questionOneBox.getText();
        String questionTwo = questionTwoBox.getText();
        String questionThree = questionThreeBox.getText();
        String questionFour = questionFourBox.getText();
        String questionFive = questionFiveBox.getText();
        String company = companyBox.getText();

        int companyId = ThreadLocalRandom.current().nextInt(1, Integer.MAX_VALUE);
        int departmentId = ThreadLocalRandom.current().nextInt(1, Integer.MAX_VALUE);
        int testcaseId = ThreadLocalRandom.current().nextInt(1, Integer.MAX_VALUE);
        int questionId = ThreadLocalRandom.current().nextInt(1, Integer.MAX_VALUE - 5);

        LocalDate date = LocalDate.now();
        LocalTime time = LocalTime.now();
        String dateTime = date + " " + time;

        Alert confirmation = new Alert(Alert.AlertType.CONFIRMATION, "You're about to create a new test named " + testName + ". \nDo you want to continue?", ButtonType.YES, ButtonType.NO);
        Alert error = new Alert(Alert.AlertType.ERROR, "Something went wrong...", ButtonType.OK);

        confirmation.showAndWait();

        if(confirmation.getResult() == ButtonType.YES) {
           try {
               Communication.newCompany(company, companyId);
               Communication.newDepartment(departmentName, departmentId, companyId);
               Communication.newTestCase(testcaseId, dateTime, departmentId, testName, true, testAmount);
               Communication.postPersonalisationQuestion(questionOne, testcaseId, questionId + 1);
               Communication.postPersonalisationQuestion(questionTwo, testcaseId, questionId + 2);
               Communication.postPersonalisationQuestion(questionThree, testcaseId, questionId + 3);
               Communication.postPersonalisationQuestion(questionFour, testcaseId, questionId + 4);
               Communication.postPersonalisationQuestion(questionFive, testcaseId, questionId + 5);

            } catch (Exception e) {
                e.printStackTrace();
                error.showAndWait();
                return;
            }

            //Generate random id and create new url
            int testCaseId = ThreadLocalRandom.current().nextInt(1, Integer.MAX_VALUE);
            newTestWeb.setText("http://40.113.140.15/register.html?id=" + testCaseId);
        }
    }

    public void handleCopyButton() {
        String url = newTestWeb.getText();
        StringSelection stringSelection = new StringSelection(url);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, null);
    }
}
