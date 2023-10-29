package ru.kram.easywords.basescreen.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import ru.kram.easywords.R
import ru.kram.easywords.common.icon.IconResources
import ru.kram.easywords.basescreen.ui.model.BaseScreenData
import ru.kram.easywords.common.icon.icons
import ru.kram.easywords.navigation.ui.BottomNavBar
import ru.kram.easywords.navigation.ui.BottomNavDataItem
import ru.kram.easywords.ui.theme.colors
import ru.kram.easywords.ui.theme.dimens
import ru.kram.easywords.ui.theme.typography

@Composable
fun BaseScreen(
	data: BaseScreenData,
	content: @Composable () -> Unit = {}
) {

	Column(modifier = Modifier.fillMaxSize()) {

		Box(modifier = Modifier.weight(1f)) {
			content()
		}

		BottomNavBar(
			modifier = Modifier
				.fillMaxWidth()
				.height(dimens.bottomNavHeight)
				.background(colors.primary),
			imageModifier = Modifier.size(dimens.baseIconSize),
			textModifier = Modifier,
			textStyle = typography.bodyMedium,
			items = data.bottomMenuItems
		)
	}
}

@Preview
@Composable
fun BaseScreenPreview() {

	val items = listOf(
		BottomNavDataItem(
			icon = icons.main,
			text = stringResource(id = R.string.main_screen_title),
			clickAction = {}
		),
		BottomNavDataItem(
			icon = icons.dictionary,
			text = stringResource(id = R.string.dictionary_screen_title),
			clickAction = {}
		),
		BottomNavDataItem(
			icon = icons.settings,
			text = stringResource(id = R.string.settings_screen_title),
			clickAction = {}
		)
	)

	BaseScreen(BaseScreenData(items))
}