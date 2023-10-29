package ru.kram.easywords.navigation.ui

import androidx.compose.foundation.Image
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
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.kram.easywords.common.image.ImageVectorWrapper
import ru.kram.easywords.ui.theme.colors

@Composable
fun BottomNavBar(
	items: List<BottomNavDataItem>,
	textStyle: TextStyle,
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
					textStyle = textStyle,
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
	modifier: Modifier,
	imageModifier: Modifier,
	textModifier: Modifier,
	textStyle: TextStyle,
	item: BottomNavDataItem
) {
	Column(
		modifier = modifier
			.clickable { item.clickAction() }
			.fillMaxHeight(),
		verticalArrangement = Arrangement.Center
	) {
		Image(
			imageVector = item.icon.imageVector,
			contentDescription = item.icon.contentDescription,
			modifier = imageModifier.align(Alignment.CenterHorizontally)
		)

		Text(
			text = item.text,
			modifier = textModifier.align(Alignment.CenterHorizontally),
			style = textStyle
		)
	}
}

@Preview
@Composable
fun BottomNavBarPreview() {

	val items = listOf(
		BottomNavDataItem(
			icon = ImageVectorWrapper(Icons.Filled.Home),
			text = "",
			clickAction = { /*TODO*/ }
		),
		BottomNavDataItem(
			icon = ImageVectorWrapper(Icons.Outlined.List),
			text = "Поиск",
			clickAction = { /*TODO*/ }
		),
		BottomNavDataItem(
			icon = ImageVectorWrapper(Icons.Filled.Settings),
			text = "Настройки",
			clickAction = { /*TODO*/ }
		)
	)

	BottomNavBar(items, MaterialTheme.typography.bodyMedium)
}
