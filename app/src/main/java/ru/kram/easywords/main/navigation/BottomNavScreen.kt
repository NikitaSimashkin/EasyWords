package ru.kram.easywords.navigation

sealed class BottomNavScreen(val route: String) {

	data object Learn : BottomNavScreen(route = "learn")

	data object Dictionary : BottomNavScreen(route = "dictionary")

	data object Settings : BottomNavScreen(route = "settings")
}