package ru.kram.easywords.dictionary.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import ru.kram.easywords.R
import ru.kram.easywords.common.icon.IconResources
import ru.kram.easywords.common.icon.LocalIconResources
import ru.kram.easywords.common.icon.icons
import ru.kram.easywords.common.ui.EasyEditText
import ru.kram.easywords.dictionary.ui.model.DictionaryScreenData
import ru.kram.easywords.ui.theme.colors
import ru.kram.easywords.ui.theme.dimens
import ru.kram.easywords.ui.theme.typography

@Composable
fun DictionaryScreen(data: DictionaryScreenData) {

	Column(modifier = Modifier.fillMaxSize()) {
		EasyEditText(
			modifier = Modifier
				.padding(
					start = dimens.baseHorizontalMargin,
					end = dimens.baseHorizontalMargin,
					top = dimens.baseVerticalMargin,
				)
				.fillMaxWidth(),
			leadingIcon = icons.search,
			hint = stringResource(id = R.string.find_word_hint),
			onValueChange = data.onSearchValueChange,
			value = data.searchText,
			textStyle = typography.bodyMedium,
			colors = OutlinedTextFieldDefaults.colors(
				focusedBorderColor = colors.primary,
				unfocusedBorderColor = colors.primary,
				focusedPlaceholderColor = colors.onPrimary,
				unfocusedPlaceholderColor = colors.onPrimary,
			)
		)
	}
}

@Preview
@Composable
fun DictionaryScreenPreview() {
	DictionaryScreen(DictionaryScreenData())
}