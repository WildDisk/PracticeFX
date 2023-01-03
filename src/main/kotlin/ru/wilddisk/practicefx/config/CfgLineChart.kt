package ru.wilddisk.practicefx.config

import javafx.scene.Parent
import javafx.scene.chart.CategoryAxis
import javafx.scene.chart.LineChart
import javafx.scene.chart.NumberAxis

class CfgLineChart(
    private val title: String,
    private val label: String,
    private val charts: List<CfgSerias>
) : Config<Parent> {
    override fun build(): LineChart<String, Number> {
        val lineChart = LineChart(CategoryAxis(), NumberAxis().apply { label = this@CfgLineChart.label })
        lineChart.title = this.title
        charts.forEach {
            lineChart.data.add(it.build())
        }
        return lineChart
    }
}