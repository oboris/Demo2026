package ua.edu.cdu.boris.demo2026

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import ua.edu.cdu.boris.demo2026.model.MyListable
import ua.edu.cdu.boris.demo2026.repository.AppRepository
import ua.edu.cdu.boris.demo2026.repository.AppRepositoryImpl

class AppViewModel(appRepository: AppRepository = AppRepositoryImpl()) : ViewModel() {

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

    val appLiveList: LiveData<List<MyListable>>
        field = MutableLiveData(appRepository.getAllData())
}