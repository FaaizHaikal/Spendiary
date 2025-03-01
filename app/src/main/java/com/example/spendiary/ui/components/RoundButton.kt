package com.example.spendiary.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import com.example.spendiary.ui.theme.BlueAccent
import androidx.compose.ui.unit.dp
import com.example.spendiary.ui.theme.White87

@Composable
fun RoundButton(
    icon: ImageVector,
    text: String = "Button",
    color: Color = BlueAccent,
    size: Dp = 56.dp,
    iconSize: Dp = 23.dp,
    onClick: () -> Unit,
    enabled: Boolean = true
) {
    Column (
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Box(
            modifier = Modifier
                .size(size)
                .clip(CircleShape)
                .background(if (enabled) color else Color.Gray)
                .clickable(enabled = enabled) { onClick() },
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = icon,
                contentDescription = text,
                modifier = Modifier.size(iconSize),
                tint = Color.White
            )
        }

        Spacer(Modifier.height(4.dp))

        Text(text = text, style = MaterialTheme.typography.bodySmall, color = White87)
    }

}