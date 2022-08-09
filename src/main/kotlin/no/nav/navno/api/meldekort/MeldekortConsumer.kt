package no.nav.navno.api.meldekort

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.header
import io.ktor.client.request.url
import no.nav.navno.api.config.Environment
import no.nav.navno.api.meldekort.dto.Meldekortstatus
import java.net.URL

class MeldekortConsumer(private val client: HttpClient, env: Environment) {

    private val meldekortStatusEndpoint = URL("${env.meldekortUrl}/api/person/meldekortstatus")

    suspend fun getMeldekortStatus(accessToken: String): Meldekortstatus {
        return client.get {
            url(meldekortStatusEndpoint)
            header("TokenXAuthorization", "Bearer $accessToken")
        }.body()
    }
}