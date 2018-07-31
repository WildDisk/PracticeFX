package ru.wilddisk.jvfx.charts.pkgControllers;

import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Controller {
    public TextField ChartTitle, ChartLable;
    public TextField inPoint1, inPoint2, inPoint3, inPoint4, inPoint5, inPoint6, inPoint7, inPoint8,
                            inPoint9, inPoint10, inPoint11, inPoint12;

    public void showChart(ActionEvent actionEvent) {
        try {
            Stage stage = new Stage();
            stage.setTitle("Chart");
            final NumberAxis xAxis = new NumberAxis();
            final NumberAxis yAxis = new NumberAxis();
            xAxis.setLabel(ChartLable.getText());
            //creating the chart
            final LineChart<Number,Number> lineChart =
                    new LineChart<Number,Number>(xAxis,yAxis);

            lineChart.setTitle(ChartTitle.getText());
            //defining a series
            XYChart.Series series = new XYChart.Series();
            series.setName("My portfolio");
            //populating the series with data
            series.getData().add(new XYChart.Data(1, Integer.parseInt(inPoint1.getText())));
            series.getData().add(new XYChart.Data(2, Integer.parseInt(inPoint2.getText())));
            series.getData().add(new XYChart.Data(3, Integer.parseInt(inPoint3.getText())));
            series.getData().add(new XYChart.Data(4, Integer.parseInt(inPoint4.getText())));
            series.getData().add(new XYChart.Data(5, Integer.parseInt(inPoint5.getText())));
            series.getData().add(new XYChart.Data(6, Integer.parseInt(inPoint6.getText())));
            series.getData().add(new XYChart.Data(7, Integer.parseInt(inPoint7.getText())));
            series.getData().add(new XYChart.Data(8, Integer.parseInt(inPoint8.getText())));
            series.getData().add(new XYChart.Data(9, Integer.parseInt(inPoint9.getText())));
            series.getData().add(new XYChart.Data(10, Integer.parseInt(inPoint10.getText())));
            series.getData().add(new XYChart.Data(11, Integer.parseInt(inPoint11.getText())));
            series.getData().add(new XYChart.Data(12, Integer.parseInt(inPoint12.getText())));

            Scene scene  = new Scene(lineChart,800,600);
            scene.getStylesheets().add("ru/wilddisk/jvfx/charts/pkgCSS/chartStyle.css");
            lineChart.getData().add(series);

            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
