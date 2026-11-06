package ua.edu.cdu.boris.demo2026.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class AuthorKtorDto(
    @SerialName("first_name")
    val firstName: String,

    @SerialName("last_name")
    val lastName: String,

    @SerialName("birth_date")
    val birthday: String,

    //@SerialName("guid")
    val guid: String
)