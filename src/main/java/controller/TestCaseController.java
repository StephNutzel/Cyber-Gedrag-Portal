package controller;

import javafx.beans.InvalidationListener;
import javafx.beans.binding.ListBinding;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.css.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.chart.PieChart;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import jnr.ffi.annotations.In;
import module.CircleChartGrade;
import module.CircleChartPercentage;
import org.apache.batik.css.engine.value.Value;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import javax.xml.crypto.Data;
import java.io.IOException;
import java.util.*;

public class TestCaseController {

    private MainController mainController;
    private Parent circleChartRoot;

    @FXML private VBox testCaseSidebar;
    @FXML private StackPane accountChartSlot;
    @FXML private StackPane averageChartSlot;

    private static int CIRLCE_CHART_SLOT;

    public TestCaseController() {

    }

    @FXML
    public void initialize() {
        CircleChartPercentage accountChart = new CircleChartPercentage(accountChartSlot, "Registered", 445, 254);
        CircleChartGrade averageChart = new CircleChartGrade(averageChartSlot, "Average Grade", 5.34F, 1);
    }

    public void setReferenceToMainController(MainController mainController) {
        this.mainController = mainController;
    }

    public void initializeGeneralChar() {
    }

    static {
        CIRLCE_CHART_SLOT = 0;
    }
}
