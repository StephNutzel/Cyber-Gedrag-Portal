package client.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;

import java.io.IOException;

public class BaseController {

    private static final int HOME;
    private static final int TEST_LIST;
    private static final int TEST_CASE;
    private static final int NEW_TEST;
    private int currentPage;

    private Parent homeRoot;
    private Parent testListRoot;
    private Parent testCaseRoot;
    private Parent newTestRoot;

//    @FXML HomeController homeController;
//    @FXML private VBox basepane;
    public HBox basepane;

    public BaseController() {

    }

    @FXML
    private void initialize() {
        try {
            FXMLLoader homeLoader = new FXMLLoader(getClass().getClassLoader().getResource("view/home.fxml"));
            homeRoot = homeLoader.load();
            FXMLLoader testListLoader = new FXMLLoader(getClass().getClassLoader().getResource("view/test_list.fxml"));
            testListRoot = testListLoader.load();
            FXMLLoader testCaseLoader = new FXMLLoader(getClass().getClassLoader().getResource("view/test_case.fxml"));
            testCaseRoot = testCaseLoader.load();
            FXMLLoader newTestLoader = new FXMLLoader(getClass().getClassLoader().getResource("view/new_test.fxml"));
            newTestRoot = newTestLoader.load();

            HBox.setHgrow(homeRoot, Priority.ALWAYS);
            HBox.setHgrow(testListRoot, Priority.ALWAYS);
            HBox.setHgrow(testCaseRoot, Priority.ALWAYS);
            HBox.setHgrow(newTestRoot, Priority.ALWAYS);
        } catch (IOException e) {
            e.printStackTrace();
        }
        setupPage();
    }

    public void setupPage() {
        basepane.getChildren().add(homeRoot);
        currentPage = HOME;
    }

    public void handleHomeButtonAction() {
        if(currentPage == HOME) {
            return;
        }
        basepane.getChildren().remove(1);
        basepane.getChildren().add(homeRoot);
        currentPage = HOME;
    }

    public void handleTestListButtonAction() {
        if(currentPage == TEST_LIST) {
            return;
        }
        basepane.getChildren().remove(1);
        basepane.getChildren().add(testListRoot);
        currentPage = TEST_LIST;
    }

    public void handleTestCaseButtonAction() {
        if(currentPage == TEST_CASE) {
            return;
        }
        basepane.getChildren().remove(1);
        basepane.getChildren().add(testCaseRoot);
        currentPage = TEST_CASE;
    }

    public void handleNewTestButtonAction() {
        if(currentPage == NEW_TEST) {
            return;
        }
        basepane.getChildren().remove(1);
        basepane.getChildren().add(newTestRoot);
        currentPage = NEW_TEST;
    }

    static {
        HOME = 1;
        TEST_LIST = 2;
        TEST_CASE = 3;
        NEW_TEST = 4;
    }
}
