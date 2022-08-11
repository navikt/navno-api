package no.nav.navno.api.meldekort.dto

import kotlinx.serialization.Serializable
import java.time.LocalDate

@Serializable
data class Meldekortstatus(
    val meldekort: Int = 0,
    val etterregistrerteMeldekort: Int = 0,
    val nesteMeldekort: Meldekort? = null,
    @Serializable(with = MeldekortLocalDateSerializer::class) val nesteInnsendingAvMeldekort: LocalDate? = null,
)
