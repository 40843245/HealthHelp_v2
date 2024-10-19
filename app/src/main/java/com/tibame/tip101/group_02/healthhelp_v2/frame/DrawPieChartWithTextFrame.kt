package com.tibame.tip101.group_02.healthhelp_v2.frame

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.tibame.tip101.group_02.healthhelp_v2.util.graph.piechart.PieChartEntry
import com.tibame.tip101.group_02.healthhelp_v2.util.graph.piechart.PieChartWithText
import java.math.BigDecimal

@Composable
fun DrawPieChartWithTextFrame(){
    val pieChartEntries = listOf<PieChartEntry>(
        PieChartEntry(Color.Yellow, BigDecimal(20).divide(BigDecimal(100))),
        PieChartEntry(Color.Red,BigDecimal(30).divide(BigDecimal(100))),
        PieChartEntry(Color.Blue,BigDecimal(50).divide(BigDecimal(100))),
    )

    val texts = listOf(
        "Yellow",
        "Red",
        "Blue",
    )

    val canvasSize = 200u
    val fontSize = 50u

    PieChartWithText(
        texts = texts,
        entries = pieChartEntries,
        canvasSize = canvasSize,
        fontSize = fontSize,
    )
}