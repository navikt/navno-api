package no.nav.navno.api.meldekort.dto

import kotlinx.serialization.Serializable
import no.nav.navno.api.config.serializer.LocalDateSerializer
import java.time.LocalDate

@Serializable
data class Meldekort(
    val uke: String,
    @Serializable(with = LocalDateSerializer::class) val kanSendesFra: LocalDate,
    @Serializable(with = LocalDateSerializer::class) val fra: LocalDate,
    @Serializable(with = LocalDateSerializer::class) val til: LocalDate,
)
