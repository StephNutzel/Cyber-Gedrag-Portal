package client.controller;

import client.module.TestListUnit;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.NumberBinding;
import javafx.beans.property.ReadOnlyDoubleProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import server.MainServer;
import server.model.TestCase;

public class TestListController {
    @FXML private VBox listFilter;
    @FXML private VBox list;
    @FXML private ScrollPane scrollPane;
    @FXML private ChoiceBox activeTestBox;





    public TestListController(){

    }

    @FXML
    public void initialize(){
        ObservableList<String> activeTestBoxList = FXCollections.observableArrayList("All","Active","Inactive");
        for(TestCase testCase : MainServer.tester.getTestCaseCatalog().findAll()){
            TestListUnit testcase = new TestListUnit(list, testCase );
        }



        activeTestBox.setValue("All");
        activeTestBox.setItems(activeTestBoxList);



        bindScrollpaneWidth();
    }

    public void bindScrollpaneWidth(){
        ReadOnlyDoubleProperty numberBinding =  scrollPane.widthProperty();
        list.styleProperty().bind(Bindings.concat("-fx-pref-width: ", numberBinding.add(-10)));
    }

}
