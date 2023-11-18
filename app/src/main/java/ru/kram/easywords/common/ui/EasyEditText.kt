package ru.kram.easywords.common.ui

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusState
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import ru.kram.easywords.common.icon.ColoredImageVectorWrapper
import ru.kram.easywords.ui.theme.colors
import ru.kram.easywords.ui.theme.customShapes
import ru.kram.easywords.ui.theme.dimens

@Composable
fun EasyEditText(
	value: String,
	onValueChange: (String) -> Unit,
	textStyle: TextStyle,
	modifier: Modifier = Modifier,
	iconModifier: Modifier = Modifier,
	hintModifier: Modifier = Modifier,
	leadingIcon: ColoredImageVectorWrapper? = null,
	hint: String = "",
	hintTextStyle: TextStyle = textStyle,
	borderColor: Color = colors.primary,
	onFocusChanged: (FocusState) -> Unit = {}
) {
	var isFocused by remember { mutableStateOf(false) }

	BasicTextField(
		modifier = modifier
			.onFocusChanged {
				isFocused = it.isFocused
				onFocusChanged(it)
			}
			.border(
				if (isFocused) dimens.textFieldBorderSizeFocused else dimens.textFieldBorderSizeUnfocused,
				borderColor,
				customShapes.baseRoundCornerShape
			)
			.padding(start = dimens.rowPaddingStart, end = dimens.rowPaddingEnd),
		value = value,
		onValueChange = onValueChange,
		decorationBox = { innerTextField ->
			Row(verticalAlignment = Alignment.CenterVertically) {
				if (leadingIcon != null) {
					Icon(
						modifier = iconModifier
							.padding(
								start = dimens.rowPaddingStart,
								end = dimens.rowPaddingEnd
							)
							.size(dimens.mediumIconSize),
						imageVector = leadingIcon.imageVector,
						contentDescription = leadingIcon.contentDescription,
						tint = leadingIcon.color
					)
				}
				Box(modifier = Modifier.padding(start = dimens.rowPaddingStart, end = dimens.rowPaddingEnd)) {
					innerTextField()
					if (value.isEmpty()) {
						Text(
							modifier = hintModifier,
							text = hint,
							style = hintTextStyle
						)
					}
				}
			}
		},
		textStyle = textStyle,
		singleLine = true,
		cursorBrush = SolidColor(borderColor)
	)
}

@Preview
@Composable
fun EasyEditTextPreview() {
	EasyEditText(
		value = "Hello world",
		onValueChange = {},
		textStyle = TextStyle.Default,
		leadingIcon = ColoredImageVectorWrapper(
			imageVector = Icons.Outlined.Search,
			contentDescription = "Search",
			color = Color.Red
		),
		iconModifier = Modifier.size(dimens.bigIconSize)
	)
}