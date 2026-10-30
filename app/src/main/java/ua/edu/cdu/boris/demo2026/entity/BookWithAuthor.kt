package ua.edu.cdu.boris.demo2026.entity

import androidx.room3.Embedded
import androidx.room3.Relation

data class BookWithAuthor(
    @Embedded val bookEntity: BookEntity,
    @Relation(
//        entity = AuthorEntity::class,
        parentColumns = ["author_id"],
        entityColumns = ["author_id"]
    )
    val authorEntity: AuthorEntity?
)