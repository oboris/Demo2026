package ua.edu.cdu.boris.demo2026.entity

import androidx.room3.ColumnInfo
import androidx.room3.Entity
import androidx.room3.ForeignKey
import androidx.room3.PrimaryKey

@Entity(
    tableName = "books",
    foreignKeys = [
        ForeignKey(
            entity = AuthorEntity::class,
            parentColumns = arrayOf("author_id"),
            childColumns = arrayOf("author_id"),
            onDelete = ForeignKey.CASCADE,
            onUpdate = ForeignKey.CASCADE
        )
    ]
)
data class BookEntity(
    @ColumnInfo(
        name = "book_title"
    )
    val title: String,

    val pages: Int,

    @ColumnInfo(
        name = "author_id",
        index = true
    )
    val authorId: Int,

    @PrimaryKey(
        autoGenerate = true
    )
    @ColumnInfo(
        name = "book_id"
    )
    val id: Int
)
