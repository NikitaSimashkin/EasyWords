package ru.kram.easywords.dictionary.ui.model

import ru.kram.easywords.dictionary.ui.decklist.model.DeckUiItem

data class DictionaryScreenUiState(
	val searchText: String = "",
	val onSearchValueChange: (String) -> Unit = {},
	val decks: List<DeckUiItem> = emptyList()
)