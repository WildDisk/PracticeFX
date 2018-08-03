package ru.wilddisk.jvfx.charts;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("pkgGUI/mainScene.fxml"));
        primaryStage.setTitle("ChartsOn");

        primaryStage.setScene(new Scene(root, 880, 450));
        primaryStage.getIcons().add(new Image("/ru/wilddisk/jvfx/charts/ico/mainIco.jpg"));
        primaryStage.setMinWidth(880);
        primaryStage.setMinHeight(450);
        primaryStage.initStyle(StageStyle.UNIFIED);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
