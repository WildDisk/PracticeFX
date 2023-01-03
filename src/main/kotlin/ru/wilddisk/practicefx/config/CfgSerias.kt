package ru.wilddisk.practicefx.config

import javafx.scene.chart.XYChart
import ru.wilddisk.practicefx.model.Point

class CfgSerias(
    private val seriesName: String,
    private val dataList: List<Point>
) : Config<XYChart.Series<String, Number>> {
    override fun build(): XYChart.Series<String, Number> {
        val series: XYChart.Series<String, Number> = XYChart.Series()
        series.name = seriesName
        dataList.forEach {
            series.data.add(XYChart.Data(it.point, it.value))
        }
        return series
    }
}