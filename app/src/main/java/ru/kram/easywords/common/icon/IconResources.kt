package ru.kram.easywords.common.icon

import android.content.Context
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.List
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.runtime.Composable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import ru.kram.easywords.R

class IconResources(
	context: Context,
	unselectedIconColor: Color,
	selectedIconColor: Color
) {

	val learnUnselected by lazy {
		ColoredImageVectorWrapper(
			imageVector = Icons.Outlined.Person,
			contentDescription = context.resources.getString(R.string.learn_icon_title),
			color = unselectedIconColor
		)
	}
	val dictionaryUnselected by lazy {
		ColoredImageVectorWrapper(
			imageVector = Icons.Outlined.List,
			contentDescription = context.resources.getString(R.string.dictionary_icon_title),
			color = unselectedIconColor
		)
	}
	val settingsUnselected  by lazy {
		ColoredImageVectorWrapper(
			imageVector = Icons.Outlined.Settings,
			contentDescription = context.resources.getString(R.string.settings_icon_title),
			color = unselectedIconColor
		)
	}

	val learnSelected  by lazy {
		learnUnselected.copy(color = selectedIconColor)
	}
	val dictionarySelected  by lazy {
		dictionaryUnselected.copy(color = selectedIconColor)
	}
	val settingsSelected  by lazy {
		settingsUnselected.copy(color = selectedIconColor)
	}

	val search  by lazy {
		ColoredImageVectorWrapper(
			imageVector = Icons.Outlined.Search,
			contentDescription = context.resources.getString(R.string.search_icon_title),
			color = unselectedIconColor
		)
	}
}

val LocalIconResources = staticCompositionLocalOf<IconResources> { error("Not provided IconResources!") }
val icons @Composable get() = LocalIconResources.current