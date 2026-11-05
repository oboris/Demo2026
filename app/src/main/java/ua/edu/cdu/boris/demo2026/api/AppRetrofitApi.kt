package ua.edu.cdu.boris.demo2026.api

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import ua.edu.cdu.boris.demo2026.dto.BookRetrofitDto

interface AppRetrofitApi {

    @GET("bookswithauthors.php")
    suspend fun getBooksWithAuthors(
        @Query("numauthors") numAuthors: Int,
        @Query("numbooks") numBooks: Int
    ): Response<List<BookRetrofitDto>>
}