package ua.edu.cdu.boris.demo2026.entity

import androidx.room3.ColumnInfo
import androidx.room3.Entity
import androidx.room3.PrimaryKey

@Entity(
    tableName = "authors"
)
data class AuthorEntity (
    @ColumnInfo(
        name = "author_name"
    )
    val name: String,

    val birthday: String,

    @PrimaryKey(
        autoGenerate = true
    )
    @ColumnInfo(
        name = "author_id"
    )
    val id: Int
)
