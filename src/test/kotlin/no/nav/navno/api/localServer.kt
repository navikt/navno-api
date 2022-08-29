package no.nav.navno.api

import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty
import io.mockk.coEvery
import io.mockk.mockk
import no.nav.navno.api.config.TestApplicationContext
import no.nav.navno.api.config.setupMockedClient
import no.nav.navno.api.config.testModule
import no.nav.navno.api.tokenx.TokenxService

fun main() {
    embeddedServer(Netty, port = 8080, watchPaths = listOf("classes")) {
        val tokenxService: TokenxService = mockk()
        coEvery { tokenxService.exchangeAuthToken(any(), any()) } returns "dummyToken"

        testModule(TestApplicationContext(setupMockedClient(), tokenxService))
    }.start(wait = true)
}