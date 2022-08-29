package no.nav.navno.api.config.mocks

import io.ktor.client.engine.mock.MockRequestHandleScope
import io.ktor.client.engine.mock.respond
import io.ktor.client.engine.mock.respondError
import io.ktor.http.ContentType
import io.ktor.http.HttpHeaders
import io.ktor.http.HttpStatusCode
import io.ktor.http.headersOf
import io.ktor.http.isSuccess
import no.nav.navno.api.config.readJson


fun MockRequestHandleScope.mockMeldekort(status: HttpStatusCode) =
    if (status.isSuccess()) {
        respond(
            readJson("/json/meldekortstatus.json"),
            headers = headersOf(HttpHeaders.ContentType, ContentType.Application.Json.toString())
        )
    } else {
        respondError(status)
    }