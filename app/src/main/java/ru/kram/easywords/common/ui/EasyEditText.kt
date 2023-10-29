package ru.kram.easywords.common.ui

import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusState
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import ru.kram.easywords.common.image.ImageVectorWrapper
import ru.kram.easywords.ui.theme.customShapes
import ru.kram.easywords.ui.theme.dimens

@Composable
fun EasyEditText(
	value: String,
	onValueChange: (String) -> Unit,
	textStyle: TextStyle,
	leadingIcon: ImageVectorWrapper? = null,
	modifier: Modifier = Modifier,
	iconModifier: Modifier = Modifier,
	hintModifier: Modifier = Modifier,
	hint: String = "",
	hintTextStyle: TextStyle = TextStyle.Default,
	colors: TextFieldColors = OutlinedTextFieldDefaults.colors(),
	onFocusChanged: (FocusState) -> Unit = {}
) {
	val nullableLeadingIcon: @Composable (() -> Unit)? = if (leadingIcon != null) {
		{
			Icon(
				modifier = iconModifier,
				imageVector = leadingIcon.imageVector,
				contentDescription = leadingIcon.contentDescription
			)
		}
	} else {
		null
	}

	OutlinedTextField(
		leadingIcon = nullableLeadingIcon,
		modifier = modifier.onFocusChanged(onFocusChanged),
		value = value,
		onValueChange = onValueChange,
		placeholder = {
			Text(
				text = hint,
				style = hintTextStyle,
				modifier = hintModifier
			)
		},
		textStyle = textStyle,
		shape = customShapes.baseRoundCornerShape,
		colors = colors
	)
}

@Preview
@Composable
fun EasyEditTextPreview() {
	EasyEditText(
		value = "Hello world",
		onValueChange = {},
		textStyle = TextStyle.Default,
		leadingIcon = ImageVectorWrapper(
			imageVector = Icons.Outlined.Search,
			contentDescription = "Search"
		),
		iconModifier = Modifier.size(dimens.baseIconSize)
	)
}