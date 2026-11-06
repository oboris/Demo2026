package ua.edu.cdu.boris.demo2026.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BookKtorDto(
    val title: String,

    @SerialName("page_number")
    val pages: Int,

    val author: AuthorKtorDto,

    val guid: String
)