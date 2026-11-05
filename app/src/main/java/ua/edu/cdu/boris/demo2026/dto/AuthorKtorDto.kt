package ua.edu.cdu.boris.demo2026.dto

import com.google.gson.annotations.SerializedName

data class AuthorKtorDto(
    @SerializedName("first_name")
    val firstName: String,

    @SerializedName("last_name")
    val lastName: String,

    @SerializedName("birth_date")
    val birthday: String,

    //@SerializedName("guid")
    val guid: String
)