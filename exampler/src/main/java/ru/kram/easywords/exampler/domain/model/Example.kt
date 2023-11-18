package ru.kram.easywords.exampler.domain.model


sealed class Example(
	open val word: String,
	open val example: String
) {

	data class NonTranslatedExample(
		override val word: String,
		override val example: String
	): Example(word, example)

	data class TranslatedExample(
		override val word: String,
		override val example: String,
		val translatedExample: String
	): Example(word, example)
}
