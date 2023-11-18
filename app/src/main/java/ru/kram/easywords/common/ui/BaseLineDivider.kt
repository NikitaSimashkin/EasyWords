package ru.kram.easywords.common.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import ru.kram.easywords.ui.theme.colors

@Composable
fun BaseLineDivider(size: Dp = 1.dp, color: Color = colors.surface, horizontal: Boolean = true) {
	val modifier = if (horizontal) {
		Modifier.height(size).fillMaxWidth()
	} else {
		Modifier.width(size).fillMaxHeight()
	}
	Spacer(modifier = modifier.background(color = color))
}