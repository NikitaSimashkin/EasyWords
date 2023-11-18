package ru.kram.easywords.common.icon

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector

data class ColoredImageVectorWrapper(
	val imageVector: ImageVector,
	val color: Color,
	val contentDescription: String,
)