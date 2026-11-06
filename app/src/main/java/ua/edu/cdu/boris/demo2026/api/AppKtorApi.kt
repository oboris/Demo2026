package ua.edu.cdu.boris.demo2026.api

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import ua.edu.cdu.boris.demo2026.dto.BookKtorDto

class AppKtorApi(private val httpClient: HttpClient) {

    suspend fun getBooksWithAuthors(
        numAuthors: Int,
        numBooks: Int
    ): Result<List<BookKtorDto>> {
        return runCatching {
            val response: List<BookKtorDto> = httpClient.get {
                parameter("numauthors", numAuthors)
                parameter("numbooks", numBooks)
            }.body()
            response
        }
    }
}