package module;

import controller.CircleChartController;
import javafx.collections.FXCollections;
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
    public CircleChartController controller;

    public CircleChart(Pane parent, String title) {
        this.parent = parent;
        this.title = title;
        initialize();
    }

    public void setDataList(ObservableList<PieChart.Data> dataList) {
        this.dataList = dataList;
        controller.setData(dataList);
    }

    private void initialize() {
        FXMLLoader circleChartLoader = new FXMLLoader(getClass().getClassLoader().getResource("view/module/circle_chart.fxml"));
        try {
            circleChartRoot = circleChartLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        controller = circleChartLoader.getController();
        parent.getChildren().setAll(circleChartRoot);
        controller.setTitleLabel(title);
    }
}
