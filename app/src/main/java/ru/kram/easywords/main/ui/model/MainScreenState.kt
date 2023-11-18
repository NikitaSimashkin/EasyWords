package ru.kram.easywords.main.ui.model

sealed class MainScreenState {
	data object LearnSelected: MainScreenState()
	data object DictionarySelected: MainScreenState()
	data object SettingsSelected: MainScreenState()
}