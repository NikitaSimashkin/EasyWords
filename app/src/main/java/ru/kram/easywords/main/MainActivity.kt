package ru.kram.easywords.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ru.kram.easywords.main.ui.MainScreen
import ru.kram.easywords.common.icon.IconResources
import ru.kram.easywords.common.icon.LocalIconResources
import ru.kram.easywords.dictionary.DictionaryViewModel
import ru.kram.easywords.dictionary.ui.DictionaryScreen
import ru.kram.easywords.main.navigation.BottomNavScreen
import ru.kram.easywords.ui.theme.EasyWordsTheme
import ru.kram.easywords.ui.theme.colors
import ru.kram.easywords.translator.Translator

class MainActivity : ComponentActivity() {

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContent {
			EasyWordsTheme {
				CompositionLocalProvider(
					LocalIconResources provides IconResources(this, colors.onPrimaryContainer, colors.onPrimary)
				) {
					val navController = rememberNavController()
					val viewModel: MainViewModel = viewModel { MainViewModel(navController) }
					MainScreen(viewModel) {
						SetupNavigation(navController)
					}
				}
			}
		}
		Translator().translate()
	}

	@Composable
	fun SetupNavigation(navController: NavHostController) {
		val dictionaryViewModel = viewModel {  DictionaryViewModel(this@MainActivity) }
		val dictionaryData = dictionaryViewModel.dictionaryScreenUiState.collectAsState()

		NavHost(
			navController = navController,
			startDestination = BottomNavScreen.Learn.route,
			enterTransition = { EnterTransition.None },
			exitTransition = { ExitTransition.None },
			popEnterTransition = { EnterTransition.None },
			popExitTransition = { ExitTransition.None },
		) {
			composable(
				BottomNavScreen.Learn.route,
				enterTransition = { EnterTransition.None },
				exitTransition = { ExitTransition.None },
				popEnterTransition = { EnterTransition.None },
				popExitTransition = { ExitTransition.None },
			) {
				Box(modifier = Modifier
					.fillMaxSize()
					.background(Color.Red)) {

				}
			}

			composable(
				BottomNavScreen.Dictionary.route,
				enterTransition = { EnterTransition.None },
				exitTransition = { ExitTransition.None },
				popEnterTransition = { EnterTransition.None },
				popExitTransition = { ExitTransition.None },
			) {
				DictionaryScreen(dictionaryData.value)
			}

			composable(
				BottomNavScreen.Settings.route,
				enterTransition = { EnterTransition.None },
				exitTransition = { ExitTransition.None },
				popEnterTransition = { EnterTransition.None },
				popExitTransition = { ExitTransition.None },
			) {
				Box(modifier = Modifier
					.fillMaxSize()
					.background(Color.Green)) {

				}
			}
		}
	}
}