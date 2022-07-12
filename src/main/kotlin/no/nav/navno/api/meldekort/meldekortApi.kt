package no.nav.navno.api.meldekort

import io.ktor.application.call
import io.ktor.http.HttpStatusCode
import io.ktor.response.respond
import io.ktor.routing.Route
import io.ktor.routing.get
import org.slf4j.LoggerFactory

fun Route.meldekortApi(meldekortService: MeldekortService) {

    val log = LoggerFactory.getLogger("meldekortApi")

    get("/meldekortstatus") {
        try {
            val meldekortStatus = meldekortService.getMeldekortStatus(call)

            call.respond(meldekortStatus)
        } catch (e: Exception) {
            log.warn("Det skjedde en feil mot meldekort. Feilmelding: [${e.message}]", e)
            call.respond(HttpStatusCode.InternalServerError)
        }
    }
}
