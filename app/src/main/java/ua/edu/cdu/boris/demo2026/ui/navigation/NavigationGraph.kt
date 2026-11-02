package ua.edu.cdu.boris.demo2026.ui.navigation

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable
import ua.edu.cdu.boris.demo2026.model.Author
import ua.edu.cdu.boris.demo2026.model.Book

@Serializable
sealed interface Screen : NavKey{
    @Serializable
    data object Home : Screen

    @Serializable
    data class AuthorDetails(val author: Author) : Screen
    @Serializable
    data class BookDetails(val book: Book) : Screen
}
