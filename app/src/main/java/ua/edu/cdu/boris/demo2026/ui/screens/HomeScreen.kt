package ua.edu.cdu.boris.demo2026.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import ua.edu.cdu.boris.demo2026.AppViewModel
import ua.edu.cdu.boris.demo2026.model.Author
import ua.edu.cdu.boris.demo2026.model.Book
import ua.edu.cdu.boris.demo2026.model.HorizontalList

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
                .background(color = Color.Green),
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            items(
                items = appList,
//                key = {item -> item.id}
            ) { item ->
                when (item) {
                    is Author -> AuthorCard(item)
                    is Book -> BookCard(item)
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
fun HorizontalItem(horizontalList: HorizontalList) {
    LazyRow() {
        items(items = horizontalList.authorList) {
            Column() {
                Text(
                    modifier = Modifier.background(color = Color.Yellow),
                    text = it.name
                )
                Spacer(Modifier.size(10.dp))
                Text(
                    modifier = Modifier.background(color = Color.White),
                    text = it.birthday
                )
            }
        }
    }

}

@Composable
fun AuthorCard(author: Author) {
    Row(modifier = Modifier.fillMaxWidth()) {
        Text(
            modifier = Modifier.background(color = Color.Yellow),
            text = author.name
        )
        Spacer(Modifier.size(10.dp))
        Text(
            modifier = Modifier.background(color = Color.White),
            text = author.birthday
        )
    }
}

@Composable
fun BookCard(book: Book) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color.Red),
    ) {
        Text(
            modifier = Modifier.background(color = Color.Magenta), text = book.title
        )
        Row(modifier = Modifier.fillMaxWidth()) {
            Text(
                modifier = Modifier.background(color = Color.Cyan),
                text = book.author?.name ?: "no author"
            )
            Spacer(Modifier.size(10.dp))
            Text(
                modifier = Modifier.background(color = Color.Blue), text = book.pages.toString()
            )
        }
    }
}
