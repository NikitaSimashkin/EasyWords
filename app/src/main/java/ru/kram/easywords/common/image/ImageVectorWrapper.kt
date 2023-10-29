package ru.kram.easywords.common.image

import androidx.compose.ui.graphics.vector.ImageVector

data class ImageVectorWrapper(
	val imageVector: ImageVector,
	val contentDescription: String = ""
)