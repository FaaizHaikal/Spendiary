package com.example.spendiary.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.ui.graphics.Color
import com.example.spendiary.ui.theme.RedAccent2
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.input.pointer.pointerInput

@Composable
fun BarChart(
    data: List<Pair<String, Float>>,
    modifier: Modifier = Modifier,
    chartHeight: Float = 200f,
    barSpacing: Float = 10f,
    barColor: Color = RedAccent2
) {
    var hoveredIndex by remember { mutableStateOf<Int?>(null) }

    Box(modifier = Modifier.fillMaxWidth()) {
        Canvas (
            modifier = Modifier
                .height(chartHeight.dp)
                .fillMaxWidth()
                .pointerInput(Unit) {
                    detectTapGestures { offset ->
                        val barSpace = (size.width / data.size)
                        val index = (offset.x / barSpace).toInt()
                        if (index in data.indices) {
                            hoveredIndex = index
                        }
                    }
                }
        ) {
            val maxY = data.maxOf { it.second } // Highest y value in data
            val totalSpacing = barSpacing * (data.size - 1)
            val barWidth = (size.width - totalSpacing) / data.size // Width for each bar

            data.forEachIndexed {index, (x, y) ->
                val barHeight = y / maxY * size.height// Height for each bar
                val topLeftX = index * (barWidth + barSpacing)

                drawRect(
                    color = barColor,
                    topLeft = Offset(topLeftX, size.height - barHeight),
                    size = Size(barWidth, barHeight)
                )

                // TODO: Show floating value of x when hovered
            }
        }
    }
}