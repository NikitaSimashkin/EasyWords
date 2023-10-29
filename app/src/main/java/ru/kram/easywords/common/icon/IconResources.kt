package ru.kram.easywords.common.icon

import android.content.Context
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.List
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.runtime.Composable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import ru.kram.easywords.R
import ru.kram.easywords.common.image.ImageVectorWrapper

class IconResources(context: Context) {

	val main = ImageVectorWrapper(
		imageVector = Icons.Outlined.Home,
		contentDescription = context.resources.getString(R.string.main_icon_title)
	)

	val dictionary = ImageVectorWrapper(
		imageVector = Icons.Outlined.List,
		contentDescription = context.resources.getString(R.string.dictionary_icon_title)
	)

	val settings = ImageVectorWrapper(
		imageVector = Icons.Outlined.Settings,
		contentDescription = context.resources.getString(R.string.settings_icon_title)
	)

	val search = ImageVectorWrapper(
		imageVector = Icons.Outlined.Search,
		contentDescription = context.resources.getString(R.string.search_icon_title)
	)
}

val LocalIconResources = staticCompositionLocalOf<IconResources> { error("Not provided IconResources!") }
val icons @Composable get() = LocalIconResources.current