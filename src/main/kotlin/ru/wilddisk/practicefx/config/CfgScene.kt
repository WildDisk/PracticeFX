package ru.wilddisk.practicefx.config

import javafx.scene.Parent
import javafx.scene.Scene

class CfgScene(
    private val config: Config<Parent>,
    private val x: Double,
    private val y: Double,
    private val styleSheet: String = ""
) : Config<Scene> {
    constructor(root: CfgFXML, x: Double, y: Double, styleSheet: String = "") : this(
        config = root, x = x, y = y, styleSheet = styleSheet)
    override fun build(): Scene = Scene(this.config.build(), this.x, this.y)
        .apply {
            if (this@CfgScene.styleSheet.isNotEmpty()) stylesheets.add(styleSheet)
        }
}