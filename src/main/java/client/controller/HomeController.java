package client.controller;

import client.module.TestListUnit;
import javafx.fxml.FXML;
import javafx.scene.layout.VBox;

import java.awt.*;


public class HomeController {
    @FXML private ScrollPane scrollPane2;
    @FXML private VBox list2;


    public HomeController(){


    }


    @FXML
    public void initialize(){
        TestListUnit testcaseHome1 = new TestListUnit(list2, null);
        TestListUnit testcaseHome2= new TestListUnit(list2, null);
        TestListUnit testcaseHome3 = new TestListUnit(list2, null);
        TestListUnit testcaseHome4 = new TestListUnit(list2, null);
        TestListUnit testcaseHome5 = new TestListUnit(list2, null);
        TestListUnit testcaseHome6= new TestListUnit(list2, null);
        TestListUnit testcaseHome7 = new TestListUnit(list2, null);
        TestListUnit testcaseHome8 = new TestListUnit(list2, null);



    }




}
