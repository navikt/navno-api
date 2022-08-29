package no.nav.navno.api.config

data class Environment(
    val corsAllowedOrigins: String = System.getenv("CORS_ALLOWED_ORIGINS"),
    val meldekortTargetApp: String = System.getenv("MELDEKORT_TARGET_APP"),
    val meldekortUrl: String = System.getenv("MELDEKORT_URL"),
)