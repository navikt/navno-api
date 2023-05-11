package no.nav.navno.api.tokenx

import no.nav.tms.token.support.tokendings.exchange.TokendingsService

class TokenxService(private val tokendingsService: TokendingsService) {
    suspend fun exchangeAuthToken(authToken: String, targetApp: String): String {
        return tokendingsService.exchangeToken(authToken, targetApp)
    }
}