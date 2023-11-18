package ru.kram.easywords.exampler.data

import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.request.get
import io.ktor.client.statement.bodyAsText
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.select.Elements
import ru.kram.easywords.exampler.domain.model.Example

class ServerDataSource() {

	suspend fun getExamples(word: String, number: Int): List<Example>{
		val url = "https://context.reverso.net/translation/english-russian/$word"
		val client = HttpClient(CIO)

		client.use { client ->
			val response = client.get(url)
			val body = response.bodyAsText()
			val doc: Document = Jsoup.parse(body)

			val sourceDirection = "ltr"
			val targetDirection = "ltr"
			val sourceExamples: List<String> =
				extractExamples(doc, "example", "div.src.$sourceDirection span.text")
			val targetExamples: List<String> =
				extractExamples(doc, "example", "div.trg.$targetDirection span.text")


			val result = sourceExamples.mapIndexed { index, s ->
				Example.TranslatedExample(word, s, targetExamples[index])
			}.subList(0, number)

			return result
		}
	}

	private fun extractExamples(doc: Document, containerClass: String, selector: String): List<String> {
		val examplesContainer: Elements = doc.select(".$containerClass")
		val examples = examplesContainer.select(selector).eachText().flatMap { it.trim().split('\n') }
		return examples
	}
}