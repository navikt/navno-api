package no.nav.navno.api.config

data class Environment(
    val corsAllowedOrigins: String = System.getenv("CORS_ALLOWED_ORIGINS") ?: "",
    val consumerId: String = "navno-api",
    val meldekortTargetApp: String = System.getenv("MELDEKORT_TARGET_APP") ?: "",
    val meldekortUrl: String = System.getenv("MELDEKORT_URL") ?: "http://localhost:8090/api/person/meldekortstatus",
)