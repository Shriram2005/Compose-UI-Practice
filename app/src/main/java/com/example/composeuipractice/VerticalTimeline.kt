package com.example.composeuipractice

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun VerticalTimeline(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxHeight()
            .width(60.dp),
        contentAlignment = Alignment.TopCenter
    ) {
        // Dotted vertical line
        Canvas(modifier = Modifier.fillMaxHeight()) {
            val pathWidth = 4.dp.toPx()
            val dotSpacing = 12.dp.toPx()

            var currentY = 0f
            while (currentY < size.height) {
                drawLine(
                    color = Color(0xFF_E0E0E0),
                    start = Offset(size.width / 2, currentY),
                    end = Offset(size.width / 2, currentY + dotSpacing / 2),
                    strokeWidth = pathWidth,
                    cap = StrokeCap.Round
                )
                currentY += dotSpacing
            }
        }

        // Red pin at the top
        Box(
            modifier = Modifier
                .size(24.dp)
                .offset(y = (-12).dp)
        ) {
            Canvas(modifier = Modifier.fillMaxSize()) {
                drawCircle(
                    color = Color.Red,
                    radius = size.width / 2
                )
            }
        }

        // First green marker with lightning
        Box(
            modifier = Modifier
                .fillMaxHeight(0.4f)
                .width(40.dp),
            contentAlignment = Alignment.Center
        ) {
            Box(
                modifier = Modifier.size(40.dp),
                contentAlignment = Alignment.Center
            ) {
                Canvas(modifier = Modifier.fillMaxSize()) {
                    drawCircle(
                        color = Color(0xFF_4CAF50),
                        radius = size.width / 2
                    )
                }
                Icon(
                    imageVector = Icons.Default.Star,
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier.size(24.dp)
                )
            }
        }

        // Second green marker with lightning and close icon
        Box(
            modifier = Modifier
                .fillMaxHeight(0.8f)
                .width(40.dp),
            contentAlignment = Alignment.Center
        ) {
            Box(
                modifier = Modifier.size(40.dp),
                contentAlignment = Alignment.Center
            ) {
                Canvas(modifier = Modifier.fillMaxSize()) {
                    drawCircle(
                        color = Color(0xFF_4CAF50),
                        radius = size.width / 2
                    )
                }
                Row(
                    modifier = Modifier.fillMaxSize(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Default.Star,
                        contentDescription = null,
                        tint = Color.White,
                        modifier = Modifier.size(20.dp)
                    )
                }
            }
        }
    }
}


@Preview
@Composable
private fun VerticalTimelinePreview() {
    VerticalTimeline()
}