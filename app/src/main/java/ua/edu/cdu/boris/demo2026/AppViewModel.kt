package ua.edu.cdu.boris.demo2026

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import ua.edu.cdu.boris.demo2026.model.Book

class AppViewModel: ViewModel() {
    private val _myHomeText = MutableStateFlow("qqqq")
    val myHomeText: StateFlow<String> = _myHomeText.asStateFlow()

    private val _myFavoritesText = MutableStateFlow("wwww")
    val myFavoritesText: StateFlow<String> = _myFavoritesText.asStateFlow()

    fun updateHomeText(newText: String) {
        _myHomeText.value = newText
    }

    fun updateFavoritesText(newText: String) {
        _myFavoritesText.value = newText
    }

    val myAppList: List<Book> = listOf(
        Book(
            author = null,
            pages = 200,
            title = "Book 1",
        ),
        Book("Book 2", 300, null),
        Book("Book 3", 30, null),
        Book("Book 4", 80, null)
    )

    private val _appLiveList = MutableLiveData(myAppList)
    val  appLiveList : LiveData<List<Book>> = _appLiveList
}