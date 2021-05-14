package controller;

import javafx.beans.Observable;
import javafx.beans.binding.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;

public class CircleChartController {

    @FXML public AnchorPane root;
    @FXML public StackPane chartPane;
    @FXML public PieChart pieChart;
    @FXML public Circle circle;
    @FXML public Label titleLabel;
    @FXML public Label percentageLabel;
    @FXML public Label fractionLabel;
    @FXML public Label gradeLabel;

    private ObservableList<PieChart.Data> dataList;

    public CircleChartController() {
    }

    @FXML
    public void initialize() {
        pieChart.setPadding(new Insets(0, 0, 0, 0));
        pieChart.setLabelsVisible(false);
        pieChart.setLegendVisible(false);

        double thickness = 15;
        NumberBinding binding = new When(chartPane.widthProperty().lessThanOrEqualTo(chartPane.heightProperty()))
            .then(chartPane.widthProperty().divide(2).add(-thickness - 10D))
            .otherwise(chartPane.heightProperty().divide(2).add(-thickness - 10D));
        circle.radiusProperty().bind(binding);
        circle.setStrokeWidth(0);

        setBindings();

    }

    private void setBindings() {
        NumberBinding numberBinding = new When(chartPane.widthProperty().lessThanOrEqualTo(chartPane.heightProperty()))
                .then(chartPane.heightProperty().divide(2))
                .otherwise(chartPane.widthProperty().divide(2));
        StringExpression stringGradeBinding = Bindings.when(chartPane.widthProperty().lessThanOrEqualTo(chartPane.heightProperty()))
                .then(Bindings.concat("-fx-font-size: ", chartPane.widthProperty().multiply(chartPane.widthProperty()).divide(700).asString(), ";"))
                .otherwise(Bindings.concat("-fx-font-size: ", chartPane.heightProperty().multiply(chartPane.widthProperty()).divide(700).asString(), ";"));
        gradeLabel.styleProperty().bind(stringGradeBinding);
        StringExpression stringPercentBinding = Bindings.when(chartPane.widthProperty().lessThanOrEqualTo(chartPane.heightProperty()))
                .then(Bindings.concat("-fx-font-size: ", chartPane.widthProperty().multiply(chartPane.widthProperty()).divide(1300).asString(), ";"))
                .otherwise(Bindings.concat("-fx-font-size: ", chartPane.heightProperty().multiply(chartPane.widthProperty()).divide(1300).asString(), ";"));
        percentageLabel.styleProperty().bind(stringPercentBinding);
        StringExpression stringFractionBinding = Bindings.when(chartPane.widthProperty().lessThanOrEqualTo(chartPane.heightProperty()))
                .then(Bindings.concat("-fx-font-size: ", chartPane.widthProperty().multiply(chartPane.widthProperty()).divide(2200).asString(), ";", "\n-fx-text-fill: #B4B4B4;"))
                .otherwise(Bindings.concat("-fx-font-size: ", chartPane.heightProperty().multiply(chartPane.widthProperty()).divide(2200).asString(), ";", "\n-fx-text-fill: #B4B4B4;"));
        fractionLabel.styleProperty().bind(stringFractionBinding);
        System.out.println(fractionLabel.styleProperty().getValue());
    }

    public void setData(ObservableList<PieChart.Data> dataList) {
        this.dataList = dataList;
        pieChart.setData(dataList);
    }

    public ObservableList<PieChart.Data> getDataList() {
        return dataList;
    }

    public void setTitleLabel(String title) {
        this.titleLabel.setText(title);
    }

    public void setPercentageLabel(float percentage) {
        if(percentage >= 0) this.percentageLabel.setText(String.format("%.1f%%", percentage));
        else this.percentageLabel.setText("N/A");
    }

    public void setFractionLabel(int amount, int total) {
        this.fractionLabel.setText(String.format("%d/%d", amount, total));
    }

    public void setGradeLabel(float grade) {
        this.gradeLabel.setText(String.format("%.1f", grade));
    }

}
