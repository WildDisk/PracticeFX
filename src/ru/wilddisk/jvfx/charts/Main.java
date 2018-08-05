package ru.wilddisk.jvfx.charts;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import ru.wilddisk.jvfx.charts.pkgRef.Reference;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource(Reference.GUI_mainScene));
        primaryStage.setTitle("ChartsOn");

        primaryStage.setScene(new Scene(root, 880, 450));
        primaryStage.getIcons().add(new Image(Reference.ICO_mainIcon));
        primaryStage.setMinWidth(880);
        primaryStage.setMinHeight(450);
        primaryStage.initStyle(StageStyle.UNIFIED);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
