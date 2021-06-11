package client.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

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

    public void handleNewTestButton() {
        String testName = testNameBox.getText();
        int testAmount = parseInt(testAmountBox.getText());
        String departmentName = departmentNameBox.getText();
        String questionOne = questionOneBox.getText();
        String questionTwo = questionTwoBox.getText();
        String questionThree = questionThreeBox.getText();
        String questionFour = questionFourBox.getText();
        String questionFive = questionFiveBox.getText();

        System.out.println(testName);
        System.out.println(testAmount);
        System.out.println(departmentName);
        System.out.println(questionOne);
        System.out.println(questionTwo);
        System.out.println(questionThree);
        System.out.println(questionFour);
        System.out.println(questionFive);

        int testCaseId = 1;
        newTestWeb.setText("http://40.113.140.15/register.html?id=" + testCaseId);
    }

    public void handleCopyButton() {
        String url = newTestWeb.getText();
        StringSelection stringSelection = new StringSelection(url);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, null);
    }
}
