package no.nav.navno.api.meldekort.dto

import java.time.LocalDate

data class Meldekort(
    val uke: String,
    val kanSendesFra: LocalDate,
    val fra: LocalDate,
    val til: LocalDate,
)
