package ua.edu.cdu.boris.demo2026.util

import ua.edu.cdu.boris.demo2026.entity.AuthorEntity
import ua.edu.cdu.boris.demo2026.entity.BookEntity
import ua.edu.cdu.boris.demo2026.entity.BookWithAuthor
import ua.edu.cdu.boris.demo2026.model.Author
import ua.edu.cdu.boris.demo2026.model.Book

fun Author.toEntity() = AuthorEntity(
    name = this.name,
    birthday = this.birthday,
    id = this.id
)

fun Book.toEntity() = BookEntity(
    title = this.title,
    pages = this.pages,
    authorId = this.author?.id,
    id = this.id
)

fun AuthorEntity.toDomain() = Author(
    name = this.name,
    birthday = this.birthday,
    id = this.id
)

//    fun BookEntity.toDomain() = Book(
//        title = this.title,
//        pages = this.pages,
//        author = null,
//        id = this.id
//    )

fun BookWithAuthor.toDomain() = Book(
    title = this.bookEntity.title,
    pages = this.bookEntity.pages,
    author = this.authorEntity?.toDomain(),
    id = this.bookEntity.id
)