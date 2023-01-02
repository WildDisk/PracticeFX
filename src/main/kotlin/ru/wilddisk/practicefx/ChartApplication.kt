package ru.wilddisk.practicefx

import javafx.application.Application
import javafx.fxml.FXMLLoader
import javafx.scene.Scene
import javafx.stage.Stage
import ru.wilddisk.practicefx.config.CfgFXML
import ru.wilddisk.practicefx.config.CfgScene
import ru.wilddisk.practicefx.config.CfgStage

class ChartApplication : Application() {
    override fun start(stage: Stage) {
        CfgStage(
            CfgScene(
                root = CfgFXML(ChartApplication::class.java.getResource("chart-view.fxml")),
                x = 800.0,
                y = 600.0
            ),
            title = "Chart"
        ).build().show()
    }
}

fun main() = Application.launch(ChartApplication::class.java)