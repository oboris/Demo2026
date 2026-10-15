package ua.edu.cdu.boris.demo2026.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import ua.edu.cdu.boris.demo2026.AppViewModel

@Composable
fun HomeScreen(name: String,
               modifier: Modifier,
               appViewModel: AppViewModel = viewModel()
) {
    val myText by appViewModel.myHomeText.collectAsStateWithLifecycle()
    val appList by appViewModel.appLiveList.observeAsState()
    Column(modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = "Hello in Home $name! $myText",
        )
        LazyColumn() {
            items(items =appList){
                Text(it.)
            }
        }
        Button(
            modifier = Modifier.fillMaxWidth().padding(horizontal = 15.dp),
            onClick = { appViewModel.updateHomeText("123") },
        ) {
            Text(
                text = "Home Button",
            )
        }
    }
}
