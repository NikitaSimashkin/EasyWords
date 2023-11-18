package ru.kram.easywords.main

import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import ru.kram.easywords.common.base.event.EventHandler
import ru.kram.easywords.main.ui.model.MainScreenBottomEvent
import ru.kram.easywords.main.ui.model.MainScreenState
import ru.kram.easywords.main.navigation.BottomNavScreen

class MainViewModel(
	private val navController: NavController
): ViewModel(), EventHandler<MainScreenBottomEvent> {

	private val internalMainScreenState = MutableStateFlow<MainScreenState>(MainScreenState.LearnSelected)
	val mainScreenState: StateFlow<MainScreenState> = internalMainScreenState

	override fun handleEvent(event: MainScreenBottomEvent) {
		when (event) {
			MainScreenBottomEvent.ClickLearn -> onClickLearn()
			MainScreenBottomEvent.ClickDictionary -> onClickDictionary()
			MainScreenBottomEvent.ClickSettings -> onClickSettings()
		}
	}

	private fun onClickLearn() {
		if (internalMainScreenState.value == MainScreenState.LearnSelected) return
		internalMainScreenState.value = MainScreenState.LearnSelected
		navController.navigate(BottomNavScreen.Learn.route)
	}

	private fun onClickDictionary() {
		if (internalMainScreenState.value == MainScreenState.DictionarySelected) return
		internalMainScreenState.value = MainScreenState.DictionarySelected
		navController.navigate(BottomNavScreen.Dictionary.route)
	}

	private fun onClickSettings() {
		if (internalMainScreenState.value == MainScreenState.SettingsSelected) return
		internalMainScreenState.value = MainScreenState.SettingsSelected
		navController.navigate(BottomNavScreen.Settings.route)
	}
}