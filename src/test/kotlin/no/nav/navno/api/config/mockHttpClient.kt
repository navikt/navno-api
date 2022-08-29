package no.nav.navno.api.config

import io.ktor.client.HttpClient
import io.ktor.client.engine.mock.MockEngine
import io.ktor.client.engine.mock.respondError
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.http.HttpStatusCode
import io.ktor.serialization.kotlinx.json.json
import no.nav.navno.api.config.mocks.mockMeldekort


fun setupMockedClient(meldekortStatus: HttpStatusCode = HttpStatusCode.OK): HttpClient {
    val MELDEKORT = "meldekort"

    return HttpClient(MockEngine) {
        engine {
            addHandler { request ->
                when (request.url.host) {
                    MELDEKORT -> {
                        mockMeldekort(meldekortStatus)
                    }
                    else -> {
                        respondError(HttpStatusCode.NotFound)
                    }
                }
            }

        }
        install(ContentNegotiation) {
            json(jsonConfig())
        }
        install(HttpTimeout)
        expectSuccess = false
    }
}

fun readJson(name: String): String {
    return object {}.javaClass.getResource(name)?.readText()!!
}