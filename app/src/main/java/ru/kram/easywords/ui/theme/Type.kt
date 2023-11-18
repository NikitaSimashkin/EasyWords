package ru.kram.easywords.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp

// Set of Material typography styles to start with
val Typography = Typography().run {
	copy(
		bodyLarge = bodyLarge.copy(
			platformStyle = PlatformTextStyle(includeFontPadding = false),

		),
		bodyMedium = bodyMedium.copy(
			platformStyle = PlatformTextStyle(includeFontPadding = false)
		),
		/* Other default text styles to override
		titleLarge = TextStyle(
			fontFamily = FontFamily.Default,
			fontWeight = FontWeight.Normal,
			fontSize = 22.sp,
			lineHeight = 28.sp,
			letterSpacing = 0.sp
		),
		labelSmall = TextStyle(
			fontFamily = FontFamily.Default,
			fontWeight = FontWeight.Medium,
			fontSize = 11.sp,
			lineHeight = 16.sp,
			letterSpacing = 0.5.sp
		)
		*/
	)
}
