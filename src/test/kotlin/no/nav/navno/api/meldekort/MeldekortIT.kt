package no.nav.navno.api.meldekort

import io.ktor.http.HttpStatusCode
import no.nav.navno.api.IntegrationTest
import no.nav.navno.api.config.setupMockedClient
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MeldekortIT : IntegrationTest() {

    val HENT_MELDEKORTSTATUS_PATH = "meldekortstatus"

    @Test
    fun testGetMeldekortStatus200() = integrationTest(setupMockedClient()) {
        val response = get(HENT_MELDEKORTSTATUS_PATH)

        assertEquals(HttpStatusCode.OK, response.status)
    }

    @Test
    fun testGetMeldekortStatus500() {
        integrationTest(setupMockedClient(meldekortStatus = HttpStatusCode.InternalServerError)) {
            val response = get(HENT_MELDEKORTSTATUS_PATH)

            assertEquals(HttpStatusCode.InternalServerError, response.status)
        }
    }
}