package ru.kram.easywords.main.navigation.ui

import androidx.compose.ui.text.TextStyle
import ru.kram.easywords.common.icon.ColoredImageVectorWrapper

data class BottomNavDataItem(
	val icon: ColoredImageVectorWrapper,
	val text: String,
	val clickAction: () -> Unit
)