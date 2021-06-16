package client.controller;

import client.module.TestListUnit;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import org.w3c.dom.Text;
import server.MainServer;
import server.model.TestCase;
import server.model.TestCaseCatalog;

import java.util.Iterator;
import java.util.function.UnaryOperator;

public class TestListController {
    @FXML private VBox listFilter;
    @FXML private VBox list;
    @FXML private ScrollPane scrollPane;
    @FXML private ChoiceBox activeTestBox;
    @FXML public Label test_list_case;
    @FXML private Label test_list_participants;
    @FXML private Label test_list_percentage;
    @FXML private Label test_list_score;
    @FXML private TextField participantsMinValue;
    @FXML private TextField participantsMaxValue;
    @FXML private TextField securityScoreMaximumBox;
    @FXML private TextField securityScoreMinimumBox;
    @FXML private Button filterButton;

    int underValue = Integer.MAX_VALUE;
    int overValue = 0;
    float maxValueFloat = Float.MAX_VALUE;
    float minValueFloat = 0;





    public TestListController(){

    }

    /**
     * initializes the page for the user
     */
    @FXML
    public void initialize(){
        ObservableList<String> activeTestBoxList = FXCollections.observableArrayList("All","Active","Inactive");
        updateList(MainServer.tester.getTestCaseCatalog());


        activeTestBox.setValue("All");
        activeTestBox.setItems(activeTestBoxList);
        initializeTextfield(participantsMaxValue);
        initializeTextfield(participantsMinValue);
        initializeTextfielddouble(securityScoreMaximumBox);
        initializeTextfielddouble(securityScoreMinimumBox);
    }

    /**
     * check if testcase num of participants is between minvalue and maxvalue
     * @param testCaseCatalog:string
     * @param minValue:int
     * @param maxValue:int
     * @return testCatalog
     */
        public TestCaseCatalog filterAmountPart(TestCaseCatalog testCaseCatalog, int minValue, int maxValue){
        TestCaseCatalog filteredCatalog = new TestCaseCatalog();
        Iterator iterator = testCaseCatalog.findAll().listIterator();
        do {
            TestCase tempTestCase = (TestCase) iterator.next();
            int size = tempTestCase.getTestUserCatalog().findAll().size();
            if (size >= minValue && size <= maxValue){
                filteredCatalog.add(tempTestCase);
            }
        }while (iterator.hasNext());
        return filteredCatalog;

    }

    /**
     * check if there is a valid maxvalue entered
     * @param baseValue:int
     * @return int
     */
    public int maxValue(int baseValue){
        String maxValueString = participantsMaxValue.getText();
        int maxValueInt = 0;
        if (maxValueString.isBlank()) {
            return baseValue;
        }
        maxValueInt = Integer.parseInt(maxValueString);
        if (maxValueInt < 0) {
                return baseValue;
            }
            return maxValueInt;
    }

    /**
     * check if there is a valid minvalue entered
     * @param baseValue:int
     * @return int
     */
    public int minValue(int baseValue){
        String minValueString = participantsMinValue.getText();
        int minValueInt = -1;
        if (minValueString.isBlank()) {
            return baseValue;
        }
            minValueInt = Integer.parseInt(minValueString);
            if ( minValueInt < 0) {
                return baseValue;
            }
            return minValueInt;
    }

    /**
     * check if testcase avg security score is between minvalue and maxvalue
     * @param testCaseCatalog:string
     * @param minValue:double
     * @param maxValue:double
     * @return testCaseCatalog
     */
    public TestCaseCatalog filterSecurityScore(TestCaseCatalog testCaseCatalog, float minValue, float maxValue){
        TestCaseCatalog filteredCatalog = new TestCaseCatalog();
        Iterator iterator = testCaseCatalog.findAll().listIterator();
        do {
            TestCase tempTestCase = (TestCase) iterator.next();
            float size = tempTestCase.getTestUserCatalog().getAvgGrade();
            if (size <= minValue && size >= maxValue){
                filteredCatalog.add(tempTestCase);
            }
        }while (iterator.hasNext());
        return filteredCatalog;

    }

    /**
     * check if there is a valid maxvalue entered
     * @param baseValue:double
     * @return double
     */
    public float maxValueSecurity(float baseValue){
        String maxValueSecurityString = securityScoreMaximumBox.getText();
        float maxValueFloat;
        if (maxValueSecurityString.isBlank()) {
            return baseValue;
        }
        maxValueFloat = Float.parseFloat(maxValueSecurityString);
        if (maxValueFloat < 0) {
            return baseValue;
        }
        return maxValueFloat;
    }

    /**
     * check if there is a valid minvalue entered
     * @param baseValue:double
     * @return double
     */
    public float minValueSecurity(float baseValue){
        String minValueSecurityString = securityScoreMinimumBox.getText();
        float minValueFloat = -1;
        if (minValueSecurityString.isBlank()) {
            return baseValue;
        }
        minValueFloat = Float.parseFloat(minValueSecurityString);
        if ( minValueFloat < 0) {
            return baseValue;
        }
        return minValueFloat;
    }


    /**
     * when the filter button is pressed this methods makes the testcasecatalog go through all of the filters
     */
    public void handleFilter() {
        TestCaseCatalog filteredCatalog = MainServer.tester.getTestCaseCatalog();
        filteredCatalog = filterAmountPart(filteredCatalog, maxValue(underValue), minValue(overValue));
        filteredCatalog = filterSecurityScore(filteredCatalog,maxValueSecurity(maxValueFloat),minValueSecurity(minValueFloat));
        updateList(filteredCatalog);


    }

    /**
     * this function makes sure there can only be entered doubles in the textfield
     * @param textField:double
     */
    public void initializeTextfielddouble(TextField textField) {
        textField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                                String newValue) {
                if (!newValue.matches("\\d*\\.\\d*")) {
                    textField.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });
    }

    /**
     * this function makes sure there can only be entered integers in the textfield
     * @param textField:int
     */
    public void initializeTextfield(TextField textField) {
        textField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                                String newValue) {
                if (!newValue.matches("\\d*")) {
                    textField.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });
    }

    /**
     * after the testCaseCatalog has been through all of the filters this method will update the list for the user
     * @param testCaseCatalog:String
     */
    public void updateList(TestCaseCatalog testCaseCatalog){
        list.getChildren().clear();
        for (TestCase testCase : testCaseCatalog.findAll()){
            int tested = testCase.getTestUserCatalog().findAll().size();
            TestListUnit testListUnit = new TestListUnit(list, testCase);
            TestListUnitController testListUnitController = testListUnit.getController();
            testListUnitController.setTested(tested);
            testListUnitController.populate();
        }

    }


}
