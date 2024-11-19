package no.nav.navno.api

import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty
import io.mockk.coEvery
import io.mockk.mockkStatic
import no.nav.navno.api.config.TestApplicationContext
import no.nav.navno.api.config.setupMockedClient
import no.nav.navno.api.config.testModule
import no.nav.navno.api.utils.getAuthTokenFromRequest

fun main() {
    embeddedServer(Netty, port = 8080, watchPaths = listOf("classes")) {
        mockkStatic(::getAuthTokenFromRequest)
        coEvery { getAuthTokenFromRequest(any()) } returns "dummyToken"

        testModule(TestApplicationContext(setupMockedClient()))
    }.start(wait = true)
}