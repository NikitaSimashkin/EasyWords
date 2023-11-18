package ru.kram.easywords.main.ui.model

sealed class MainScreenUiSate {
	data object MainSelected: MainScreenUiSate()
	data object DictionarySelected: MainScreenUiSate()
	data object SettingsSelected: MainScreenUiSate()
}