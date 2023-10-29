package ru.kram.easywords.basescreen.ui.model

import ru.kram.easywords.navigation.ui.BottomNavDataItem

data class BaseScreenData(
	val bottomMenuItems: List<BottomNavDataItem> = emptyList(),
)