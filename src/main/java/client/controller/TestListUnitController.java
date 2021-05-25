package client.controller;

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


    public TestListUnitController(){

    }

    @FXML
    public void initialize(){

        test_list_case.setText("test case 12");
        test_list_participants.setText("356");
        test_list_percentage.setText("63,4%");
        test_list_score.setText("6.2");



    }

}

