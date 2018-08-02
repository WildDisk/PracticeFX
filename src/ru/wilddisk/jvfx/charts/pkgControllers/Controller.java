package ru.wilddisk.jvfx.charts.pkgControllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;

import java.io.PrintWriter;
import java.io.StringWriter;

public class Controller {
    @FXML
    private TextField seriesCh1, series1Ch2, series2Ch2, series1Ch3, series2Ch3, series3Ch3;
    @FXML
    private Button btnChrt1, btnChrt2, btnChrt3;
    @FXML
    private AnchorPane AncPaneCh1, AncPaneCh2, AncPaneCh3;
    @FXML
    private TextField ChartTitle, ChartLable;
    @FXML
    private TextField inCh1Point1, inCh1Point2, inCh1Point3, inCh1Point4, inCh1Point5, inCh1Point6, inCh1Point7, inCh1Point8,
            inCh1Point9, inCh1Point10, inCh1Point11, inCh1Point12;
    @FXML
    private TextField inCh2Point1, inCh2Point2, inCh2Point3, inCh2Point4, inCh2Point5, inCh2Point6, inCh2Point7, inCh2Point8,
            inCh2Point9, inCh2Point10, inCh2Point11, inCh2Point12;
    @FXML
    private TextField inCh3Point1, inCh3Point2, inCh3Point3, inCh3Point4, inCh3Point5, inCh3Point6, inCh3Point7, inCh3Point8,
            inCh3Point9, inCh3Point10, inCh3Point11, inCh3Point12;

//      Поля для расчёта ResizeWindows
//=======================================
//    @FXML
//    public Button btnResize;
//
//    private double dx, dy;
//=======================================

    public void showChart(ActionEvent actionEvent) {
            try {
                Stage stage = new Stage();
                stage.setTitle("Chart");
                final CategoryAxis xAxis = new CategoryAxis();
                final NumberAxis yAxis = new NumberAxis();
                xAxis.setLabel(ChartLable.getText());
                //creating the chart
                final LineChart<String, Number> lineChart =
                        new LineChart<String, Number>(xAxis, yAxis);

                lineChart.setTitle(ChartTitle.getText());
                //defining a series
                if (AncPaneCh1.disableProperty().getValue().equals(false)) {
                    XYChart.Series series = new XYChart.Series();
                    series.setName(seriesCh1.getText());
                    //populating the series with data
                    series.getData().add(new XYChart.Data("Jan", Integer.parseInt(inCh1Point1.getText())));
                    series.getData().add(new XYChart.Data("Feb", Integer.parseInt(inCh1Point2.getText())));
                    series.getData().add(new XYChart.Data("Mar", Integer.parseInt(inCh1Point3.getText())));
                    series.getData().add(new XYChart.Data("Apr", Integer.parseInt(inCh1Point4.getText())));
                    series.getData().add(new XYChart.Data("May", Integer.parseInt(inCh1Point5.getText())));
                    series.getData().add(new XYChart.Data("Jun", Integer.parseInt(inCh1Point6.getText())));
                    series.getData().add(new XYChart.Data("Jul", Integer.parseInt(inCh1Point7.getText())));
                    series.getData().add(new XYChart.Data("Aug", Integer.parseInt(inCh1Point8.getText())));
                    series.getData().add(new XYChart.Data("Sep", Integer.parseInt(inCh1Point9.getText())));
                    series.getData().add(new XYChart.Data("Oct", Integer.parseInt(inCh1Point10.getText())));
                    series.getData().add(new XYChart.Data("Nov", Integer.parseInt(inCh1Point11.getText())));
                    series.getData().add(new XYChart.Data("Dec", Integer.parseInt(inCh1Point12.getText())));

                    Scene scene = new Scene(lineChart, 800, 600);
                    scene.getStylesheets().add("ru/wilddisk/jvfx/charts/pkgCSS/chartStyle.css");
                    lineChart.getData().add(series);

                    stage.setScene(scene);
                    stage.show();
                } else if (AncPaneCh2.disableProperty().getValue().equals(false)) {
                    XYChart.Series series1 = new XYChart.Series();
                    series1.setName(series1Ch2.getText());

                    series1.getData().add(new XYChart.Data("Jan", 23));
                    series1.getData().add(new XYChart.Data("Feb", 14));
                    series1.getData().add(new XYChart.Data("Mar", 15));
                    series1.getData().add(new XYChart.Data("Apr", 24));
                    series1.getData().add(new XYChart.Data("May", 34));
                    series1.getData().add(new XYChart.Data("Jun", 36));
                    series1.getData().add(new XYChart.Data("Jul", 22));
                    series1.getData().add(new XYChart.Data("Aug", 45));
                    series1.getData().add(new XYChart.Data("Sep", 43));
                    series1.getData().add(new XYChart.Data("Oct", 17));
                    series1.getData().add(new XYChart.Data("Nov", 29));
                    series1.getData().add(new XYChart.Data("Dec", 25));

                    XYChart.Series series2 = new XYChart.Series();
                    series2.setName(series2Ch2.getText());
                    series2.getData().add(new XYChart.Data("Jan", 33));
                    series2.getData().add(new XYChart.Data("Feb", 34));
                    series2.getData().add(new XYChart.Data("Mar", 25));
                    series2.getData().add(new XYChart.Data("Apr", 44));
                    series2.getData().add(new XYChart.Data("May", 39));
                    series2.getData().add(new XYChart.Data("Jun", 16));
                    series2.getData().add(new XYChart.Data("Jul", 55));
                    series2.getData().add(new XYChart.Data("Aug", 54));
                    series2.getData().add(new XYChart.Data("Sep", 48));
                    series2.getData().add(new XYChart.Data("Oct", 27));
                    series2.getData().add(new XYChart.Data("Nov", 37));
                    series2.getData().add(new XYChart.Data("Dec", 29));

                    Scene scene = new Scene(lineChart, 800, 600);
                    scene.getStylesheets().add("ru/wilddisk/jvfx/charts/pkgCSS/chartStyle.css");
                    lineChart.getData().addAll(series1, series2);

                    stage.setScene(scene);
                    stage.show();
                } else if (AncPaneCh3.disableProperty().getValue().equals(false)) {
                    XYChart.Series series1 = new XYChart.Series();
                    series1.setName(series1Ch3.getText());

                    series1.getData().add(new XYChart.Data("Jan", 23));
                    series1.getData().add(new XYChart.Data("Feb", 14));
                    series1.getData().add(new XYChart.Data("Mar", 15));
                    series1.getData().add(new XYChart.Data("Apr", 24));
                    series1.getData().add(new XYChart.Data("May", 34));
                    series1.getData().add(new XYChart.Data("Jun", 36));
                    series1.getData().add(new XYChart.Data("Jul", 22));
                    series1.getData().add(new XYChart.Data("Aug", 45));
                    series1.getData().add(new XYChart.Data("Sep", 43));
                    series1.getData().add(new XYChart.Data("Oct", 17));
                    series1.getData().add(new XYChart.Data("Nov", 29));
                    series1.getData().add(new XYChart.Data("Dec", 25));

                    XYChart.Series series2 = new XYChart.Series();
                    series2.setName(series2Ch3.getText());
                    series2.getData().add(new XYChart.Data("Jan", 33));
                    series2.getData().add(new XYChart.Data("Feb", 34));
                    series2.getData().add(new XYChart.Data("Mar", 25));
                    series2.getData().add(new XYChart.Data("Apr", 44));
                    series2.getData().add(new XYChart.Data("May", 39));
                    series2.getData().add(new XYChart.Data("Jun", 16));
                    series2.getData().add(new XYChart.Data("Jul", 55));
                    series2.getData().add(new XYChart.Data("Aug", 54));
                    series2.getData().add(new XYChart.Data("Sep", 48));
                    series2.getData().add(new XYChart.Data("Oct", 27));
                    series2.getData().add(new XYChart.Data("Nov", 37));
                    series2.getData().add(new XYChart.Data("Dec", 29));

                    XYChart.Series series3 = new XYChart.Series();
                    series3.setName(series3Ch3.getText());
                    series3.getData().add(new XYChart.Data("Jan", 44));
                    series3.getData().add(new XYChart.Data("Feb", 35));
                    series3.getData().add(new XYChart.Data("Mar", 36));
                    series3.getData().add(new XYChart.Data("Apr", 33));
                    series3.getData().add(new XYChart.Data("May", 31));
                    series3.getData().add(new XYChart.Data("Jun", 26));
                    series3.getData().add(new XYChart.Data("Jul", 22));
                    series3.getData().add(new XYChart.Data("Aug", 25));
                    series3.getData().add(new XYChart.Data("Sep", 43));
                    series3.getData().add(new XYChart.Data("Oct", 44));
                    series3.getData().add(new XYChart.Data("Nov", 45));
                    series3.getData().add(new XYChart.Data("Dec", 44));

                    Scene scene = new Scene(lineChart, 800, 600);
                    scene.getStylesheets().add("ru/wilddisk/jvfx/charts/pkgCSS/chartStyle.css");
                    lineChart.getData().addAll(series1, series2, series3);

                    stage.setScene(scene);
                    stage.show();
                }
            } catch (Exception e) {
                e.printStackTrace();
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Alarm!");
                alert.setHeaderText("Ой! Видно что то пошло не так!");
                alert.setContentText("По любому пытался буквы ввести, да?\n" +
                        "Невозможно построить график используя буквы!\n" +
                        "Как ты вообще себе это представляешь?");

                Exception ex = new Exception("StackTrace");

// Create expandable Exception.
                StringWriter sw = new StringWriter();
                PrintWriter pw = new PrintWriter(sw);
                ex.printStackTrace(pw);
                String exceptionText = sw.toString();

                Label label = new Label("The exception stacktrace was:");

                TextArea textArea = new TextArea(exceptionText);
                textArea.setEditable(false);
                textArea.setWrapText(true);

                textArea.setMaxWidth(Double.MAX_VALUE);
                textArea.setMaxHeight(Double.MAX_VALUE);
                GridPane.setVgrow(textArea, Priority.ALWAYS);
                GridPane.setHgrow(textArea, Priority.ALWAYS);

                GridPane expContent = new GridPane();
                expContent.setMaxWidth(Double.MAX_VALUE);
                expContent.add(label, 0, 0);
                expContent.add(textArea, 0, 1);

                // Set expandable Exception into the dialog pane.
                alert.getDialogPane().setExpandableContent(expContent);
                alert.showAndWait();
            }
    }

//=========================================================================================
//              Попытка сделать ResizeWindow
///////////////////////////////////////////////////////////////////////////////////////////
//    @FXML
//    public void closeDialog(ActionEvent actionEvent) {
//        ((Stage)(((Button)actionEvent.getSource()).getScene().getWindow())).close();
//    }
//
//    @FXML
//    public void resizeCornerPress(MouseEvent mouseEvent) {
//        Stage stage;
//        stage = (Stage)btnResize.getScene().getWindow();
//        dx = mouseEvent.getScreenX() - stage.getX();
//        dy = mouseEvent.getScreenY() - stage.getY();
//    }
//
//    @FXML
//    public void resizeCornerDragg(MouseEvent mouseEvent) {
//        Stage stage;
//        stage = (Stage)btnResize.getScene().getWindow();
//        stage.setWidth(mouseEvent.getScreenX() + stage.getX());
//        stage.setHeight(mouseEvent.getScreenY() + stage.getY());
//    }
////////////////////////////////////////////////////////////////////////////////////////////

    public void showMenuOneChart(ActionEvent actionEvent) {
        if (actionEvent.getSource() == btnChrt1) {
            AncPaneCh1.toFront();
            AncPaneCh1.disableProperty().setValue(false);
            AncPaneCh1.visibleProperty().setValue(true);
            AncPaneCh2.disableProperty().setValue(true);
            AncPaneCh2.visibleProperty().setValue(true);
            AncPaneCh3.disableProperty().setValue(true);
            AncPaneCh3.visibleProperty().setValue(true);
        }
    }

    public void showMenuTwoChart(ActionEvent actionEvent) {
        if (actionEvent.getSource() == btnChrt2) {
            AncPaneCh2.toFront();
            AncPaneCh1.disableProperty().setValue(true);
            AncPaneCh1.visibleProperty().setValue(true);
            AncPaneCh2.disableProperty().setValue(false);
            AncPaneCh2.visibleProperty().setValue(true);
            AncPaneCh3.disableProperty().setValue(true);
            AncPaneCh3.visibleProperty().setValue(true);
        }
    }

    public void showMenuThreeChart(ActionEvent actionEvent) {
        if (actionEvent.getSource() == btnChrt3) {
            AncPaneCh3.toFront();
            AncPaneCh1.disableProperty().setValue(true);
            AncPaneCh1.visibleProperty().setValue(true);
            AncPaneCh2.disableProperty().setValue(true);
            AncPaneCh2.visibleProperty().setValue(true);
            AncPaneCh3.disableProperty().setValue(false);
            AncPaneCh3.visibleProperty().setValue(true);
        }
    }
}