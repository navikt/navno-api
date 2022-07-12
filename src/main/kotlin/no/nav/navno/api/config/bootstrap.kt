package no.nav.navno.api.config

import io.ktor.application.Application
import io.ktor.application.ApplicationStopping
import io.ktor.application.install
import io.ktor.auth.Authentication
import io.ktor.auth.authenticate
import io.ktor.client.HttpClient
import io.ktor.features.CORS
import io.ktor.features.CallLogging
import io.ktor.features.ContentNegotiation
import io.ktor.features.DefaultHeaders
import io.ktor.http.HttpHeaders
import io.ktor.request.httpMethod
import io.ktor.request.path
import io.ktor.routing.routing
import io.ktor.serialization.json
import no.nav.navno.api.health.healthApi
import no.nav.navno.api.meldekort.meldekortApi
import no.nav.security.token.support.ktor.tokenValidationSupport

fun Application.mainModule(appContext: ApplicationContext = ApplicationContext()) {
    val environment = Environment()

    install(DefaultHeaders)

    install(CORS) {
        host(environment.corsAllowedOrigins)
        allowCredentials = true
        header(HttpHeaders.ContentType)
    }

    install(ContentNegotiation) {
        json(jsonConfig())
    }

    install(CallLogging) {
        filter { call ->
            !call.request.path().startsWith("/internal")
        }
        format { call ->
            val status = call.response.status()
            val httpMethod = call.request.httpMethod.value
            val path = call.request.path()
            "$status - $httpMethod $path"
        }
    }

    val conf = this.environment.config
    install(Authentication) {
        tokenValidationSupport(config = conf)
    }

    routing {
        healthApi(appContext.healthService)
        authenticate {
            meldekortApi(appContext.meldekortService)
        }
    }

    configureShutdownHook(appContext.httpClient)
}

private fun Application.configureShutdownHook(httpClient: HttpClient) {
    environment.monitor.subscribe(ApplicationStopping) {
        httpClient.close()
    }
}
