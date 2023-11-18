package ru.kram.easywords.ui.theme

import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.graphics.Shape

data class DefaultShapes(
	val baseRoundCornerShape: Shape = RoundedCornerShape(dimens.cornerRadius),
	val circleShape: Shape = CircleShape
)

private val defaultShapes = DefaultShapes()
val MaterialTheme.customShapes get() = defaultShapes