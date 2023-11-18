package ru.kram.easywords.exampler.domain

import ru.kram.easywords.exampler.domain.model.Example
import ru.kram.easywords.base.language.Language

interface Exampler {

	suspend fun getExamples(
		word: String,
		sourceLanguage: Language = Language.EN,
		targetLanguage: Language = Language.RU,
		numberOfExamples: Int = 5
	): List<Example>
}