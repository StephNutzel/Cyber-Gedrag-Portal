package client.module;

import client.controller.CircleChartController;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.chart.PieChart;
import javafx.scene.layout.Pane;

import java.io.IOException;

public abstract class CircleChart {

    protected Pane parent;
    public ObservableList<PieChart.Data> dataList;
    protected String title;

    private Parent circleChartRoot;
    private FXMLLoader circleChartLoader;
    public CircleChartController circleChartController;

    public CircleChart(Pane parent, String title) {
        this.parent = parent;
        this.title = title;
        initialize();
    }

    public void setDataList(ObservableList<PieChart.Data> dataList) {
        this.dataList = dataList;
        circleChartController.setData(dataList);
    }

    private void initialize() {
        FXMLLoader circleChartLoader = new FXMLLoader(getClass().getClassLoader().getResource("view/module/circle_chart.fxml"));
        try {
            circleChartRoot = circleChartLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        circleChartController = circleChartLoader.getController();
        parent.getChildren().setAll(circleChartRoot);
        circleChartController.setTitleLabel(title);
    }

    public CircleChartController getController() {
        return circleChartController;
    }
}
