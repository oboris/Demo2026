package ua.edu.cdu.boris.demo2026.repository

import ua.edu.cdu.boris.demo2026.model.Author
import ua.edu.cdu.boris.demo2026.model.Book
import ua.edu.cdu.boris.demo2026.model.MyListable

interface AppRepository {
    suspend fun addAuthorsToDb(authors: List<Author>)

    suspend fun addBooksToDb(books: List<Book>)

    suspend fun getBooksFromDb(): List<Book>

    suspend fun getAuthorsFromDb(): List<Author>

    suspend fun getAllDataFromDb(): List<MyListable>

    suspend fun deleteBook(book: Book)

    suspend fun deleteAuthor(author: Author)

    fun getAllLocalData(): List<MyListable>

    fun getLocalAuthors(): List<Author>

    fun getLocalBooks(): List<Book>

    suspend fun clearAllData()
}