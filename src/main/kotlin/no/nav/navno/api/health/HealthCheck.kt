package no.nav.navno.api.health

interface HealthCheck {

    suspend fun status(): HealthStatus

}
