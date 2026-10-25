package ua.edu.cdu.boris.demo2026.repository

import ua.edu.cdu.boris.demo2026.entity.AuthorEntity
import ua.edu.cdu.boris.demo2026.model.MyListable

interface AppRepository {
    suspend fun setAllAuthors()
    fun getAllData(): List<MyListable>
}