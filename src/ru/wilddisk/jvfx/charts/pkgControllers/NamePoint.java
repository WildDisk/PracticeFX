package ru.wilddisk.jvfx.charts.pkgControllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class NamePoint {
    @FXML
    public TextField namePoint1, namePoint2, namePoint3, namePoint4, namePoint5, namePoint6, namePoint7, namePoint8,
                            namePoint9, namePoint10, namePoint11, namePoint12;

    public static String field1, field2, field3, field4, field5, field6, field7, field8, field9, field10, field11, field12;

    public void applyNamePoint(ActionEvent actionEvent) {
        field1 = namePoint1.getText();
        field2 = namePoint2.getText();
        field3 = namePoint3.getText();
        field4 = namePoint4.getText();
        field5 = namePoint5.getText();
        field6 = namePoint6.getText();
        field7 = namePoint7.getText();
        field8 = namePoint8.getText();
        field9 = namePoint9.getText();
        field10 = namePoint10.getText();
        field11 = namePoint11.getText();
        field12 = namePoint12.getText();
        ((Stage)(((Button)actionEvent.getSource()).getScene().getWindow())).close();
    }

    public void closeDialog(ActionEvent actionEvent) {
        ((Stage)(((Button)actionEvent.getSource()).getScene().getWindow())).close();
    }
}
