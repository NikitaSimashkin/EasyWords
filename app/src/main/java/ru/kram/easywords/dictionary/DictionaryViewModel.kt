package ru.kram.easywords.dictionary

import android.content.Context
import android.content.res.Resources
import androidx.compose.ui.text.AnnotatedString
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import ru.kram.easywords.R
import ru.kram.easywords.dictionary.ui.decklist.model.DeckUiItem
import ru.kram.easywords.dictionary.ui.model.DictionaryScreenUiState
import util.ImageUtils.toBitmap

class DictionaryViewModel(context: Context) : ViewModel() {

	private val internalDictionaryScreenUiState by lazy {
		MutableStateFlow(
			DictionaryScreenUiState(
				searchText = "",
				onSearchValueChange = ::onSearchValueChange,
				decks = listOf(
					DeckUiItem(
						id = 1,
						icon = context.getDrawable(androidx.core.R.drawable.ic_call_answer_video)!!.toBitmap(),
						title = AnnotatedString("1"),
						subtitle = AnnotatedString("2"),
						percentCompleted = 3
					),
					DeckUiItem(
						id = 1,
						icon = context.getDrawable(androidx.core.R.drawable.ic_call_answer_video)!!.toBitmap(),
						title = AnnotatedString("4"),
						subtitle = AnnotatedString("dfsfsdf"),
						percentCompleted = 45
					),
					DeckUiItem(
						id = 1,
						icon = context.getDrawable(androidx.core.R.drawable.ic_call_answer_video)!!.toBitmap(),
						title = AnnotatedString("ddd"),
						subtitle = AnnotatedString("fff"),
						percentCompleted = 44
					),
					DeckUiItem(
						id = 1,
						icon = context.getDrawable(androidx.core.R.drawable.ic_call_answer_video)!!.toBitmap(),
						title = AnnotatedString("fgd"),
						subtitle = AnnotatedString("sss"),
						percentCompleted = 8
					)
				)
			)
		)
	}

	val dictionaryScreenUiState: StateFlow<DictionaryScreenUiState> = internalDictionaryScreenUiState

	private fun onSearchValueChange(value: String) {
		internalDictionaryScreenUiState.value = internalDictionaryScreenUiState.value.copy(
			searchText = value
		)
	}
}