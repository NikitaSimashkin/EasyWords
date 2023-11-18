package ru.kram.easywords.dictionary.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import ru.kram.easywords.R
import ru.kram.easywords.common.icon.icons
import ru.kram.easywords.common.ui.EasyEditText
import ru.kram.easywords.dictionary.ui.decklist.DeckList
import ru.kram.easywords.dictionary.ui.model.DictionaryScreenUiState
import ru.kram.easywords.ui.theme.colors
import ru.kram.easywords.ui.theme.dimens
import ru.kram.easywords.ui.theme.typography

@Composable
fun DictionaryScreen(state: DictionaryScreenUiState) {

	Box(modifier = Modifier.fillMaxSize()) {
		Column(
			modifier = Modifier
				.padding(
					start = dimens.horizontalMargin,
					end = dimens.horizontalMargin,
					top = dimens.verticalMargin,
				)
				.fillMaxSize()
		) {
			EasyEditText(
				modifier = Modifier
					.padding(bottom = dimens.rowsMarginBottom)
					.fillMaxWidth()
					.height(dimens.searchBarHeight),
				leadingIcon = icons.search,
				hint = stringResource(id = R.string.find_word_hint),
				onValueChange = state.onSearchValueChange,
				value = state.searchText,
				textStyle = typography.bodyLarge,
				hintTextStyle = typography.bodyLarge.copy(color = colors.surface)
			)

			DeckList(items = state.decks, modifier = Modifier.fillMaxSize())
		}
	}
}

@Preview
@Composable
fun DictionaryScreenPreview() {
	DictionaryScreen(DictionaryScreenUiState())
}