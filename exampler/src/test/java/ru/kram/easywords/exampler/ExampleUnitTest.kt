package ru.kram.easywords.exampler

import kotlinx.coroutines.runBlocking
import org.junit.Test

import ru.kram.easywords.exampler.data.ServerDataSource
import ru.kram.easywords.base.context.EasyWordsContext
import ru.kram.easywords.base.log.PrintlnEasyLogger

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

	private val easyWordsContext = EasyWordsContext(PrintlnEasyLogger())
	@Test
	fun testReversoExampler() {
		runBlocking {
			val data = ServerDataSource()
			val examples = data.getExamples("hello")
			println(examples)
		}
	}
}