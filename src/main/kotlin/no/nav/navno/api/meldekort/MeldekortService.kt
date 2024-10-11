package no.nav.navno.api.meldekort

import io.ktor.server.application.ApplicationCall
import no.nav.navno.api.config.Environment
import no.nav.navno.api.meldekort.dto.Meldekortstatus
import no.nav.navno.api.tokenx.TokenxService
import no.nav.navno.api.utils.getAuthTokenFromRequest

class MeldekortService(
    private val tokenxService: TokenxService,
    private val meldekortConsumer: MeldekortConsumer,
    private val env: Environment
) {

    suspend fun getMeldekortStatus(call: ApplicationCall): Meldekortstatus {
        val authToken = getAuthTokenFromRequest(call.request)
        val accessToken = tokenxService.exchangeAuthToken(authToken, env.meldekortTargetApp)
        return meldekortConsumer.getMeldekortStatus(accessToken)
    }
}
