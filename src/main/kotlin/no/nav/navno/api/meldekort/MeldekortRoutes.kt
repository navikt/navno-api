package no.nav.navno.api.meldekort

import io.ktor.http.HttpStatusCode
import io.ktor.server.application.call
import io.ktor.server.response.respond
import io.ktor.server.routing.Route
import io.ktor.server.routing.get
import no.nav.navno.api.utils.getAuthTokenFromRequest
import org.slf4j.LoggerFactory

fun Route.meldekortApi(meldekortService: MeldekortService) {

    val log = LoggerFactory.getLogger("meldekortApi")

    get("/meldekortstatus") {
        try {
            val authToken = getAuthTokenFromRequest(call.request)
            call.respond(meldekortService.getMeldekortStatus(authToken))
        } catch (e: Exception) {
            log.error("Noe gikk galt ved henting av meldekort", e)
            call.respond(HttpStatusCode.InternalServerError)
        }
    }
}
