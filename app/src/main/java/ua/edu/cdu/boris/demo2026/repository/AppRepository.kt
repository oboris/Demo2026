package ua.edu.cdu.boris.demo2026.repository

import ua.edu.cdu.boris.demo2026.dto.BookRetrofitDto
import ua.edu.cdu.boris.demo2026.model.Author
import ua.edu.cdu.boris.demo2026.model.Book
import ua.edu.cdu.boris.demo2026.model.MyListable

interface AppRepository {
    suspend fun addAuthorsToDb(authors: List<Author>): List<Long>

    suspend fun addBooksToDb(books: List<Book>)

    suspend fun getBooksFromDb(): List<Book>

    suspend fun getAuthorsFromDb(): List<Author>

    suspend fun getAllDataFromDb(): List<MyListable>

    suspend fun updateAuthorInDb(author: Author)

    suspend fun updateBookInDb(book: Book)

    suspend fun deleteBook(book: Book)

    suspend fun deleteAuthor(author: Author)

    fun getAllLocalData(): List<MyListable>

    fun getLocalAuthors(): List<Author>

    fun getLocalBooks(): List<Book>

    suspend fun clearAllData()

    suspend fun loadBooksFromApiRetrofit(authorNumbers: Int, bookNumbers: Int): List<BookRetrofitDto>

    suspend fun loadBooksFromApiKtor(authorNumbers: Int, bookNumbers: Int): List<BookRetrofitDto>
}