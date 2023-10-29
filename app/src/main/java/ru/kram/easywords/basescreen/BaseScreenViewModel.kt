package ru.kram.easywords.basescreen

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import ru.kram.easywords.R
import ru.kram.easywords.basescreen.ui.model.BaseScreenData
import ru.kram.easywords.common.icon.IconResources
import ru.kram.easywords.navigation.Screen
import ru.kram.easywords.navigation.ui.BottomNavDataItem

class BaseScreenViewModel(
	context: Context,
	icons: IconResources,
	private val navController: NavController
): ViewModel() {

	private val bottomMenuItems = listOf(
		BottomNavDataItem(
			icon = icons.main,
			text = context.getString(R.string.main_screen_title),
			clickAction = ::onClickMain
		),
		BottomNavDataItem(
			icon = icons.dictionary,
			text = context.getString(R.string.dictionary_screen_title),
			clickAction = ::onClickDictionary
		),
		BottomNavDataItem(
			icon = icons.settings,
			text = context.getString(R.string.settings_screen_title),
			clickAction = ::onClickSettings
		)
	)

	private val internalBaseScreenData = MutableStateFlow(BaseScreenData(
		bottomMenuItems = bottomMenuItems
	))
	val baseScreenData: StateFlow<BaseScreenData> = internalBaseScreenData

	private fun onClickMain() {
		navController.navigate(Screen.Main.route)
	}

	private fun onClickDictionary() {
		navController.navigate(Screen.Dictionary.route)
	}

	private fun onClickSettings() {
		navController.navigate(Screen.Settings.route)
	}
}