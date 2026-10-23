package ua.edu.cdu.boris.demo2026.repository

import ua.edu.cdu.boris.demo2026.model.MyListable

interface AppRepository {
    fun getAllData(): List<MyListable>
}