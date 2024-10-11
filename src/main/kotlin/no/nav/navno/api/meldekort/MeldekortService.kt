package no.nav.navno.api.meldekort

import io.ktor.server.application.ApplicationCall
import no.nav.navno.api.config.Environment
import no.nav.navno.api.meldekort.dto.Meldekortstatus
import no.nav.navno.api.utils.getAuthTokenFromRequest
import no.nav.tms.token.support.tokendings.exchange.TokendingsService

class MeldekortService(
    private val tokendingsService: TokendingsService,
    private val meldekortConsumer: MeldekortConsumer,
    private val env: Environment
) {

    suspend fun getMeldekortStatus(call: ApplicationCall): Meldekortstatus {
        val authToken = getAuthTokenFromRequest(call.request)
        val accessToken = tokendingsService.exchangeToken(authToken, env.meldekortTargetApp)
        return meldekortConsumer.getMeldekortStatus(accessToken)
    }
}
