package no.nav.navno.api.config

import no.nav.navno.api.health.HealthService

class ApplicationContext {

    val httpClient = HttpClientBuilder.build()
    val healthService = HealthService(this)

}
