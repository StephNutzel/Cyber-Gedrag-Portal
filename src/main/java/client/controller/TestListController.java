package client.controller;

import client.module.TestListUnit;
import com.kenai.jffi.Main;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.NumberBinding;
import javafx.beans.property.ReadOnlyDoubleProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import org.junit.Test;
import org.junit.validator.TestClassValidator;
import server.MainServer;
import server.model.TestCase;

public class TestListController {
    @FXML private VBox listFilter;
    @FXML private VBox list;
    @FXML private ScrollPane scrollPane;
    @FXML private ChoiceBox activeTestBox;
    @FXML public Label test_list_case;
    @FXML private Label test_list_participants;
    @FXML private Label test_list_percentage;
    @FXML private Label test_list_score;





    public TestListController(){

    }

    @FXML
    public void initialize(){
        ObservableList<String> activeTestBoxList = FXCollections.observableArrayList("All","Active","Inactive");
        for (TestCase testCase : MainServer.tester.getTestCaseCatalog().findAll()){
            int tested = testCase.getTestUserCatalog().findAll().size();
            TestListUnit testListUnit = new TestListUnit(list, testCase);
            TestListUnitController testListUnitController = testListUnit.getController();
            testListUnitController.setTested(tested);
            testListUnitController.populate();
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
