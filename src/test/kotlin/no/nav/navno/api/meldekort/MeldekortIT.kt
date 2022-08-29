package no.nav.navno.api.meldekort

import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.http.HttpStatusCode
import io.ktor.serialization.kotlinx.json.json
import no.nav.navno.api.IntegrationTest
import no.nav.navno.api.config.setupMockedClient
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
internal class MeldekortIT : IntegrationTest() {

    val HENT_MELDEKORTSTATUS_PATH = "meldekortstatus"

    @Test
    fun testGetMeldekortStatus200() = integrationTest(setupMockedClient()) {
        val client = createClient { install(ContentNegotiation) { json() } }
        val response = get(client, HENT_MELDEKORTSTATUS_PATH)

        assertEquals(HttpStatusCode.OK, response.status)
    }

    @Test
    fun testGetMeldekortStatus500() {
        integrationTest(setupMockedClient(meldekortStatus = HttpStatusCode.InternalServerError)) {
            val client = createClient { install(ContentNegotiation) { json() } }

            val response = get(client, HENT_MELDEKORTSTATUS_PATH)

            assertEquals(HttpStatusCode.InternalServerError, response.status)
        }
    }
}