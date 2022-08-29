package no.nav.navno.api.config

import io.ktor.client.HttpClient
import no.nav.navno.api.meldekort.MeldekortConsumer
import no.nav.navno.api.meldekort.MeldekortService
import no.nav.navno.api.tokenx.TokenxService

class TestApplicationContext(
    httpClient: HttpClient,
    tokenxService: TokenxService = TokenxService(DummyTokendingsService())
) {
    val environment = Environment(
        corsAllowedOrigins = "",
        meldekortTargetApp = "",
        meldekortUrl = "https://meldekort",
    )

    val meldekortConsumer = MeldekortConsumer(httpClient, environment)
    val meldekortService = MeldekortService(tokenxService, meldekortConsumer, environment)
}