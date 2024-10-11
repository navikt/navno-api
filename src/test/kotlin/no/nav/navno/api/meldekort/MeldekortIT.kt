package no.nav.navno.api.meldekort

import io.kotest.assertions.json.shouldEqualJson
import io.kotest.matchers.shouldBe
import io.ktor.client.statement.bodyAsText
import io.ktor.http.HttpStatusCode
import no.nav.navno.api.IntegrationTest
import no.nav.navno.api.config.setupMockedClient
import no.nav.navno.api.testutils.readJsonFile
import org.junit.jupiter.api.Test

class MeldekortIT : IntegrationTest() {

    @Test
    fun testGetMeldekortStatus200() = integrationTest(setupMockedClient()) {
        val response = get(HENT_MELDEKORTSTATUS_PATH)

        response.status shouldBe HttpStatusCode.OK
        response.bodyAsText() shouldEqualJson readJsonFile("/json/expected-response/meldekortstatus.json")
    }

    @Test
    fun testGetMeldekortStatus500() {
        integrationTest(setupMockedClient(meldekortStatus = HttpStatusCode.InternalServerError)) {
            val response = get(HENT_MELDEKORTSTATUS_PATH)

            response.status shouldBe HttpStatusCode.InternalServerError
        }
    }

    companion object {
        private const val HENT_MELDEKORTSTATUS_PATH = "meldekortstatus"
    }
}