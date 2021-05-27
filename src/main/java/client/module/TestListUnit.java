package client.module;

import client.controller.CircleChartController;
import client.controller.TestListUnitController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import server.model.TestCase;

import java.io.IOException;

public class TestListUnit {

    protected VBox parent;
    protected TestCase testCase;

    private Parent TestListUnitRoot;
    private FXMLLoader testListUnitLoader;
    public TestListUnitController testListUnitController;

    @FXML private Label test_list_case;
    @FXML private Label test_list_participants;
    @FXML private Label test_list_percentage;
    @FXML private Label test_list_score;

    public TestListUnit(VBox parent, TestCase testCase) {
    this.parent = parent;
    this.testCase = testCase;
    initialize();
    }

    public void setTested(int tested){

    }

    private void initialize() {
        testListUnitLoader = new FXMLLoader(getClass().getClassLoader().getResource("view/test_list_unit.fxml"));
        try {
            TestListUnitRoot = testListUnitLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        testListUnitController = testListUnitLoader.getController();
        parent.getChildren().add(TestListUnitRoot);

    }

    public TestListUnitController getController() {
        return testListUnitController;
    }

}
