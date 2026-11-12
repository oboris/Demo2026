package ua.edu.cdu.boris.demo2026

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteScaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import ua.edu.cdu.boris.demo2026.repository.AppRepository
import ua.edu.cdu.boris.demo2026.ui.navigation.HomeNavDisplay
import ua.edu.cdu.boris.demo2026.ui.screens.FavoritesScreen
import ua.edu.cdu.boris.demo2026.ui.theme.Demo2026Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Demo2026Theme {
                Demo2026App((application as AppDemo2026).appRepository)
            }
        }
    }
}

//@PreviewScreenSizes
@Composable
fun Demo2026App(appRepository: AppRepository) {
    var currentDestination by rememberSaveable { mutableStateOf(AppDestinations.HOME) }

    NavigationSuiteScaffold(
        navigationSuiteItems = {
            AppDestinations.entries.forEach {
                item(
                    icon = {
                        Icon(
                            painterResource(it.icon),
                            contentDescription = it.label
                        )
                    },
                    label = { Text(it.label) },
                    selected = it == currentDestination,
                    onClick = { currentDestination = it }
                )
            }
        }
    ) {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            val appViewModel: AppViewModel = viewModel(
                factory = viewModelFactory {
                    initializer {
                        AppViewModel(appRepository)
                    }
                }
            )

            when (currentDestination) {
                AppDestinations.HOME -> HomeNavDisplay(
                    modifier = Modifier.padding(innerPadding),
                    appViewModel = appViewModel
                )
//                    HomeScreen(
//                    modifier = Modifier.padding(innerPadding),
//                    name = stringResource(R.string.greeting_name),
//                    )
                AppDestinations.FAVORITES -> FavoritesScreen(
                    modifier = Modifier.padding(innerPadding),
                    name = stringResource(R.string.greeting_name),
                    appViewModel = appViewModel
                )
            }

        }
    }
}

enum class AppDestinations(
    val label: String,
    val icon: Int,
) {
    HOME("Home", R.drawable.ic_home),
    FAVORITES("Favorites", R.drawable.ic_favorite),
//    PROFILE("Profile", R.drawable.ic_account_box),
}
