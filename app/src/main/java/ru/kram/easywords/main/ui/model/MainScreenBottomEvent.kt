package ru.kram.easywords.main.ui.model

import ru.kram.easywords.common.base.event.model.Event

sealed class MainScreenBottomEvent: Event {
	data object ClickLearn: MainScreenBottomEvent()
	data object ClickDictionary: MainScreenBottomEvent()
	data object ClickSettings: MainScreenBottomEvent()
}