package ru.kram.easywords.common.ui

import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
fun backgroundButtonColor(color: Color) = ButtonDefaults.buttonColors(containerColor = color)