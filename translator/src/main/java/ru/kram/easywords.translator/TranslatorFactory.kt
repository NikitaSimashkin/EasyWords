package ru.kram.easywords.translator

import ru.kram.easywords.base.context.EasyWordsContext
import ru.kram.easywords.translator.impl.AmazonTranslator

object TranslatorFactory {

	fun createAmazonTranslator(easyWordsContext: EasyWordsContext): Translator {
		return AmazonTranslator(easyWordsContext)
	}
}