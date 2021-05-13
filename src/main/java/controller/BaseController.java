package controller;

import com.intellij.ui.ListActions;
import com.thaiopensource.xml.dtd.om.Include;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class BaseController {

    private static final int HOME;
    private static final int TEST_LIST;
    private static final int TEST_CASE;
    private static final int NEW_TEST;
    private int currentPage;

    private MainController mainController;

    private Parent homeParent;
    private Parent testListParent;
    private Parent testCaseParent;
    private Parent newTestParent;

//    @FXML HomeController homeController;
//    @FXML private VBox basepane;
    public HBox basepane;

    public BaseController() {
        initialize();
    }

    private void initialize() {
        try {
            FXMLLoader homeLoader = new FXMLLoader(getClass().getClassLoader().getResource("view/home.fxml"));
            homeParent = homeLoader.load();
            FXMLLoader testListLoader = new FXMLLoader(getClass().getClassLoader().getResource("view/test_list.fxml"));
            testListParent = testListLoader.load();
            FXMLLoader testCaseLoader = new FXMLLoader(getClass().getClassLoader().getResource("view/test_case.fxml"));
            testCaseParent = testCaseLoader.load();
            FXMLLoader newTestLoader = new FXMLLoader(getClass().getClassLoader().getResource("view/new_test.fxml"));
            newTestParent = newTestLoader.load();

            HBox.setHgrow(homeParent, Priority.ALWAYS);
            HBox.setHgrow(testListParent, Priority.ALWAYS);
            HBox.setHgrow(testCaseParent, Priority.ALWAYS);
            HBox.setHgrow(newTestParent, Priority.ALWAYS);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//            <fx:include fx:id="home" maxHeight="1.7976931348623157E308" maxWidth="1.7976931348623157E308" source="home.fxml" HBox.hgrow="ALWAYS" />

    public void setupPage() {
        System.out.println(basepane);
        System.out.println(homeParent);
        basepane.getChildren().add(homeParent);
        currentPage = HOME;
    }

    public void handleHomeButtonAction() {
        if(currentPage == HOME) {
            return;
        }
        basepane.getChildren().remove(1);
        basepane.getChildren().add(homeParent);
        currentPage = HOME;
    }

    public void handleTestListButtonAction() {
        if(currentPage == TEST_LIST) {
            return;
        }
        basepane.getChildren().remove(1);
        basepane.getChildren().add(testListParent);
        currentPage = TEST_LIST;
    }

    public void handleTestCaseButtonAction() {
        if(currentPage == TEST_CASE) {
            return;
        }
        basepane.getChildren().remove(1);
        basepane.getChildren().add(testCaseParent);
        currentPage = TEST_CASE;
    }

    public void handleNewTestButtonAction() {
        if(currentPage == NEW_TEST) {
            return;
        }
        basepane.getChildren().remove(1);
        basepane.getChildren().add(newTestParent);
        currentPage = NEW_TEST;
    }

    public void setReferenceToMainController(MainController mainController) {
        this.mainController = mainController;
    }

    static {
        HOME = 1;
        TEST_LIST = 2;
        TEST_CASE = 3;
        NEW_TEST = 4;
    }
}
