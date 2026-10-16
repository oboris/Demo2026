package ua.edu.cdu.boris.demo2026

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import ua.edu.cdu.boris.demo2026.model.Author
import ua.edu.cdu.boris.demo2026.model.Book
import ua.edu.cdu.boris.demo2026.model.HorizontalList
import ua.edu.cdu.boris.demo2026.model.MyListable

class AppViewModel : ViewModel() {

//    private val _myHomeText = MutableStateFlow("qqqq")
//    val myHomeText: StateFlow<String> = _myHomeText.asStateFlow()

    val myHomeText: StateFlow<String>
        field = MutableStateFlow("qqqq")

    private val _myFavoritesText = MutableStateFlow("wwww")
    val myFavoritesText: StateFlow<String> = _myFavoritesText.asStateFlow()

    fun updateHomeText(newText: String) {
        myHomeText.value = newText
    }

    fun updateFavoritesText(newText: String) {
        _myFavoritesText.value = newText
    }

    val myAuthorList: List<Author> = listOf(
        Author("Author 1", "11/11/2022", id = 1),
        Author("Author 2", "11/11/2022", id = 1),
        Author("Author 3", "11/11/2022", id = 1),
        Author("Author 4", "11/11/2022", id = 1),
        Author("Author 5", "11/11/2022", id = 1),
    )
    val myAppList: List<MyListable> = listOf(
        Book(
            author = null,
            pages = 200,
            title = "Book 1",
            id = 0
        ),
        Book("Book 2", 300, myAuthorList[0], id = 1),
        Book("Book 3", 30, myAuthorList[1], id = 1),
        Book("Book 4", 80, myAuthorList[2], id = 1),
        HorizontalList(myAuthorList, 100),
        Book("Book 2", 300, myAuthorList[3], id = 1),
        Book("Book 3", 30, myAuthorList[4], id = 1),
        Book("Book 4", 80, myAuthorList[0], id = 1),
        Book("Book 2", 300, myAuthorList[3], id = 1),
        myAuthorList[0],
        Book("Book 3", 30, myAuthorList[0], id = 1),
        Book("Book 4", 80, myAuthorList[2], id = 1),
        Book("Book 2", 300, myAuthorList[0], id = 1),
        Book("Book 3", 30, myAuthorList[1], id = 1),
        Book("Book 4", 80, myAuthorList[0], id = 1),
        Book("Book 2", 300, myAuthorList[4], id = 1),
        myAuthorList[1],
        Book("Book 3", 30, myAuthorList[2], id = 1),
        Book("Book 4", 80, myAuthorList[0], id = 1),
        Author("Author 1", "11/11/2022", id = 1),
        Author("Author 2", "11/11/2022", id = 1),
        Author("Author 3", "11/11/2022", id = 1),
        Author("Author 4", "11/11/2022", id = 1),
        Author("Author 5", "11/11/2022", id = 1),
    )


    //    private val _appLiveList = MutableLiveData(myAppList)
    val appLiveList: LiveData<List<MyListable>>
        field = MutableLiveData(myAppList)
}