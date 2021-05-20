package client.controller;

import client.module.TestListUnit;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.NumberBinding;
import javafx.beans.property.ReadOnlyDoubleProperty;
import javafx.fxml.FXML;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;

public class TestListController {
    @FXML private VBox listFilter;
    @FXML private VBox list;
    @FXML private ScrollPane scrollPane;


    public TestListController(){

    }

    @FXML
    public void initialize(){
        TestListUnit testcase1 = new TestListUnit(list, null );
        TestListUnit testcase2 = new TestListUnit(list, null );
        TestListUnit testcase3 = new TestListUnit(list, null );
        TestListUnit testcase4 = new TestListUnit(list, null );
        TestListUnit testcase5 = new TestListUnit(list, null );


        bindScrollpaneWidth();
    }

    public void bindScrollpaneWidth(){
        ReadOnlyDoubleProperty numberBinding =  scrollPane.widthProperty();
        list.styleProperty().bind(Bindings.concat("-fx-pref-width: ", numberBinding.add(-10)));
    }

}
