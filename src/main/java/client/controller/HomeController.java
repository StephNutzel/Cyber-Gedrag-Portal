package client.controller;

import client.module.TestListUnit;
import javafx.fxml.FXML;
import javafx.scene.layout.VBox;
import server.MainServer;
import server.model.TestCase;

import java.awt.*;


public class HomeController {
    @FXML private ScrollPane scrollPane2;
    @FXML private VBox list2;


    public HomeController(){


    }


    @FXML
    public void initialize(){
        for (TestCase testCase : MainServer.tester.getTestCaseCatalog().findAll()){
            int tested = testCase.getTestUserCatalog().findAll().size();
            float securityScore  = testCase.getTestUserCatalog().getAvgGrade();
            TestListUnit testListUnit = new TestListUnit(list2, testCase);
            TestListUnitController testListUnitController = testListUnit.getController();
            testListUnitController.setTested(tested);
            testListUnitController.populate();

        }


    }




}
