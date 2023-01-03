package ru.wilddisk.practicefx.controller

import javafx.beans.property.SimpleObjectProperty
import javafx.fxml.FXML
import javafx.fxml.Initializable
import javafx.scene.control.Label
import javafx.scene.control.TextField
import javafx.scene.control.TreeItem
import javafx.scene.control.TreeTableColumn
import javafx.scene.control.TreeTableView
import ru.wilddisk.practicefx.config.CfgLineChart
import ru.wilddisk.practicefx.config.CfgScene
import ru.wilddisk.practicefx.config.CfgSerias
import ru.wilddisk.practicefx.config.CfgStage
import ru.wilddisk.practicefx.model.Point
import java.net.URL
import java.util.*

class ChartController : Initializable {
    @FXML
    private lateinit var treeTableView: TreeTableView<Point>
    @FXML
    private lateinit var point: TreeTableColumn<Point, String>
    @FXML
    private lateinit var pointValue: TreeTableColumn<Point, Number>
    @FXML
    private lateinit var lbl: Label
    @FXML
    private lateinit var txtPointName: TextField
    @FXML
    private lateinit var txtPointValue: TextField

    private var seriasList: MutableList<CfgSerias> = mutableListOf()
    private var pointList: MutableList<Point> = mutableListOf()

    @FXML
    fun buildChart() {
        seriasList = mutableListOf()
        pointList = mutableListOf()
        treeTableView.root.children.forEach { sra ->
            sra.children.forEach { pnt ->
                pointList.add(Point(pnt.value.point, pnt.value.value))
            }
            seriasList.add(CfgSerias(sra.value.point, pointList))
        }
        CfgStage(
            scene = CfgScene(
                root = CfgLineChart(
                    title = "LineChart",
                    label = "LabelChart",
                    charts = seriasList
                ),
                x = 800.0,
                y = 600.0
            ),
            title = "Chart"
        ).build().show()
    }

    @FXML
    fun onTouch() {
        pointList = mutableListOf()
        lbl.text = treeTableView.selectionModel.selectedItem.value.toString()
        txtPointName.text = treeTableView.selectionModel.selectedItem.value.point
        txtPointValue.text = treeTableView.selectionModel.selectedItem.value.value.toString()
    }

    @FXML
    fun apply() {
        treeTableView.selectionModel.selectedItem.value = Point(
            txtPointName.text,
            txtPointValue.text.toDouble()
        )
    }

    @FXML
    fun addSerias() {
        treeTableView.root.children.add(TreeItem(Point("Serias_n", 0)))
    }

    @FXML
    fun addPoint() {
        if (treeTableView.selectionModel.selectedItem.children.isEmpty()) {
            treeTableView.selectionModel.selectedItem.parent.children.add(TreeItem(Point("Point_n", 0)))
        }
    }

    override fun initialize(p0: URL?, p1: ResourceBundle?) {
        val points = listOf(Point("pointA", 1), Point("pointB", 1), Point("pointC", 2))
        val itemRoot = TreeItem<Point>(Point("Serias_1", points.size))

        val points1 = listOf(Point("pointC", 2), Point("pointD", 2), Point("pointE", 3))
        val itemRoot1 = TreeItem<Point>(Point("Serias_2", points1.size))

        val root = TreeItem<Point>(Point("Chart", 0))

        point.setCellValueFactory { SimpleObjectProperty(it.value.value.point) }
        pointValue.setCellValueFactory { SimpleObjectProperty(it.value.value.value) }

        points.forEach {
            itemRoot.children.add(TreeItem(it))
        }

        points1.forEach {
            itemRoot1.children.add(TreeItem(it))
        }

        root.children.addAll(itemRoot, itemRoot1)

        treeTableView.root = root
    }
}