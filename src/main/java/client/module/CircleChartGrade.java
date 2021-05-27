package client.module;

import javafx.collections.FXCollections;
import javafx.scene.chart.PieChart;
import javafx.scene.layout.Pane;

public class CircleChartGrade extends CircleChart {

    private float grade;
    private int amount;

    private static final String COLOR_5;
    private static final String COLOR_4;
    private static final String COLOR_3;
    private static final String COLOR_2;
    private static final String COLOR_1;

    public CircleChartGrade(Pane parent, String title) {
        super(parent, title);
        this.grade = 0;
        this.amount = 0;
        initialize();
    }

    public CircleChartGrade(Pane parent, String title, float grade, int amount) {
        super(parent, title);
        this.grade = grade;
        this.amount = amount;
        initialize();
    }

    public float getGrade() {
        return grade;
    }

    public void setGrade(float grade, int amount) {
        if(grade > 10) {
            this.grade = 10;
        } else if(grade < 0) {
            this.grade = 0;
        } else {
            this.grade = grade;
        }
        if(amount < 1) {
            this.amount = 1;
        } else {
            this.amount = amount;
        }
        refreshChart();
    }

    public void resetGrade() {
        this.grade = 0;
        this.amount = 0;
        refreshChart();
    }

    public void addGrade(float grade) {
        this.grade = (this.grade * amount + grade)/++amount;
        refreshChart();
    }

    private void setColor() {
        if(grade < 2) dataList.get(0).getNode().setStyle("-fx-pie-color: " + COLOR_1 + ";");
        else if(grade < 4) dataList.get(0).getNode().setStyle("-fx-pie-color: " + COLOR_2 + ";");
        else if(grade < 6) dataList.get(0).getNode().setStyle("-fx-pie-color: " + COLOR_3 + ";");
        else if(grade < 8) dataList.get(0).getNode().setStyle("-fx-pie-color: " + COLOR_4 + ";");
        else dataList.get(0).getNode().setStyle("-fx-pie-color: " + COLOR_5 + ";");
    }

    private void refreshChart() {
        dataList.get(0).setPieValue(grade);
        dataList.get(1).setPieValue(10-grade);
        circleChartController.setGradeLabel(grade);
        setColor();
    }

    public void initialize() {
        dataList =
                FXCollections.observableArrayList(
                        new PieChart.Data("True", 0),
                        new PieChart.Data("False", 0)
                );
        setDataList(dataList);
        circleChartController.percentageLabel.setMaxHeight(0);
        circleChartController.fractionLabel.setMaxHeight(0);
        refreshChart();
    }

    static {
        COLOR_5 = "#00FF00";
        COLOR_4 = "#91FF00";
        COLOR_3 = "#FFFF00";
        COLOR_2 = "#FF9100";
        COLOR_1 = "#FF0000";
    }
}
