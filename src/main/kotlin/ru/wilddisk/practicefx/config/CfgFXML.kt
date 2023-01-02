package ru.wilddisk.practicefx.config

import javafx.fxml.FXMLLoader
import javafx.scene.Parent
import java.net.URL

class CfgFXML(
    private val resource: URL?
) : Config<Parent> {
    override fun build(): Parent = FXMLLoader(resource).load()
}