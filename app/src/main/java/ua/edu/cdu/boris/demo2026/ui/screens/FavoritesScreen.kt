package ua.edu.cdu.boris.demo2026.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import ua.edu.cdu.boris.demo2026.AppViewModel

@Composable
fun FavoritesScreen(
    name: String,
    modifier: Modifier = Modifier,
    appViewModel: AppViewModel = viewModel()
) {
    val myText by appViewModel.myFavoritesText.collectAsStateWithLifecycle()

    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Hello in Favorites $name! $myText",
        )

        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 15.dp),
            onClick = { appViewModel.updateFavoritesText("456") },
        ) {
            Text(
                text = "Favorites Button",
            )
        }
    }
}