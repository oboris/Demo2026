package ua.edu.cdu.boris.demo2026

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import ua.edu.cdu.boris.demo2026.model.Author
import ua.edu.cdu.boris.demo2026.model.Book
import ua.edu.cdu.boris.demo2026.model.MyListable
import ua.edu.cdu.boris.demo2026.repository.AppRepository

class AppViewModel(application: Application) : AndroidViewModel(application) {

//    private val appRepository: AppRepository =
//        AppRepositoryImpl(
//            AppDataBase.getDatabase(
//                getApplication<Application>().applicationContext
//            ).appDao()
//        )

    private val appRepository: AppRepository = (application as AppDemo2026).appRepository

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

    val appLiveList: LiveData<List<MyListable>>
        field = MutableLiveData(emptyList())
}