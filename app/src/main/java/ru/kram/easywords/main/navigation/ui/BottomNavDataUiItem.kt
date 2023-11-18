package ru.kram.easywords.main.navigation.ui

import ru.kram.easywords.common.icon.ColoredImageVectorWrapper

data class BottomNavDataUiItem(
	val icon: ColoredImageVectorWrapper,
	val text: String,
	val clickAction: () -> Unit
)