package ua.edu.cdu.boris.demo2026.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import ua.edu.cdu.boris.demo2026.AppViewModel
import ua.edu.cdu.boris.demo2026.model.Author
import ua.edu.cdu.boris.demo2026.model.Book
import ua.edu.cdu.boris.demo2026.model.HorizontalList
import ua.edu.cdu.boris.demo2026.model.MyListable
import ua.edu.cdu.boris.demo2026.ui.components.AuthorCard
import ua.edu.cdu.boris.demo2026.ui.components.AuthorHorizontalCard
import ua.edu.cdu.boris.demo2026.ui.components.BookCard

@Composable
fun HomeScreen(
    name: String, modifier: Modifier, appViewModel: AppViewModel = viewModel()
) {
    val myText by appViewModel.myHomeText.collectAsStateWithLifecycle()
    val appList by appViewModel.appLiveList.observeAsState(emptyList())
    Column(
        modifier = modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Hello in Home $name! $myText",
        )
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .weight(1f)
                .background(color = MaterialTheme.colorScheme.background),
            contentPadding = PaddingValues(vertical = 8.dp), // Відступи зверху і знизу списку
            verticalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            items(
                items = appList, key = { item ->
                    "${item.id}_${
                        when (item) {
                            is Author -> item.name
                            is Book -> item.title
                            is HorizontalList -> item.hashCode()
                        }
                    }"
                }) { item ->
                when (item) {
                    is Author -> AuthorCard(author = item)
                    is Book -> BookCard(book = item)
                    is HorizontalList -> HorizontalItem(item)
                }
            }
        }
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 15.dp),
            onClick = { appViewModel.updateHomeText("123") },
        ) {
            Text(
                text = "Home Button",
            )
        }
    }
}

@Composable
fun HorizontalItem(
    horizontalList: HorizontalList,
    modifier: Modifier = Modifier,
    onAuthorClick: (Author) -> Unit = {}
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {
        LazyRow(
            contentPadding = PaddingValues(horizontal = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            items(
                items = horizontalList.authorList,
                key = { author -> "${author.id}_${author.name}" }) { author ->
                AuthorHorizontalCard(
                    author = author, onClick = { onAuthorClick(author) })
            }
        }
    }
}
