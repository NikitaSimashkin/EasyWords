package ru.kram.easywords.basescreen.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import ru.kram.easywords.R
import ru.kram.easywords.basescreen.ui.model.BaseScreenUiState
import ru.kram.easywords.common.icon.icons
import ru.kram.easywords.navigation.ui.BottomNavBar
import ru.kram.easywords.navigation.ui.BottomNavDataItem
import ru.kram.easywords.ui.theme.colors
import ru.kram.easywords.ui.theme.dimens
import ru.kram.easywords.ui.theme.typography

@Composable
fun BaseScreen(
	data: BaseScreenUiState,
	content: @Composable () -> Unit = {}
) {

	Column(modifier = Modifier.fillMaxSize()) {

		Box(modifier = Modifier.weight(1f)) {
			content()
		}

		Box {
			val mainContentDescription = stringResource(id = R.string.main_screen_title)
			val dictionaryContentDescription = stringResource(id = R.string.dictionary_screen_title)
			val settingsContentDescription = stringResource(id = R.string.settings_screen_title)
			val items = listOf(
				BottomNavDataItem(
					icon = if (data == BaseScreenUiState.MainSelected) icons.mainSelected else icons.mainUnselected,
					text = mainContentDescription,
					textStyle = typography.bodyMedium,
					contentDescription = mainContentDescription,
					clickAction = {}
				),
				BottomNavDataItem(
					icon = if (data == BaseScreenUiState.DictionarySelected) icons.dictionarySelected else icons.dictionaryUnselected,
					text = dictionaryContentDescription,
					textStyle = typography.bodyMedium,
					contentDescription = dictionaryContentDescription,
					clickAction = {}
				),
				BottomNavDataItem(
					icon = if (data == BaseScreenUiState.SettingsSelected) icons.settingsSelected else icons.settingsUnselected,
					text = settingsContentDescription,
					textStyle = typography.bodyMedium,
					contentDescription = settingsContentDescription,
					clickAction = {}
				)
			)

			BottomNavBar(
				modifier = Modifier
					.fillMaxWidth()
					.height(dimens.bottomNavHeight)
					.background(colors.primary),
				imageModifier = Modifier.size(dimens.baseIconSize),
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
		BottomNavDataItem(
			icon = icons.mainUnselected,
			text = "Main",
			textStyle = typography.bodyMedium,
			contentDescription = "Main",
			clickAction = {}
		),
		BottomNavDataItem(
			icon = icons.dictionaryUnselected,
			text = "Dictionary",
			textStyle = typography.bodyMedium,
			contentDescription = "Dictionary",
			clickAction = {}
		),
		BottomNavDataItem(
			icon = icons.settingsUnselected,
			text = "Settings",
			textStyle = typography.bodyMedium,
			contentDescription = "Settings",
			clickAction = {}
		)
	)

	BaseScreen(BaseScreenUiState.MainSelected)
}