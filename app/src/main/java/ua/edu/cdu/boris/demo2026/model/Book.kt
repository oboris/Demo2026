package ua.edu.cdu.boris.demo2026.model

data class Book(
    val title: String,
    val pages: Int,
    val author: Author?,
    override val id: Int
): MyListable
