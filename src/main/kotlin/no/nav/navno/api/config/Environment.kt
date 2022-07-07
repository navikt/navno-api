package no.nav.navno.api.config

import no.nav.personbruker.dittnav.common.util.config.StringEnvVar.getEnvVar

data class Environment(
    val corsAllowedOrigins: String = getEnvVar("CORS_ALLOWED_ORIGINS"),
    val consumerId: String = "navno-api",
    val meldekortTargetApp: String = getEnvVar("MELDEKORT_TARGET_APP"),
    val meldekortUrl: String = getEnvVar("MELDEKORT_URL"),
)