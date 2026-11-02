package ua.edu.cdu.boris.demo2026.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import ua.edu.cdu.boris.demo2026.R
import ua.edu.cdu.boris.demo2026.ui.screens.AuthorDetailScreen
import ua.edu.cdu.boris.demo2026.ui.screens.BookDetailScreen
import ua.edu.cdu.boris.demo2026.ui.screens.HomeScreen

@Composable
fun HomeNavDisplay(modifier: Modifier){
    val backStack = rememberNavBackStack(Screen.Home)

    NavDisplay(
        backStack = backStack,
        onBack = { backStack.removeLastOrNull() },
        entryProvider = entryProvider {
            entry<Screen.Home> {
                HomeScreen(
                    modifier = modifier,
                    name = stringResource(R.string.greeting_name),
                )
            }

            entry<Screen.AuthorDetails> {
                AuthorDetailScreen(it.author)
            }

            entry<Screen.BookDetails> {
                BookDetailScreen(it.book)
            }
        }
    )
}
