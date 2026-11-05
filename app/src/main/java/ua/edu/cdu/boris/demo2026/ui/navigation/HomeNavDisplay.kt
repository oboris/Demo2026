package ua.edu.cdu.boris.demo2026.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import ua.edu.cdu.boris.demo2026.AppViewModel
import ua.edu.cdu.boris.demo2026.R
import ua.edu.cdu.boris.demo2026.ui.screens.AuthorDetailScreen
import ua.edu.cdu.boris.demo2026.ui.screens.BookDetailScreen
import ua.edu.cdu.boris.demo2026.ui.screens.HomeScreen

@Composable
fun HomeNavDisplay(
    modifier: Modifier,
    appViewModel: AppViewModel = viewModel()
) {
//    val backStack = rememberNavBackStack(Screen.Home)
    val backStack by appViewModel.homeBackStack.collectAsState()

    NavDisplay(
        backStack = backStack,
//        onBack = { backStack.removeLastOrNull() },
        onBack = { appViewModel.navigateBack() },
        entryProvider = entryProvider {
            entry<Screen.Home> {
                HomeScreen(
                    modifier = modifier,
                    name = stringResource(R.string.greeting_name),
                    onAuthorCardClick = { author ->
//                        backStack.add(Screen.AuthorDetails(author))
                        appViewModel.navigateTo(Screen.AuthorDetails(author))
                    },
                    onBookCardClick = { book ->
//                        backStack.add(Screen.BookDetails(book))
                        appViewModel.navigateTo(Screen.BookDetails(book))
                    }
                )
            }

            entry<Screen.AuthorDetails> {
                AuthorDetailScreen(
                    author = it.author,
                    onBackClick = {
//                        backStack.removeLastOrNull()
                        appViewModel.navigateBack()
                    }
                )
            }

            entry<Screen.BookDetails> {
                BookDetailScreen(
                    book = it.book,
                    onBackClick = {
//                        backStack.removeLastOrNull()
                        appViewModel.navigateBack()
                    },
                    onAuthorCardClick = { author ->
//                        backStack.add(Screen.AuthorDetails(author))
                        appViewModel.navigateTo(Screen.AuthorDetails(author))
                    },
                )
            }
        }
    )
}
