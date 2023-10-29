package ru.kram.easywords.navigation

sealed class Screen(val route: String) {

	data object Main : Screen(route = "main")

	data object Dictionary : Screen(route = "dictionary")

	data object Settings : Screen(route = "settings")
}