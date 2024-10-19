package com.tibame.tip101.group_02.healthhelp_v2.util.graph.piechart

import androidx.compose.ui.graphics.Color
import java.math.BigDecimal

data class PieChartEntry(
    val color: Color,
    val percentage: BigDecimal,
)