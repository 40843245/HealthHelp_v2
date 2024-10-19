package com.tibame.tip101.group_02.healthhelp_v2.util.graph.piechart

import android.graphics.Canvas
import androidx.compose.foundation.gestures.rememberScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.math.BigDecimal


@Composable
fun PieChartWithText(
    texts:List<String>,
    entries: List<PieChartEntry>,
    canvasSize: UInt,
    fontSize:UInt,
){
    val currentFontSize by remember { mutableStateOf(fontSize) }
    Column(
        modifier = Modifier
    ){
        PieChart(
            entries = entries,
            size = canvasSize,
        )
        texts.forEachIndexed { index , text ->
            val entry = entries[index]
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = "${text}:${entry.percentage.multiply(BigDecimal(100))}%.",
                fontSize = currentFontSize.toInt().sp,
                maxLines = 1,
                overflow = TextOverflow.Visible,
            )
        }
    }
}