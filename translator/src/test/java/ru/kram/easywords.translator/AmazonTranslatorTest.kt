package ru.kram.easywords.translator

import kotlinx.coroutines.runBlocking
import org.junit.Test

import ru.kram.easywords.base.context.EasyWordsContext
import ru.kram.easywords.base.log.PrintlnEasyLogger

class AmazonTranslatorTest {

	private val translator =
		TranslatorFactory.createAmazonTranslator(EasyWordsContext(PrintlnEasyLogger()))

	@Test
	fun testAmazonTranslate() = runBlocking {
		assert("Привет, мир" == translator.translate("Hello, world"))
	}
}