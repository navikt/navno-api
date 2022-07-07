package no.nav.navno.api.meldekort

import io.ktor.application.ApplicationCall
import no.nav.navno.api.config.Environment
import no.nav.navno.api.meldekort.dto.Meldekortstatus
import no.nav.navno.api.tokenx.TokenxService

class MeldekortService(
    private val tokenxService: TokenxService,
    private val meldekortConsumer: MeldekortConsumer,
    private val env: Environment
) {

    suspend fun getMeldekortStatus(call: ApplicationCall): Meldekortstatus {
        val accessToken = tokenxService.exchangeAuthToken(call.request, env.meldekortTargetApp)
        return meldekortConsumer.getMeldekortStatus(accessToken)
    }
}
