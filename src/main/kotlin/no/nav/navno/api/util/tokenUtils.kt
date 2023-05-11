package no.nav.navno.api.util

import io.ktor.server.request.ApplicationRequest
import io.ktor.server.request.authorization

private val OIDC_COOKIE_NAME: String = "selvbetjening-idtoken"

fun getAuthTokenFromRequest(request: ApplicationRequest): String {
    return request.authorization()?.replace("Bearer ", "") ?: request.cookies[OIDC_COOKIE_NAME]
    ?: throw RuntimeException("Kunne ikke utlede token fra request")
}