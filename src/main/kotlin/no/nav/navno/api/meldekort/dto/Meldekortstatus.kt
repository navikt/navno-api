package no.nav.navno.api.meldekort.dto

import java.time.LocalDate

data class Meldekortstatus(
    val meldekort: Int = 0,
    val etterregistrerteMeldekort: Int = 0,
    val antallGjenstaaendeFeriedager: Int = 0,
    val nesteMeldekort: Meldekort? = null,
    val nesteInnsendingAvMeldekort: LocalDate? = null,
)
