package no.nav.navno.api.tokenx

import io.ktor.request.ApplicationRequest
import no.nav.tms.token.support.tokendings.exchange.TokendingsService

class TokenxService(val tokendingsService: TokendingsService, val OIDC_COOKIE_NAME: String = "selvbetjening-idtoken") {


    suspend fun exchangeAuthToken(request: ApplicationRequest, targetApp: String): String {
        val selvbetjeningIdtoken = request.cookies[OIDC_COOKIE_NAME]!!
        val token =
            if (selvbetjeningIdtoken.startsWith("Bearer ")) selvbetjeningIdtoken.substring(
                7,
                selvbetjeningIdtoken.length
            )
            else selvbetjeningIdtoken
        return tokendingsService.exchangeToken(token, targetApp)
    }
}