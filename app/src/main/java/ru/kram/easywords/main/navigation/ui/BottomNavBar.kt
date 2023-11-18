package ru.kram.easywords.navigation.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.List
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.kram.easywords.common.icon.ColoredImageVectorWrapper
import ru.kram.easywords.ui.theme.colors

@Composable
fun BottomNavBar(
	items: List<BottomNavDataItem>,
	modifier: Modifier = Modifier,
	textModifier: Modifier = Modifier,
	imageModifier: Modifier = Modifier,
) {
	Column(modifier = modifier.fillMaxHeight()) {
		Row(modifier = Modifier.weight(1f)) {
			items.forEach { item ->
				BottomNavItem(
					modifier = Modifier.weight(1f),
					imageModifier = imageModifier,
					textModifier = textModifier,
					item = item
				)
			}
		}

		Spacer(
			modifier = Modifier
				.fillMaxWidth()
				.height(2.dp)
				.background(colors.background)
		)
	}
}

@Composable
fun BottomNavItem(
	item: BottomNavDataItem,
	modifier: Modifier = Modifier,
	imageModifier: Modifier = Modifier,
	textModifier: Modifier = Modifier,
) {
	Column(
		modifier = modifier
			.clickable { item.clickAction() }
			.fillMaxHeight(),
		verticalArrangement = Arrangement.Center
	) {
		Icon(
			imageVector = item.icon.imageVector,
			contentDescription = item.icon.contentDescription,
			modifier = imageModifier.align(Alignment.CenterHorizontally),
			tint = item.icon.color
		)

		Text(
			text = item.text,
			modifier = textModifier.align(Alignment.CenterHorizontally),
			style = item.textStyle,
		)
	}
}

@Preview
@Composable
fun BottomNavBarPreview() {

	val items = listOf(
		BottomNavDataItem(
			icon = ColoredImageVectorWrapper(Icons.Default.Home, Color.Unspecified, "Home"),
			text = "Home",
			textStyle = TextStyle.Default,
			contentDescription =  "",
			clickAction = {}
		),
		BottomNavDataItem(
			icon = ColoredImageVectorWrapper(Icons.Outlined.List, Color.Unspecified, "List"),
			text = "List",
			textStyle = TextStyle.Default,
			contentDescription =  "",
			clickAction = {}
		),
		BottomNavDataItem(
			icon = ColoredImageVectorWrapper(Icons.Default.Settings, Color.Unspecified, "Settings"),
			text = "Settings",
			textStyle = TextStyle.Default,
			contentDescription =  "",
			clickAction = {}
		)
	)

	BottomNavBar(items = items)
}
