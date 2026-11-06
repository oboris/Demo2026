package ua.edu.cdu.boris.demo2026.api

import io.ktor.client.*
import io.ktor.client.engine.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.header
import io.ktor.http.ContentType
import io.ktor.http.contentType
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json

object AppKtorClient {
    private const val BASE_URL = "http://boris.cdu.edu.ua/api/"

    val instance: HttpClient by lazy {
        HttpClient() {
            // JSON Configuration
            install(ContentNegotiation) {
                json(Json {
                    prettyPrint = true
                    isLenient = true
                    ignoreUnknownKeys = true // Super important!
                })
            }

            // Timeout Configuration
            install(HttpTimeout) {
                requestTimeoutMillis = 15000
                connectTimeoutMillis = 15000
                socketTimeoutMillis = 15000
            }

            // Default Request Configuration
            defaultRequest {
                contentType(ContentType.Application.Json)
                url(BASE_URL)
//                header("Content-Type", "application/json")
            }

            // Retry on failure
            install(HttpRequestRetry) {
                retryOnServerErrors(maxRetries = 3)
                exponentialDelay()
            }
        }
    }
}