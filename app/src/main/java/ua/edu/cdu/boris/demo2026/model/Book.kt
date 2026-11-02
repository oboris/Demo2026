package ua.edu.cdu.boris.demo2026.model

import kotlinx.serialization.Serializable

@Serializable
data class Book(
    val title: String,
    val pages: Int,
    val author: Author?,
    override val id: Int
): MyListable
