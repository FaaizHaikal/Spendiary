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
import com.example.spendiary.ui.theme.RedAccent
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
    barWidth: Float = 20f,
    barColor: Color = RedAccent
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
            val spacing = size.width / data.size // Bar spacing

            data.forEachIndexed {index, (x, y) ->
                val barHeight = y / maxY * chartHeight
                val offsetX = index * spacing + (spacing - barWidth) / 2

                drawRect(
                    color = barColor,
                    topLeft = Offset(offsetX, size.height - barHeight),
                    size = Size(barWidth, barHeight)
                )

                // TODO: Show floating value of x when hovered
            }
        }
    }
}