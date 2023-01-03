package ru.wilddisk.practicefx.config

import javafx.scene.Scene
import javafx.scene.image.Image
import javafx.scene.image.ImageView
import javafx.stage.Stage
import java.io.File

class CfgStage(
    private val config: Config<Scene>,
    private val title: String,
    private val icon: Image = Image("/")
) : Config<Stage> {
    constructor(scene: CfgScene, title: String, icon: ImageView = ImageView("/")) : this(
        config = scene, title = title, icon = icon.image)
    constructor(scene: CfgScene, title: String, icon: File) : this(
        config = scene, title = title, icon = ImageView(icon.absolutePath).image)
    override fun build(): Stage = Stage()
        .apply {
            scene = this@CfgStage.config.build()
            title = this@CfgStage.title
            if (!icon.isError) icons.add(icon)
        }
}