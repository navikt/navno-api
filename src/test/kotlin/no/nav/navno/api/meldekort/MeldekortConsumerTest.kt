package no.nav.navno.api.meldekort

import io.ktor.client.HttpClient
import io.ktor.client.engine.mock.MockEngine
import io.ktor.client.engine.mock.respond
import io.ktor.client.engine.mock.respondError
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.http.ContentType
import io.ktor.http.HttpHeaders
import io.ktor.http.HttpStatusCode
import io.ktor.http.headersOf
import io.ktor.serialization.kotlinx.json.json
import kotlinx.coroutines.runBlocking
import no.nav.navno.api.config.Environment
import no.nav.navno.api.config.jsonConfig
import no.nav.navno.api.meldekort.dto.Meldekortstatus
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.assertThrows
import java.time.LocalDate

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
internal class MeldekortConsumerTest {

    @Test
    fun testGetMeldekortStatus200() {
        val meldekortConsumer = MeldekortConsumer(setupMockedClient(), Environment())
        var status: Meldekortstatus
        runBlocking {
            status = meldekortConsumer.getMeldekortStatus("")
        }
        assertEquals(0, status.meldekort)
        assertEquals(0, status.etterregistrerteMeldekort)
        assertEquals(LocalDate.of(2022, 7, 13), status.nesteMeldekort?.kanSendesFra)
        assertEquals(LocalDate.of(2022, 7, 14), status.nesteMeldekort?.til)
        assertEquals(LocalDate.of(2022, 7, 15), status.nesteMeldekort?.fra)
    }

    @Test
    fun testGetMeldekortStatus500() {
        val meldekortConsumer = MeldekortConsumer(setupMockedClient(success = false), Environment())
        assertThrows<RuntimeException> {
            runBlocking {
                meldekortConsumer.getMeldekortStatus("")
            }
        }
    }

    private fun setupMockedClient(success: Boolean = true): HttpClient {
        val json = this.javaClass.getResource("/meldekortstatus.json")?.readText()!!

        return HttpClient(MockEngine) {
            engine {
                addHandler {
                    if (success) {
                        respond(
                            json,
                            headers = headersOf(HttpHeaders.ContentType, ContentType.Application.Json.toString())
                        )
                    } else {
                        respondError(HttpStatusCode.InternalServerError)
                    }
                }
            }
            install(ContentNegotiation) {
                json(jsonConfig())
            }
            install(HttpTimeout)
            expectSuccess = false
        }
    }
}