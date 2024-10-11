package no.nav.navno.api.config

import no.nav.tms.token.support.tokendings.exchange.TokendingsService

class DummyTokendingsService : TokendingsService {
    override suspend fun exchangeToken(token: String, targetApp: String) = "dummy token"
}