package ru.kram.easywords.dictionary.ui.decklist

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import ru.kram.easywords.R
import ru.kram.easywords.common.ui.BaseLineDivider
import ru.kram.easywords.dictionary.ui.decklist.model.DeckUiItem
import ru.kram.easywords.ui.theme.dimens
import util.ImageUtils.toBitmap

@Composable
fun DeckList(
	items: List<DeckUiItem>,
	modifier: Modifier = Modifier,
	itemModifier: Modifier = Modifier
) {

	LazyColumn(modifier = modifier) {
		val last = items.lastOrNull()
		items(items) {item ->
			DeckItem(
				data = item,
				modifier = itemModifier.padding(
					top = dimens.rowsMarginTop,
					bottom = dimens.rowsMarginBottom
				)
			)
			if (item != last) {
				BaseLineDivider()
			}
		}
	}
}

@Composable
fun DeckItem(
	data: DeckUiItem,
	modifier: Modifier = Modifier
) {
	Row(
		modifier = modifier
			.fillMaxWidth()
			.height(dimens.deckItemHeight)
	) {
		Icon(
			bitmap = data.icon.asImageBitmap(),
			contentDescription = data.title.toString(),
			modifier = Modifier
				.padding(
					start = dimens.rowPaddingStart,
					end = dimens.leftIconPaddingEnd
				)
				.size(dimens.mediumIconSize)
				.align(Alignment.CenterVertically)
		)

		Column(
			modifier = Modifier
				.align(Alignment.CenterVertically)
				.padding(
					start = dimens.rowPaddingStart,
					end = dimens.leftIconPaddingEnd
				)
		) {
			Text(text = data.title)
			Text(text = data.subtitle)
		}

		Text(
			modifier = Modifier
				.padding(start = dimens.rowPaddingStart, end = dimens.rowPaddingEnd)
				.fillMaxWidth()
				.align(Alignment.CenterVertically),
			text = "${data.percentCompleted}%",
			textAlign = TextAlign.End
		)
	}
}

@Preview
@Composable
fun DeckListPreview() {
	val item = DeckUiItem(
		id = 0,
		icon = LocalContext.current.getDrawable(R.drawable.ic_launcher_foreground)!!
			.toBitmap(),
		title = AnnotatedString("title"),
		subtitle = AnnotatedString("subtitle"),
		percentCompleted = 0
	)
	DeckList(
		listOf(
			item, item, item, item, item, item, item, item, item, item, item, item, item, item
		),
		modifier = Modifier.fillMaxSize()
	)
}