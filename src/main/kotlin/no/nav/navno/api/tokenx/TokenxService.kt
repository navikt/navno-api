package no.nav.navno.api.tokenx

import io.ktor.request.ApplicationRequest
import no.nav.tms.token.support.tokendings.exchange.TokendingsService

class TokenxService(val tokendingsService: TokendingsService, val OIDC_COOKIE_NAME: String = "selvbetjening-idtoken") {


    suspend fun exchangeAuthToken(request: ApplicationRequest, targetApp: String): String {
        val selvbetjeningIdtoken = request.cookies[OIDC_COOKIE_NAME]!!
        return tokendingsService.exchangeToken(selvbetjeningIdtoken, targetApp)
    }
}