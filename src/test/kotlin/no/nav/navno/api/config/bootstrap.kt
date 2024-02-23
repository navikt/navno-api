package no.nav.navno.api.config

import io.ktor.serialization.kotlinx.json.json
import io.ktor.server.application.Application
import io.ktor.server.application.install
import io.ktor.server.plugins.contentnegotiation.ContentNegotiation
import io.ktor.server.routing.routing
import no.nav.navno.api.meldekort.meldekortApi


fun Application.testModule(appContext: TestApplicationContext) {

    install(ContentNegotiation) {
        json(jsonConfig())
    }

    routing {
        meldekortApi(appContext.meldekortService)
    }
}