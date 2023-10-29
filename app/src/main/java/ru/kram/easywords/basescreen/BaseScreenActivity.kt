package ru.kram.easywords.basescreen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
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
import ru.kram.easywords.basescreen.ui.BaseScreen
import ru.kram.easywords.common.icon.IconResources
import ru.kram.easywords.common.icon.LocalIconResources
import ru.kram.easywords.common.icon.icons
import ru.kram.easywords.dictionary.DictionaryViewModel
import ru.kram.easywords.dictionary.ui.DictionaryScreen
import ru.kram.easywords.navigation.Screen
import ru.kram.easywords.ui.theme.EasyWordsTheme

class BaseScreenActivity : ComponentActivity() {

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContent {
			EasyWordsTheme {
				CompositionLocalProvider(
					LocalIconResources provides IconResources(this)
				) {
					val navController = rememberNavController()

					val icons = icons
					val viewModel: BaseScreenViewModel = viewModel {
						BaseScreenViewModel(this@BaseScreenActivity, icons, navController)
					}
					val baseScreenData = viewModel.baseScreenData.collectAsState()

					BaseScreen(baseScreenData.value) {
						SetupNavigation(navController)
					}
				}
			}
		}
	}

	@Composable
	fun SetupNavigation(navController: NavHostController) {
		val dictionaryViewModel = viewModel<DictionaryViewModel>()
		val dictionaryData = dictionaryViewModel.dictionaryScreenData.collectAsState()

		NavHost(navController = navController, startDestination = Screen.Main.route) {
			composable(Screen.Main.route) {
				Box(modifier = Modifier.fillMaxSize().background(Color.Red)) {

				}
			}
			composable(Screen.Dictionary.route) {
				DictionaryScreen(dictionaryData.value)
			}
			composable(Screen.Settings.route) {
				Box(modifier = Modifier.fillMaxSize().background(Color.Green)) {

				}
			}
		}
	}
}