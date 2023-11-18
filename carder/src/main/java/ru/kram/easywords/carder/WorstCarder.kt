package ru.kram.easywords.carder

import ru.kram.easywords.carder.model.Card
import ru.kram.easywords.exampler.data.ServerDataSource
import ru.kram.easywords.exampler.domain.model.Example
import ru.kram.easywords.translator.TranslatorFactory
import ru.kram.easywords.base.context.EasyWordsContext
import java.io.File

class WorstCarder(
	private val easyWordsContext: EasyWordsContext
) {
	suspend fun writeCardToFile(list: List<String>) {
		val translator = TranslatorFactory.createAmazonTranslator(easyWordsContext)
		val dataSource = ServerDataSource()

		val cards = list.map {
			val examples = dataSource.getExamples(it, 4).filterIsInstance<Example.TranslatedExample>()
			val translateWord = translator.translate(it)
			Card(it, translateWord, examples)
		}

		val file = File("cards.txt").apply {
			if (!exists()) createNewFile()
		}

		file.bufferedWriter().use { out ->
			cards.forEach { card ->
				val exampleString = card.examples.map { "${it.example};${it.translatedExample}" }.joinToString(";")
				out.write("${card.word};${card.translateWord};$exampleString;\n")
			}
		}
	}
}