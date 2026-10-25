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
import ua.edu.cdu.boris.demo2026.db.AppDataBase
import ua.edu.cdu.boris.demo2026.model.MyListable
import ua.edu.cdu.boris.demo2026.repository.AppRepository
import ua.edu.cdu.boris.demo2026.repository.AppRepositoryImpl

class AppViewModel(private val application: Application) : AndroidViewModel(application) {

    private val appRepository: AppRepository =
        AppRepositoryImpl(
            AppDataBase.getDatabase(
                getApplication<Application>().applicationContext
            ).appDao()
        )

    private val appRepository1: AppRepository = (application as AppDemo2026).appRepository

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

    fun addAuthors() {
        viewModelScope.launch {
            appRepository.setAllAuthors()
            appRepository1.setAllAuthors()
        }
    }

    val appLiveList: LiveData<List<MyListable>>
        field = MutableLiveData(appRepository.getAllData())
}