package ru.kram.easywords.navigation.ui

import ru.kram.easywords.common.image.ImageVectorWrapper

data class BottomNavDataItem(
	val icon: ImageVectorWrapper,
	val text: String,
	val clickAction: () -> Unit,
)