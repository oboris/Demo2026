package ua.edu.cdu.boris.demo2026

import android.app.Application
import ua.edu.cdu.boris.demo2026.db.AppDataBase
import ua.edu.cdu.boris.demo2026.repository.AppRepositoryImpl

class AppDemo2026 : Application() {
    private val appDataBase by lazy { AppDataBase.getDatabase(this) }
    val appRepository by lazy { AppRepositoryImpl(appDataBase.appDao()) }
}