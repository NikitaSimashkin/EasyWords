package ru.kram.easywords.ui.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable

open class DefaultShapes() {
	open val baseRoundCornerShape = RoundedCornerShape(dimens.baseCornerRadius)
}

private val defaultShapes = DefaultShapes()

val MaterialTheme.customShapes get() = defaultShapes