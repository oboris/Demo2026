package ua.edu.cdu.boris.demo2026

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.NavKey
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import ua.edu.cdu.boris.demo2026.entity.BookEntity
import ua.edu.cdu.boris.demo2026.model.Author
import ua.edu.cdu.boris.demo2026.model.Book
import ua.edu.cdu.boris.demo2026.model.MyListable
import ua.edu.cdu.boris.demo2026.repository.AppRepository
import ua.edu.cdu.boris.demo2026.ui.navigation.Screen
import ua.edu.cdu.boris.demo2026.util.toEntity

class AppViewModel(application: Application) : AndroidViewModel(application) {

//    private val appRepository: AppRepository =
//        AppRepositoryImpl(
//            AppDataBase.getDatabase(
//                getApplication<Application>().applicationContext
//            ).appDao()
//        )

    private val appRepository: AppRepository = (application as AppDemo2026).appRepository

    val homeBackStack: StateFlow<List<Screen>>
        field = MutableStateFlow<List<Screen>>(listOf(Screen.Home))

    fun navigateTo(screen: Screen) {
        homeBackStack.update { currentStack ->
            currentStack + screen
        }
    }

    fun navigateBack(): Boolean {
        if (homeBackStack.value.size > 1) {
            homeBackStack.update { currentStack ->
                currentStack.dropLast(1)
            }
            return true
        }
        return false
    }

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

    fun addAuthorsToDb() {
        viewModelScope.launch {
            appRepository.addAuthorsToDb(appRepository.getLocalAuthors())
            getAllData()
        }
    }

    fun addBooksToDb() {
        viewModelScope.launch {
            appRepository.addBooksToDb(appRepository.getLocalBooks())
            getAllData()
        }
    }

    suspend fun getAllData() {
        appLiveList.postValue(appRepository.getAllDataFromDb())
    }

    fun clearDataInToDb() {
        viewModelScope.launch {
            appRepository.clearAllData()
            getAllData()
        }
    }

    fun deleteBook(book: Book) {
        viewModelScope.launch {
            appRepository.deleteBook(book)
            getAllData()
        }
    }

    fun deleteAuthor(author: Author) {
        viewModelScope.launch {
            appRepository.deleteAuthor(author)
            getAllData()
        }
    }

    fun addAllLocalData() {
        viewModelScope.launch {
            appRepository.addAuthorsToDb(appRepository.getLocalAuthors())
            appRepository.addBooksToDb(appRepository.getLocalBooks())
            getAllData()
        }
    }

    fun loadAllDataToDb() {
        viewModelScope.launch {
            val booksFromApi = appRepository.loadBooksFromApi(4, 20)
            val authors = booksFromApi.map { it.author }.distinctBy { it.guid }
            val insertIds = appRepository.addAuthorsToDb(authors.map { it.toEntity() })
            val guidToLocalAuthorId = authors.map { it.guid }.zip(insertIds).toMap()
            val bookEntities = booksFromApi.map { dto ->
                BookEntity(
                    title = dto.title,
                    pages = dto.pages,
                    authorId = guidToLocalAuthorId.getValue(dto.author.guid)
                )
            }
            appRepository.addBooksToDb(bookEntities)
            getAllData()
        }
    }

    val appLiveList: LiveData<List<MyListable>>
        field = MutableLiveData(emptyList())
}