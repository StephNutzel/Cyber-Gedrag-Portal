package client.controller;

import javafx.beans.binding.*;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;

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
        NumberBinding binding = new When(pieChart.widthProperty().lessThanOrEqualTo(pieChart.heightProperty()))
            .then(pieChart.widthProperty().divide(2).add(-thickness - 10D))
            .otherwise(pieChart.heightProperty().divide(2).add(-thickness - 10D));
        circle.radiusProperty().bind(binding);
        circle.setStrokeWidth(0);

        setBindings();

    }

    private void setBindings() {
        NumberBinding numberBinding = new When(pieChart.widthProperty().lessThanOrEqualTo(pieChart.heightProperty()))
                .then(pieChart.heightProperty().divide(2))
                .otherwise(pieChart.widthProperty().divide(2));
        StringExpression stringGradeBinding = Bindings.when(pieChart.widthProperty().lessThanOrEqualTo(300).or(pieChart.heightProperty().lessThanOrEqualTo(300)))
                .then(
                        Bindings.when(pieChart.widthProperty().lessThanOrEqualTo(pieChart.heightProperty()))
                        .then(Bindings.concat("-fx-font-size: ", pieChart.widthProperty().multiply(pieChart.widthProperty()).divide(500).asString(), ";"))
                        .otherwise(Bindings.concat("-fx-font-size: ", pieChart.heightProperty().multiply(pieChart.heightProperty()).divide(500).asString(), ";")))
                .otherwise(Bindings.concat("-fx-font-size: ", "180"));
        gradeLabel.styleProperty().bind(stringGradeBinding);
        StringExpression stringPercentBinding = Bindings.when(pieChart.widthProperty().lessThanOrEqualTo(200).or(pieChart.heightProperty().lessThanOrEqualTo(200)))
                .then(
                        Bindings.when(pieChart.widthProperty().lessThanOrEqualTo(pieChart.heightProperty()))
                        .then(Bindings.concat("-fx-font-size: ", pieChart.widthProperty().multiply(pieChart.widthProperty()).divide(800).asString(), ";"))
                        .otherwise(Bindings.concat("-fx-font-size: ", pieChart.heightProperty().multiply(pieChart.heightProperty()).divide(800).asString(), ";")))
                .otherwise(Bindings.concat("-fx-font-size: ", "50"));
        percentageLabel.styleProperty().bind(stringPercentBinding);
        StringExpression stringFractionBinding = Bindings.when(pieChart.widthProperty().lessThanOrEqualTo(200).or(pieChart.heightProperty().lessThanOrEqualTo(200)))
                .then(
                        Bindings.when(pieChart.widthProperty().lessThanOrEqualTo(pieChart.heightProperty()))
                        .then(Bindings.concat("-fx-font-size: ", pieChart.widthProperty().multiply(pieChart.widthProperty()).divide(1500).asString(), ";", "\n-fx-text-fill: #B4B4B4;"))
                        .otherwise(Bindings.concat("-fx-font-size: ", pieChart.heightProperty().multiply(pieChart.heightProperty()).divide(1500).asString(), ";", "\n-fx-text-fill: #B4B4B4;")))
                .otherwise(Bindings.concat("-fx-font-size: ", "26"));
        fractionLabel.styleProperty().bind(stringFractionBinding);
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
