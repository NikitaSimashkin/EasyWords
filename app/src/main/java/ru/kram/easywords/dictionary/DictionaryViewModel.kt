package ru.kram.easywords.dictionary

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import ru.kram.easywords.dictionary.ui.model.DictionaryScreenData

class DictionaryViewModel: ViewModel() {

	private val internalDictionaryScreenData = MutableStateFlow(DictionaryScreenData(
		searchText = "",
		onSearchValueChange = ::onSearchValueChange
	))
	val dictionaryScreenData: StateFlow<DictionaryScreenData> = internalDictionaryScreenData

	private fun onSearchValueChange(value: String) {
		internalDictionaryScreenData.value = internalDictionaryScreenData.value.copy(
			searchText = value
		)
	}
}