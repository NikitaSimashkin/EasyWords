package ru.kram.easywords.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.unit.dp

open class DefaultDimens {

	open val bottomNavHeight = 56.dp

	open val baseIconSize = 28.dp

	open val baseHorizontalMargin = 12.dp

	open val baseVerticalMargin = 12.dp

	open val baseCornerRadius = 12.dp
}

private val currentDimens = DefaultDimens()

val MaterialTheme.dimens get() = currentDimens
