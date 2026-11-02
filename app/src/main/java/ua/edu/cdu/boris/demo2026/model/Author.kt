package ua.edu.cdu.boris.demo2026.model

import kotlinx.serialization.Serializable

@Serializable
data class Author (
    val name: String,
    val birthday: String,
    override val id: Int
): MyListable
