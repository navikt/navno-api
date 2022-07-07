package no.nav.navno.api.config

import no.nav.navno.api.health.HealthService
import no.nav.navno.api.meldekort.MeldekortConsumer
import no.nav.navno.api.meldekort.MeldekortService
import no.nav.navno.api.tokenx.TokenxService
import no.nav.tms.token.support.tokendings.exchange.TokendingsServiceBuilder

class ApplicationContext {

    val tokendingsService = TokendingsServiceBuilder.buildTokendingsService()

    val httpClient = HttpClientBuilder.build()
    val healthService = HealthService(this)

    val environment = Environment()
    val tokenxService = TokenxService(tokendingsService)

    val meldekortConsumer = MeldekortConsumer(httpClient, environment)
    val meldekortService = MeldekortService(tokenxService, meldekortConsumer, environment)

}
