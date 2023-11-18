package ru.kram.easywords.carder.model

import ru.kram.easywords.exampler.domain.model.Example

data class Card(
	val word: String,
	val translateWord: String,
	val examples: List<Example.TranslatedExample>,
)
