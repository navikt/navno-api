package no.nav.navno.api.config

import io.ktor.client.HttpClient
import io.ktor.http.HttpHeaders
import io.ktor.serialization.kotlinx.json.json
import io.ktor.server.application.Application
import io.ktor.server.application.ApplicationStopping
import io.ktor.server.application.install
import io.ktor.server.auth.Authentication
import io.ktor.server.auth.authenticate
import io.ktor.server.metrics.micrometer.MicrometerMetrics
import io.ktor.server.plugins.calllogging.CallLogging
import io.ktor.server.plugins.contentnegotiation.ContentNegotiation
import io.ktor.server.plugins.cors.routing.CORS
import io.ktor.server.plugins.defaultheaders.DefaultHeaders
import io.ktor.server.request.httpMethod
import io.ktor.server.request.path
import io.ktor.server.routing.routing
import no.nav.navno.api.health.health
import no.nav.navno.api.meldekort.meldekortApi
import no.nav.security.token.support.v3.tokenValidationSupport

fun Application.mainModule(appContext: ApplicationContext = ApplicationContext()) {
    val environment = Environment()

    install(DefaultHeaders)

    install(CORS) {
        allowHost(environment.corsAllowedOrigins)
        allowCredentials = true
        allowHeader(HttpHeaders.ContentType)
    }

    install(MicrometerMetrics) {
        registry = appContext.appMicrometerRegistry
    }

    install(ContentNegotiation) {
        json(jsonConfig())
    }

    install(CallLogging) {
        filter { call -> !call.request.path().contains("internal") }
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
        health(appContext.appMicrometerRegistry)
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
