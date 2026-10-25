package ua.edu.cdu.boris.demo2026.dao

import androidx.room3.Dao
import androidx.room3.Delete
import androidx.room3.Insert
import androidx.room3.OnConflictStrategy
import androidx.room3.Query
import ua.edu.cdu.boris.demo2026.entity.AuthorEntity

@Dao
interface AppDao {
    @Insert(
        onConflict = OnConflictStrategy.REPLACE
    )
    suspend fun insertAuthor(author: AuthorEntity)

    @Insert
    suspend fun insertAllAuthors(authors: List<AuthorEntity>)

    @Delete
    suspend fun delAuthor(author: AuthorEntity)

    @Delete
    suspend fun delAuthorAll(authors: List<AuthorEntity>)

    @Query("DELETE FROM authors")
    suspend fun delAllAuthors()
}