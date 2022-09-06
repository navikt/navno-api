package no.nav.navno.api.config

import io.micrometer.prometheus.PrometheusConfig
import io.micrometer.prometheus.PrometheusMeterRegistry
import no.nav.navno.api.meldekort.MeldekortConsumer
import no.nav.navno.api.meldekort.MeldekortService
import no.nav.navno.api.tokenx.TokenxService
import no.nav.tms.token.support.tokendings.exchange.TokendingsServiceBuilder

class ApplicationContext {
    val environment = Environment()
    val httpClient = HttpClientBuilder.build()

    val appMicrometerRegistry = PrometheusMeterRegistry(PrometheusConfig.DEFAULT)

    val tokendingsService = TokendingsServiceBuilder.buildTokendingsService()
    val tokenxService = TokenxService(tokendingsService)

    val meldekortConsumer = MeldekortConsumer(httpClient, environment)
    val meldekortService = MeldekortService(tokenxService, meldekortConsumer, environment)

}
