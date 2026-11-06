package ua.edu.cdu.boris.demo2026

import android.app.Application
import ua.edu.cdu.boris.demo2026.api.AppKtorApi
import ua.edu.cdu.boris.demo2026.api.AppKtorClient
import ua.edu.cdu.boris.demo2026.api.AppRetrofitApi
import ua.edu.cdu.boris.demo2026.api.AppRetrofitClient
import ua.edu.cdu.boris.demo2026.db.AppDataBase
import ua.edu.cdu.boris.demo2026.repository.AppRepositoryImpl

class AppDemo2026 : Application() {
    private val appDataBase by lazy { AppDataBase.getDatabase(this) }

    private val appRetrofitClient by lazy {  AppRetrofitClient.instance }

    private val appKtorClient by lazy { AppKtorClient.instance }

    val appRepository by lazy {
        AppRepositoryImpl(
            appDao = appDataBase.appDao(),
            appRetrofitApi = appRetrofitClient.create(AppRetrofitApi::class.java),
            appKtorApi = AppKtorApi(appKtorClient)
        )
    }
}