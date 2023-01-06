package no.nav.navno.api.config

import io.ktor.client.HttpClient
import io.ktor.client.engine.apache.Apache
import io.ktor.client.plugins.HttpRequestRetry
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json

object HttpClientBuilder {

    fun build(): HttpClient {
        return HttpClient(Apache) {
            install(ContentNegotiation) {
                json(jsonConfig())
            }
            install(HttpRequestRetry) {
                retryOnExceptionOrServerErrors(maxRetries = 3)
            }
            install(HttpTimeout) {
                requestTimeoutMillis = 3000
            }
            expectSuccess = false
        }
    }

}
