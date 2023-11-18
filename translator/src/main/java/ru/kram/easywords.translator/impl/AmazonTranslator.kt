package ru.kram.easywords.translator.impl

import com.amazonaws.auth.AWSCredentials
import com.amazonaws.handlers.AsyncHandler
import com.amazonaws.services.translate.AmazonTranslateAsyncClient
import com.amazonaws.services.translate.model.TranslateTextRequest
import com.amazonaws.services.translate.model.TranslateTextResult
import ru.kram.easywords.base.context.EasyWordsContext
import ru.kram.easywords.base.language.Language
import ru.kram.easywords.translator.Translator
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

internal class AmazonTranslator(
	context: EasyWordsContext
): Translator {
	private val logger = context.easyLogger

	override suspend fun translate(
		text: String,
		sourceLanguage: Language,
		targetLanguage: Language
	): String {
		val awsCredentials: AWSCredentials = object : AWSCredentials {
			override fun getAWSAccessKeyId(): String = "AKIAVFFFRI64CIECBI4S"
			override fun getAWSSecretKey(): String = "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"
		}

		val translateAsyncClient = AmazonTranslateAsyncClient(awsCredentials)
		val translateTextRequest: TranslateTextRequest = TranslateTextRequest()
			.withText(text)
			.withSourceLanguageCode(sourceLanguage.code)
			.withTargetLanguageCode(targetLanguage.code)

		return doTranslateRequest(translateAsyncClient, translateTextRequest)
	}

	private suspend fun doTranslateRequest(
		translateAsyncClient: AmazonTranslateAsyncClient,
		translateTextRequest: TranslateTextRequest
	): String {
		return suspendCoroutine { continuation ->
			translateAsyncClient.translateTextAsync(
				translateTextRequest,
				object : AsyncHandler<TranslateTextRequest?, TranslateTextResult?> {
					override fun onError(error: Exception) {
						logger.d(TAG) { "Error occurred in translating the text: " + error.localizedMessage }
						continuation.resume(error.localizedMessage)
					}

					override fun onSuccess(
						request: TranslateTextRequest?,
						translateTextResult: TranslateTextResult?
					) {
						logger.d(TAG) { "Original Text: ${request?.text}" }
						logger.d(TAG) { "Translated Text: ${translateTextResult?.translatedText}" }
						continuation.resume(translateTextResult?.translatedText ?: "")
					}
				}
			)
		}
	}

	companion object {
		private const val TAG = "AmazonTranslator"
	}
}
