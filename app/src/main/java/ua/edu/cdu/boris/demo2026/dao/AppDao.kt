package ua.edu.cdu.boris.demo2026.dao

import androidx.room3.Dao
import androidx.room3.Delete
import androidx.room3.Insert
import androidx.room3.OnConflictStrategy
import androidx.room3.Query
import ua.edu.cdu.boris.demo2026.entity.AuthorEntity
import ua.edu.cdu.boris.demo2026.entity.BookEntity
import ua.edu.cdu.boris.demo2026.entity.BookWithAuthor

@Dao
interface AppDao {
    //Author DAO
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAuthor(authorEntity: AuthorEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllAuthors(authorsEntity: List<AuthorEntity>)

    @Delete
    suspend fun delAuthor(authorEntity: AuthorEntity)

    @Delete
    suspend fun delAuthorAll(authorsEntity: List<AuthorEntity>)

    @Query("DELETE FROM authors")
    suspend fun delAllAuthors()

    @Query("SELECT * FROM authors")
    suspend fun getAuthors() : List<AuthorEntity>

    //Book DAO
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBook(bookEntity: BookEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllBooks(booksEntity: List<BookEntity>)

    @Delete
    suspend fun delBook(bookEntity: BookEntity)

    @Query("DELETE FROM books")
    suspend fun delAllBooks()

    @Query("SELECT * FROM books")
    suspend fun getBooks() : List<BookWithAuthor>
}