package no.nav.navno.api.config

import io.ktor.http.HttpHeaders

val HttpHeaders.NavCallId: String
    get() = "Nav-Call-Id"
val HttpHeaders.NavConsumerId: String
    get() = "Nav-Consumer-Id"
val HttpHeaders.TokenXAuthorization: String
    get() = "TokenXAuthorization"