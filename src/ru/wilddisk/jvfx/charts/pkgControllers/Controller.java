package ru.wilddisk.jvfx.charts.pkgControllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;

import java.io.PrintWriter;
import java.io.StringWriter;

public class Controller {
    @FXML
    private TextField ChartTitle, ChartLable;
    @FXML
    private TextField inPoint1, inPoint2, inPoint3, inPoint4, inPoint5, inPoint6, inPoint7, inPoint8,
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
    @FXML
    public void closeDialog(ActionEvent actionEvent) {
        ((Stage)(((Button)actionEvent.getSource()).getScene().getWindow())).close();
    }
}
