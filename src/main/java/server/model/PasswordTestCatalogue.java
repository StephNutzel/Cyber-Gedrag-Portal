package server.model;

import java.util.HashMap;
import java.util.List;

public class PasswordTestCatalogue extends AbstractCatalogue{

    private HashMap<Long, PasswordTest> passwordMap;

    public PasswordTestCatalogue() {
        super();
        passwordMap = new HashMap<>();
    }

    public HashMap<Long, PasswordTest> getPasswordMap() {
        return passwordMap;
    }

    public PasswordTest getById(long id) {
        return passwordMap.get(id);
    }

    public void add(PasswordTest passwordTest) {
        passwordMap.put(passwordTest.getId(), passwordTest);
        addAvgGrade(passwordTest.getGrade());
    }

    public void addList(List<PasswordTest> passwordTests) {
        for(PasswordTest test : passwordTests) {
            add(test);
            addAvgGrade(test.getGrade());
        }
    }

    public void remove(PasswordTest passwordTest) {
        passwordMap.remove(passwordTest.getId());
        subtractAvgGrade(passwordTest.getGrade());
    }



}
