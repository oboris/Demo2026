package ua.edu.cdu.boris.demo2026.dto

import com.google.gson.annotations.SerializedName

data class BookRetrofitDto(
    val title: String,

    @SerializedName("page_number")
    val pages: Int,

    val author: AuthorRetrofitDto,

    val guid: String
)