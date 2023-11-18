package ru.kram.easywords.dictionary.domain

import androidx.compose.ui.text.AnnotatedString
import ru.kram.easywords.common.image.AsyncImageResource

data class Deck(
	val id: Int,
	val title: AnnotatedString,
	val subtitle: AnnotatedString,
	val icon: AsyncImageResource,
	val percentCompleted: Int,
	val words: List<Word>
)