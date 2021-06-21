package client.controller;

import client.module.TestListUnit;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import server.MainServer;
import server.model.TestCase;
import server.model.TestCaseCatalog;

import java.util.Iterator;

public class TestListController {
    @FXML private VBox list;
    @FXML private ChoiceBox<String> activeTestBox;
    @FXML private TextField participantsMaxValue;
    @FXML private TextField participantsMinValue;
    @FXML private TextField securityScoreMaximumBox;
    @FXML private TextField securityScoreMinimumBox;
    @FXML private TextField testNameBox;
    @FXML private TextField companyNameBox;

    int underValue = Integer.MAX_VALUE;
    int overValue = 0;
    float maxValueFloat = Float.MAX_VALUE;
    float minValueFloat = 0;

    public TestListController(){ }

    /**
     * initializes the page for the user
     */
    @FXML
    public void initialize(){
        ObservableList<String> activeTestBoxList = FXCollections.observableArrayList("All","Active","Inactive");
        updateList(MainServer.tester.getTestCaseCatalog());
        activeTestBox.setValue("All");
        activeTestBox.setItems(activeTestBoxList);
        initializeTextfield(participantsMinValue);
        initializeTextfield(participantsMaxValue);
        initializeTextfielddouble(securityScoreMaximumBox);
        initializeTextfielddouble(securityScoreMinimumBox);
    }

    /**
     * check if testcase num of participants is between minvalue and maxvalue
     * @param testCaseCatalog:string
     * @param maxValue:int
     * @param minvalue:int
     * @return testCatalog
     */
        public TestCaseCatalog filterAmountPart(TestCaseCatalog testCaseCatalog, int maxValue, int minvalue){
        TestCaseCatalog filteredCatalog = new TestCaseCatalog();
        Iterator<TestCase> iterator = testCaseCatalog.findAll().listIterator();
        if (iterator.hasNext()) {
            do {
                TestCase tempTestCase = iterator.next();
                int size = tempTestCase.getTestUserCatalog().findAll().size();
                if (size <= maxValue && size >= minvalue) {
                    filteredCatalog.add(tempTestCase);
                }
            } while (iterator.hasNext());
        }
        return filteredCatalog;

    }

    /**
     * check if there is a valid maxvalue entered
     * @param baseValue:int
     * @return int
     */
    public int maxValue(int baseValue){
        return valueCheckerInt(baseValue, participantsMaxValue);
    }

    private int valueCheckerInt(int baseValue, TextField ParticipantValue) {
        String participantString = ParticipantValue.getText();
        int ParticipantValueInt;
        if (participantString.isBlank()) {
            return baseValue;
        }
        ParticipantValueInt = Integer.parseInt(participantString);
        if (ParticipantValueInt < 0) {
                return baseValue;
            }
        return ParticipantValueInt;
    }

    /**
     * check if there is a valid minvalue entered
     * @param baseValue:int
     * @return int
     */
    public int minValue(int baseValue){
        return valueCheckerInt(baseValue, participantsMinValue);
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
        Iterator<TestCase> iterator = testCaseCatalog.findAll().listIterator();
        if(iterator.hasNext()) {
            do {
                TestCase tempTestCase = iterator.next();
                float grade = tempTestCase.avgGradeTotal;
                if (Float.isNaN(grade)){
                    grade = 0.0F;
                }
                if (grade <= minValue && grade >= maxValue) {
                    filteredCatalog.add(tempTestCase);
                }

            } while (iterator.hasNext());
        }
        return filteredCatalog;

    }

    /**
     * check if there is a valid maxvalue entered
     * @param baseValue:double
     * @return double
     */
    public float maxValueSecurity(float baseValue){
        return SecurityValue(baseValue, securityScoreMaximumBox);
    }

    private float SecurityValue(float baseValue, TextField securityBox) {
        String ValueSecurityString = securityBox.getText();
        float SecurityValueFloat;
        if (ValueSecurityString.isBlank()) {
            return baseValue;
        }
        SecurityValueFloat = Float.parseFloat(ValueSecurityString);
        if (SecurityValueFloat < 0) {
            return baseValue;
        }
        return SecurityValueFloat;
    }

    /**
     * check if there is a valid minvalue entered
     * @param baseValue:double
     * @return double
     */
    public float minValueSecurity(float baseValue){
        return SecurityValue(baseValue, securityScoreMinimumBox);
    }

    /**
     * Checks if the state of the test equals the state named in the filter boxes
     * @param testCaseCatalog:String
     * @param testState:String
     * @return testCaseCatalog
     */
    public TestCaseCatalog testStateFilter(TestCaseCatalog testCaseCatalog, String testState){
        boolean testStateCheck;
        if (testState.equals("All")) {
        return testCaseCatalog;
        }
        else testStateCheck = testState.equals("Active");
        TestCaseCatalog filteredCatalog = new TestCaseCatalog();
        Iterator<TestCase> iterator = testCaseCatalog.findAll().listIterator();
        do {
            TestCase tempTestCase = iterator.next();
            boolean testcaseboolean = tempTestCase.isTestState();
            if (testStateCheck == testcaseboolean){
                filteredCatalog.add(tempTestCase);
            }
        }
        while (iterator.hasNext());
        return filteredCatalog;
    }

    /**
     * Checks if the name of the test equals the name written in the filter boxes
     * @param testCaseCatalog:String
     * @return testCaseCatalog
     */
    public TestCaseCatalog testNameFilter(TestCaseCatalog testCaseCatalog){
        String testName = testNameBox.getText();
        TestCaseCatalog filteredCatalog = new TestCaseCatalog();
        Iterator<TestCase> iterator = testCaseCatalog.findAll().listIterator();
        do {
            TestCase tempTestCase = iterator.next();
            if (testName.equals("")){
                return testCaseCatalog;
            }
            else if (testName.equals(tempTestCase.getName())){
                filteredCatalog.add(tempTestCase);
            }
        }
        while (iterator.hasNext());
        return filteredCatalog;
    }

    /**
     * Checks if the name of the company equals the name written in the filter boxes
     * @param testCaseCatalog:string
     * @return testCaseCatalog
     */
    public TestCaseCatalog companyNameFilter(TestCaseCatalog testCaseCatalog){
        String companyName = companyNameBox.getText();
        TestCaseCatalog filteredCatalog = new TestCaseCatalog();
        Iterator<TestCase> iterator = testCaseCatalog.findAll().listIterator();
        do {
            TestCase tempTestCase = (TestCase) iterator.next();
            if (companyName.equals("")){
                return testCaseCatalog;
            }
            else if (companyName.equals(tempTestCase.getCompanyName())){
                filteredCatalog.add(tempTestCase);
            }
        }while (iterator.hasNext());
        return filteredCatalog;
    }

    /**
     * when the filter button is pressed this methods makes the testcasecatalog go through all of the filters
     */
    public void handleFilter() {
        TestCaseCatalog filteredCatalog = MainServer.tester.getTestCaseCatalog();
        String testState = activeTestBox.getValue();
        filteredCatalog = testNameFilter(filteredCatalog);
        filteredCatalog =companyNameFilter(filteredCatalog);
        filteredCatalog = testStateFilter(filteredCatalog, testState);
        filteredCatalog = filterAmountPart(filteredCatalog, maxValue(underValue), minValue(overValue));
        filteredCatalog = filterSecurityScore(filteredCatalog,maxValueSecurity(maxValueFloat),minValueSecurity(minValueFloat));
        updateList(filteredCatalog);
    }

    /**
     * this function makes sure there can only be entered doubles in the textfield
     * @param textField:double
     */
    public void initializeTextfielddouble(TextField textField) {
        textField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*\\.\\d*")) {
                textField.setText(newValue.replaceAll("[^\\d]", ""));
            }
        });
    }

    /**
     * this function makes sure there can only be entered integers in the textfield
     * @param textField:int
     */
    public void initializeTextfield(TextField textField) {
        textField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*")) {
                textField.setText(newValue.replaceAll("[^\\d]", ""));
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
            double tested = testCase.getTestUserCatalog().findAll().size();
            float securityScore  = testCase.avgGradeTotal;
            double test_goal = testCase.getParticipantGoal();
            double percentageOfGoal = tested/test_goal*100;
            populateInfo(testCase, tested, securityScore, percentageOfGoal, list);

        }

    }

    /**
     * sets the information to insert into the test list units
     * @param testCase:TestCase
     * @param tested:double
     * @param securityScore:float
     * @param percentageOfGoal:double
     * @param list:Vbox
     */
    static void populateInfo(TestCase testCase, double tested, float securityScore, double percentageOfGoal, VBox list) {
        TestListUnit testListUnit = new TestListUnit(list, testCase);
        TestListUnitController testListUnitController = testListUnit.getController();
        testListUnitController.setTested(tested);
        testListUnitController.setSecurityScore(securityScore);
        testListUnitController.setTestName(testCase.getName());
        testListUnitController.setPercentage(percentageOfGoal);
        testListUnitController.populate();
    }


}
