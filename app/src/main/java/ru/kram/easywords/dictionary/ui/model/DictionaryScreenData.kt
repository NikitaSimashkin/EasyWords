package ru.kram.easywords.dictionary.ui.model

data class DictionaryScreenData(
	val searchText: String = "",
	val onSearchValueChange: (String) -> Unit = {}
)