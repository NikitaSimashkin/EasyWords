package ru.kram.easywords.dictionary.ui.decklist

import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import ru.kram.easywords.common.ui.backgroundButtonColor
import ru.kram.easywords.ui.theme.colors
import ru.kram.easywords.ui.theme.customShapes
import ru.kram.easywords.ui.theme.typography

@Composable
fun AddDeckButton(
	text: String,
	modifier: Modifier = Modifier,
	textModifier: Modifier = Modifier,
	onClick: () -> Unit = {}
) {

	Button(
		onClick = onClick,
		modifier = modifier,
		shape = customShapes.circleShape,
		colors = backgroundButtonColor(color = colors.primary)
	) {

		Text(
			text = text,
			modifier = textModifier,
			style = typography.bodyMedium,
			color = colors.onPrimary
		)
	}

}

@Preview
@Composable
fun AddDeckButtonPreview() {
	AddDeckButton(text = "Add")
}