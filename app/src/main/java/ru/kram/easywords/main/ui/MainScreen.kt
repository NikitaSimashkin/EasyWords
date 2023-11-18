package ru.kram.easywords.main.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import ru.kram.easywords.R
import ru.kram.easywords.common.icon.icons
import ru.kram.easywords.main.MainViewModel
import ru.kram.easywords.main.navigation.ui.BottomNavBar
import ru.kram.easywords.main.navigation.ui.BottomNavDataUiItem
import ru.kram.easywords.main.ui.model.MainScreenBottomEvent
import ru.kram.easywords.main.ui.model.MainScreenState
import ru.kram.easywords.ui.theme.colors
import ru.kram.easywords.ui.theme.dimens

@Composable
fun MainScreen(
	viewModel: MainViewModel,
	content: @Composable () -> Unit = {}
) {
	val mainScreenData = viewModel.mainScreenState.collectAsState()

	Column(modifier = Modifier.fillMaxSize()) {

		Box(modifier = Modifier.weight(1f)) {
			content()
		}

		Box {
			val items = listOf(
				BottomNavDataUiItem(
					icon = if (mainScreenData.value == MainScreenState.LearnSelected) icons.learnSelected else icons.learnUnselected,
					text = stringResource(id = R.string.learn_screen_title),
					clickAction = { viewModel.handleEvent(MainScreenBottomEvent.ClickLearn) }
				),
				BottomNavDataUiItem(
					icon = if (mainScreenData.value == MainScreenState.DictionarySelected) icons.dictionarySelected else icons.dictionaryUnselected,
					text = stringResource(id = R.string.dictionary_screen_title),
					clickAction = { viewModel.handleEvent(MainScreenBottomEvent.ClickDictionary) }
				),
				BottomNavDataUiItem(
					icon = if (mainScreenData.value == MainScreenState.SettingsSelected) icons.settingsSelected else icons.settingsUnselected,
					text = stringResource(id = R.string.settings_screen_title),
					clickAction = { viewModel.handleEvent(MainScreenBottomEvent.ClickSettings) }
				)
			)
			BottomNavBar(
				modifier = Modifier
					.fillMaxWidth()
					.height(dimens.bottomNavHeight)
					.background(colors.primary),
				imageModifier = Modifier.size(dimens.bigIconSize),
				textModifier = Modifier,
				items = items
			)
		}
	}
}

@Preview
@Composable
fun BaseScreenPreview() {

	val items = listOf(
		BottomNavDataUiItem(
			icon = icons.learnUnselected,
			text = "Main",
			clickAction = {}
		),
		BottomNavDataUiItem(
			icon = icons.dictionaryUnselected,
			text = "Dictionary",
			clickAction = {}
		),
		BottomNavDataUiItem(
			icon = icons.settingsUnselected,
			text = "Settings",
			clickAction = {}
		)
	)

	MainScreen(MainViewModel(rememberNavController()))
}