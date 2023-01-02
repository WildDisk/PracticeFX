package ru.wilddisk.practicefx.config

import javafx.scene.Scene
import javafx.scene.image.Image
import javafx.stage.Stage

class CfgStage(
    private val config: Config<Scene>,
    private val title: String,
    private val icon: Image = Image("/")
) : Config<Stage> {
    constructor(scene: CfgScene, title: String, icon: Image) : this(
        config = scene, title = title, icon = icon)
    override fun build(): Stage = Stage()
        .apply {
            scene = this@CfgStage.config.build()
            title = this@CfgStage.title
            if (!icon.isError) icons.add(icon)
        }
}