package ua.edu.cdu.boris.demo2026.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import ua.edu.cdu.boris.demo2026.AppViewModel
import ua.edu.cdu.boris.demo2026.model.Book
import ua.edu.cdu.boris.demo2026.ui.components.AuthorCard

@Composable
fun BookDetailScreen(
    book: Book,
    appViewModel: AppViewModel = viewModel()
){
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Column(modifier = Modifier
            .padding(innerPadding)
            .fillMaxSize()
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween) {
                Text(text = "Book Title")
                Text(text = book.title)
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween) {
                Text(text = "Pages")
                Text(text = book.pages.toString())
            }
            AuthorCard(book.author)


        }
    }
}