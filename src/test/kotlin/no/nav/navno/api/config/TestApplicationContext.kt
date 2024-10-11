package no.nav.navno.api.config

import io.ktor.client.HttpClient
import no.nav.navno.api.meldekort.MeldekortConsumer
import no.nav.navno.api.meldekort.MeldekortService
import no.nav.tms.token.support.tokendings.exchange.TokendingsService

class TestApplicationContext(
    httpClient: HttpClient,
    tokendingsService: TokendingsService = DummyTokendingsService()
) {
    val environment = Environment(
        corsAllowedOrigins = "",
        meldekortTargetApp = "",
        meldekortUrl = "https://meldekort",
    )

    val meldekortConsumer = MeldekortConsumer(httpClient, environment)
    val meldekortService = MeldekortService(tokendingsService, meldekortConsumer, environment)
}