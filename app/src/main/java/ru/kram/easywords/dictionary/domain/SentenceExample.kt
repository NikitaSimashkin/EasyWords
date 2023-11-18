package ru.kram.easywords.dictionary.domain

import androidx.compose.ui.text.AnnotatedString
import ru.kram.easywords.common.audio.AsyncAudioResource

data class SentenceExample (
	val text: AnnotatedString,
	val hiddenText: AnnotatedString,
	val audioResource: AsyncAudioResource
)