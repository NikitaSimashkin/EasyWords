package ru.kram.easywords.basescreen

import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import ru.kram.easywords.basescreen.ui.model.BaseScreenUiState
import ru.kram.easywords.navigation.BottomNavScreen

class BaseScreenViewModel(
	private val navController: NavController
): ViewModel() {

	private val internalBaseScreenUiState = MutableStateFlow<BaseScreenUiState>(BaseScreenUiState.MainSelected)
	val baseScreenUiState: StateFlow<BaseScreenUiState> = internalBaseScreenUiState

	private fun onClickMain() {
		internalBaseScreenUiState.value = BaseScreenUiState.MainSelected
		navController.navigate(BottomNavScreen.Learn.route)
	}

	private fun onClickDictionary() {
		internalBaseScreenUiState.value = BaseScreenUiState.DictionarySelected
		navController.navigate(BottomNavScreen.Dictionary.route)
	}

	private fun onClickSettings() {
		internalBaseScreenUiState.value = BaseScreenUiState.SettingsSelected
		navController.navigate(BottomNavScreen.Settings.route)
	}
}