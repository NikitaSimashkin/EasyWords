package ru.kram.easywords.carder

import kotlinx.coroutines.runBlocking
import org.junit.Test
import ru.kram.easywords.base.context.EasyWordsContext
import ru.kram.easywords.base.log.AndroidEasyLogger

class ExampleUnitTest {
	@Test
	fun addition_isCorrect() {
		val words = (
				"Butt\n" +
				"Turn into\n")
			.split("\n")
			.map { it.trim() }

		runBlocking {
			WorstCarder(EasyWordsContext((AndroidEasyLogger()))).writeCardToFile(words)
		}
	}
}