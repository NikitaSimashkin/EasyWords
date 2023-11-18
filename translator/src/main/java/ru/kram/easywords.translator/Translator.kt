package ru.kram.easywords.translator

import ru.kram.easywords.base.language.Language

interface Translator {

	suspend fun translate(
		text: String,
		sourceLanguage: Language = Language.EN,
		targetLanguage: Language = Language.RU
	): String
}