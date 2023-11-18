package ru.kram.easywords.dictionary.ui.decklist.model

import android.graphics.Bitmap
import androidx.compose.ui.text.AnnotatedString

data class DeckUiItem(
	val id: Int,
	val icon: Bitmap,
	val title: AnnotatedString,
	val subtitle: AnnotatedString,
	val percentCompleted: Int? = null
)
