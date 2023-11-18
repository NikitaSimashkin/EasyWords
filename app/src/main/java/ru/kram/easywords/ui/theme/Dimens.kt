package ru.kram.easywords.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.unit.dp

open class DefaultDimens {

	open val bottomNavHeight = 56.dp

	open val mediumIconSize = 24.dp
	open val bigIconSize = 28.dp

	open val horizontalMargin = 12.dp
	open val verticalMargin = 12.dp

	open val cornerRadius = 12.dp

	open val searchBarHeight = 48.dp
	open val deckItemHeight = 48.dp

	open val rowPaddingStart = 8.dp
	open val rowPaddingEnd = 8.dp
	open val rowsMarginBottom = 12.dp
	open val rowsMarginTop = 12.dp
	open val leftIconPaddingEnd = 16.dp

	open val textFieldBorderSizeUnfocused = 1.dp
	open val textFieldBorderSizeFocused = 2.dp
}

private val currentDimens = DefaultDimens()
val MaterialTheme.dimens get() = currentDimens
