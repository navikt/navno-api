package no.nav.navno.api.meldekort

import no.nav.navno.api.config.Environment
import no.nav.navno.api.meldekort.dto.Meldekortstatus
import no.nav.tms.token.support.tokendings.exchange.TokendingsService

class MeldekortService(
    private val tokendingsService: TokendingsService,
    private val meldekortConsumer: MeldekortConsumer,
    private val env: Environment
) {

    suspend fun getMeldekortStatus(authToken: String): Meldekortstatus {
        val accessToken = tokendingsService.exchangeToken(authToken, env.meldekortTargetApp)
        return meldekortConsumer.getMeldekortStatus(accessToken)
    }
}
