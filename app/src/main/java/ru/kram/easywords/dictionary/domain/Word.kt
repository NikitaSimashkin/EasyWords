package ru.kram.easywords.dictionary.domain

import androidx.compose.ui.text.AnnotatedString
import ru.kram.easywords.common.audio.AsyncAudioResource
import ru.kram.easywords.common.image.AsyncImageResource
import ru.kram.easywords.common.progress.Progress

data class Word(
	val id: Int,
	val wordHtml: AnnotatedString,
	val image: AsyncImageResource,
	val pronunciation: AnnotatedString,
	val secondPronunciation: AnnotatedString,
	val examples: List<SentenceExample>,
	val audioResource: AsyncAudioResource,
	val translation: AnnotatedString,
	val progress: Progress
)