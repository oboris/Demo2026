package ua.edu.cdu.boris.demo2026.navigation

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

@Serializable
sealed interface Screen : NavKey

@Serializable
data object Home : Screen

@Serializable
data class Details(val itemId: String) : Screen

class NavigationGraph {
}