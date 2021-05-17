package client.module;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;
import javafx.scene.layout.Pane;

public class CircleChartPercentage extends CircleChart {

    private float total, amount;

    public CircleChartPercentage(Pane parent, String title) {
        super(parent, title);
        this.parent = parent;
        this.title = title;
        this.total = 0;
        this.amount = 0;
        initialize();
    }

    public CircleChartPercentage(Pane parent, String title, float total, float amount) {
        super(parent, title);
        this.parent = parent;
        this.title = title;
        this.total = total;
        this.amount = amount;
        initialize();
    }

    public void addTotal() {
        total += 1;
        refreshChart();
    }

    public void subtractTotal() {
        total -= 1;
        if(total < 0) {
            total = 0;
        }
        refreshChart();
    }

    public void add() {
        amount += 1;
        refreshChart();
    }

    public void subtract() {
        amount -= 1;
        if(amount < 0) {
            amount = 0;
        }
        refreshChart();
    }

    public void set(float amount) {
        if(amount < 0) {
            amount = 0;
        }
        this.amount = amount;
        refreshChart();
    }

    public void setTotal(float total) {
        if(total < 0) {
            total = 0;
        }
        this.total = total;
        refreshChart();
    }

    private void refreshChart() {
        dataList.get(0).setPieValue(amount);
        if(amount > total) {
            dataList.get(1).setPieValue(0);
        } else {
            dataList.get(1).setPieValue(total-amount);
        }
        circleChartController.setFractionLabel((int)amount, (int)total);
        if(total != 0) circleChartController.setPercentageLabel(amount/total*100);
        else circleChartController.setPercentageLabel(-1);
    }

    private void initialize() {
        dataList =
                FXCollections.observableArrayList(
                        new PieChart.Data("True", 0),
                        new PieChart.Data("False", 0)
                );
        circleChartController.gradeLabel.setMaxHeight(0);
        setDataList(dataList);
        refreshChart();
    }
}
