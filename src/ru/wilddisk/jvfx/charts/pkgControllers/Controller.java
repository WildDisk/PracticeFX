package ru.wilddisk.jvfx.charts.pkgControllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.stage.Modality;
import javafx.stage.Stage;
import ru.wilddisk.jvfx.charts.pkgRef.Reference;

import java.io.PrintWriter;
import java.io.StringWriter;

public class Controller {
    public Button btnClose;
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
                if (NamePoint.field1 == null) {
                    showNamePoint(actionEvent);
                } else {
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
                    if (AncPaneCh1.disableProperty().getValue().equals(false) && AncPaneCh2.disableProperty().getValue()
                            .equals(true) && AncPaneCh3.disableProperty().getValue().equals(true)) {
                        XYChart.Series series = new XYChart.Series();
                        series.setName(seriesCh1.getText());
                        //populating the series with data
                        series.getData().add(new XYChart.Data(NamePoint.field1, Integer.parseInt(inCh1Point1.getText())));
                        series.getData().add(new XYChart.Data(NamePoint.field2, Integer.parseInt(inCh1Point2.getText())));
                        series.getData().add(new XYChart.Data(NamePoint.field3, Integer.parseInt(inCh1Point3.getText())));
                        series.getData().add(new XYChart.Data(NamePoint.field4, Integer.parseInt(inCh1Point4.getText())));
                        series.getData().add(new XYChart.Data(NamePoint.field5, Integer.parseInt(inCh1Point5.getText())));
                        series.getData().add(new XYChart.Data(NamePoint.field6, Integer.parseInt(inCh1Point6.getText())));
                        series.getData().add(new XYChart.Data(NamePoint.field7, Integer.parseInt(inCh1Point7.getText())));
                        series.getData().add(new XYChart.Data(NamePoint.field8, Integer.parseInt(inCh1Point8.getText())));
                        series.getData().add(new XYChart.Data(NamePoint.field9, Integer.parseInt(inCh1Point9.getText())));
                        series.getData().add(new XYChart.Data(NamePoint.field10, Integer.parseInt(inCh1Point10.getText())));
                        series.getData().add(new XYChart.Data(NamePoint.field11, Integer.parseInt(inCh1Point11.getText())));
                        series.getData().add(new XYChart.Data(NamePoint.field12, Integer.parseInt(inCh1Point12.getText())));

                        Scene scene = new Scene(lineChart, 800, 600);
                        scene.getStylesheets().add(Reference.CSS_chartStyle);
                        lineChart.getData().add(series);

                        stage.getIcons().add(new Image(Reference.ICO_mainIcon));
                        stage.setScene(scene);
                        stage.show();
                    } else if (AncPaneCh1.disableProperty().getValue().equals(false) && AncPaneCh2.disableProperty().getValue()
                            .equals(false) && AncPaneCh3.disableProperty().getValue().equals(true)) {
                        XYChart.Series series1 = new XYChart.Series();
                        series1.setName(series1Ch2.getText());

                        series1.getData().add(new XYChart.Data(NamePoint.field1, Integer.parseInt(inCh1Point1.getText())));
                        series1.getData().add(new XYChart.Data(NamePoint.field2, Integer.parseInt(inCh1Point2.getText())));
                        series1.getData().add(new XYChart.Data(NamePoint.field3, Integer.parseInt(inCh1Point3.getText())));
                        series1.getData().add(new XYChart.Data(NamePoint.field4, Integer.parseInt(inCh1Point4.getText())));
                        series1.getData().add(new XYChart.Data(NamePoint.field5, Integer.parseInt(inCh1Point5.getText())));
                        series1.getData().add(new XYChart.Data(NamePoint.field6, Integer.parseInt(inCh1Point6.getText())));
                        series1.getData().add(new XYChart.Data(NamePoint.field7, Integer.parseInt(inCh1Point7.getText())));
                        series1.getData().add(new XYChart.Data(NamePoint.field8, Integer.parseInt(inCh1Point8.getText())));
                        series1.getData().add(new XYChart.Data(NamePoint.field9, Integer.parseInt(inCh1Point9.getText())));
                        series1.getData().add(new XYChart.Data(NamePoint.field10, Integer.parseInt(inCh1Point10.getText())));
                        series1.getData().add(new XYChart.Data(NamePoint.field11, Integer.parseInt(inCh1Point11.getText())));
                        series1.getData().add(new XYChart.Data(NamePoint.field12, Integer.parseInt(inCh1Point12.getText())));

                        XYChart.Series series2 = new XYChart.Series();
                        series2.setName(series2Ch2.getText());
                        series2.getData().add(new XYChart.Data(NamePoint.field1, Integer.parseInt(inCh2Point1.getText())));
                        series2.getData().add(new XYChart.Data(NamePoint.field2, Integer.parseInt(inCh2Point2.getText())));
                        series2.getData().add(new XYChart.Data(NamePoint.field3, Integer.parseInt(inCh2Point3.getText())));
                        series2.getData().add(new XYChart.Data(NamePoint.field4, Integer.parseInt(inCh2Point4.getText())));
                        series2.getData().add(new XYChart.Data(NamePoint.field5, Integer.parseInt(inCh2Point5.getText())));
                        series2.getData().add(new XYChart.Data(NamePoint.field6, Integer.parseInt(inCh2Point6.getText())));
                        series2.getData().add(new XYChart.Data(NamePoint.field7, Integer.parseInt(inCh2Point7.getText())));
                        series2.getData().add(new XYChart.Data(NamePoint.field8, Integer.parseInt(inCh2Point8.getText())));
                        series2.getData().add(new XYChart.Data(NamePoint.field9, Integer.parseInt(inCh2Point9.getText())));
                        series2.getData().add(new XYChart.Data(NamePoint.field10, Integer.parseInt(inCh2Point10.getText())));
                        series2.getData().add(new XYChart.Data(NamePoint.field11, Integer.parseInt(inCh2Point11.getText())));
                        series2.getData().add(new XYChart.Data(NamePoint.field12, Integer.parseInt(inCh2Point12.getText())));

                        Scene scene = new Scene(lineChart, 800, 600);
                        scene.getStylesheets().add(Reference.CSS_chartStyle);
                        lineChart.getData().addAll(series1, series2);

                        stage.getIcons().add(new Image(Reference.ICO_mainIcon));
                        stage.setScene(scene);
                        stage.show();
                    } else if (AncPaneCh1.disableProperty().getValue().equals(false) && AncPaneCh2.disableProperty().getValue()
                            .equals(false) && AncPaneCh3.disableProperty().getValue().equals(false)) {
                        XYChart.Series series1 = new XYChart.Series();
                        series1.setName(series1Ch3.getText());

                        series1.getData().add(new XYChart.Data(NamePoint.field1, Integer.parseInt(inCh1Point1.getText())));
                        series1.getData().add(new XYChart.Data(NamePoint.field2, Integer.parseInt(inCh1Point2.getText())));
                        series1.getData().add(new XYChart.Data(NamePoint.field3, Integer.parseInt(inCh1Point3.getText())));
                        series1.getData().add(new XYChart.Data(NamePoint.field4, Integer.parseInt(inCh1Point4.getText())));
                        series1.getData().add(new XYChart.Data(NamePoint.field5, Integer.parseInt(inCh1Point5.getText())));
                        series1.getData().add(new XYChart.Data(NamePoint.field6, Integer.parseInt(inCh1Point6.getText())));
                        series1.getData().add(new XYChart.Data(NamePoint.field7, Integer.parseInt(inCh1Point7.getText())));
                        series1.getData().add(new XYChart.Data(NamePoint.field8, Integer.parseInt(inCh1Point8.getText())));
                        series1.getData().add(new XYChart.Data(NamePoint.field9, Integer.parseInt(inCh1Point9.getText())));
                        series1.getData().add(new XYChart.Data(NamePoint.field10, Integer.parseInt(inCh1Point10.getText())));
                        series1.getData().add(new XYChart.Data(NamePoint.field11, Integer.parseInt(inCh1Point11.getText())));
                        series1.getData().add(new XYChart.Data(NamePoint.field12, Integer.parseInt(inCh1Point12.getText())));

                        XYChart.Series series2 = new XYChart.Series();
                        series2.setName(series2Ch3.getText());
                        series2.getData().add(new XYChart.Data(NamePoint.field1, Integer.parseInt(inCh2Point1.getText())));
                        series2.getData().add(new XYChart.Data(NamePoint.field2, Integer.parseInt(inCh2Point2.getText())));
                        series2.getData().add(new XYChart.Data(NamePoint.field3, Integer.parseInt(inCh2Point3.getText())));
                        series2.getData().add(new XYChart.Data(NamePoint.field4, Integer.parseInt(inCh2Point4.getText())));
                        series2.getData().add(new XYChart.Data(NamePoint.field5, Integer.parseInt(inCh2Point5.getText())));
                        series2.getData().add(new XYChart.Data(NamePoint.field6, Integer.parseInt(inCh2Point6.getText())));
                        series2.getData().add(new XYChart.Data(NamePoint.field7, Integer.parseInt(inCh2Point7.getText())));
                        series2.getData().add(new XYChart.Data(NamePoint.field8, Integer.parseInt(inCh2Point8.getText())));
                        series2.getData().add(new XYChart.Data(NamePoint.field9, Integer.parseInt(inCh2Point9.getText())));
                        series2.getData().add(new XYChart.Data(NamePoint.field10, Integer.parseInt(inCh2Point10.getText())));
                        series2.getData().add(new XYChart.Data(NamePoint.field11, Integer.parseInt(inCh2Point11.getText())));
                        series2.getData().add(new XYChart.Data(NamePoint.field12, Integer.parseInt(inCh2Point12.getText())));

                        XYChart.Series series3 = new XYChart.Series();
                        series3.setName(series3Ch3.getText());
                        series3.getData().add(new XYChart.Data(NamePoint.field1, Integer.parseInt(inCh3Point1.getText())));
                        series3.getData().add(new XYChart.Data(NamePoint.field2, Integer.parseInt(inCh3Point2.getText())));
                        series3.getData().add(new XYChart.Data(NamePoint.field3, Integer.parseInt(inCh3Point3.getText())));
                        series3.getData().add(new XYChart.Data(NamePoint.field4, Integer.parseInt(inCh3Point4.getText())));
                        series3.getData().add(new XYChart.Data(NamePoint.field5, Integer.parseInt(inCh3Point5.getText())));
                        series3.getData().add(new XYChart.Data(NamePoint.field6, Integer.parseInt(inCh3Point6.getText())));
                        series3.getData().add(new XYChart.Data(NamePoint.field7, Integer.parseInt(inCh3Point7.getText())));
                        series3.getData().add(new XYChart.Data(NamePoint.field8, Integer.parseInt(inCh3Point8.getText())));
                        series3.getData().add(new XYChart.Data(NamePoint.field9, Integer.parseInt(inCh3Point9.getText())));
                        series3.getData().add(new XYChart.Data(NamePoint.field10, Integer.parseInt(inCh3Point10.getText())));
                        series3.getData().add(new XYChart.Data(NamePoint.field11, Integer.parseInt(inCh3Point11.getText())));
                        series3.getData().add(new XYChart.Data(NamePoint.field12, Integer.parseInt(inCh3Point12.getText())));

                        Scene scene = new Scene(lineChart, 800, 600);
                        scene.getStylesheets().add(Reference.CSS_chartStyle);
                        lineChart.getData().addAll(series1, series2, series3);

                        stage.getIcons().add(new Image(Reference.ICO_mainIcon));
                        stage.setScene(scene);
                        stage.show();
                    }
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
            AncPaneCh1.disableProperty().setValue(false);
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
            AncPaneCh1.disableProperty().setValue(false);
            AncPaneCh1.visibleProperty().setValue(true);
            AncPaneCh2.disableProperty().setValue(false);
            AncPaneCh2.visibleProperty().setValue(true);
            AncPaneCh3.disableProperty().setValue(false);
            AncPaneCh3.visibleProperty().setValue(true);
        }
    }

    public void showNamePoint(ActionEvent actionEvent) throws Exception {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource(Reference.GUI_namePoint));
        stage.setScene(new Scene(root, 251, 430));
        stage.setResizable(false);
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(((Node)actionEvent.getSource()).getScene().getWindow());
        stage.getIcons().add(new Image(Reference.ICO_mainIcon));
        stage.show();
    }

    public void switchText(ActionEvent actionEvent) throws Exception {
        System.out.println(NamePoint.field1);
        if (NamePoint.field1 == null) {
            showNamePoint(actionEvent);
        } else {
            System.out.println(NamePoint.field1 + NamePoint.field2 + NamePoint.field2 + NamePoint.field2 + NamePoint.field2);
        }
    }
}