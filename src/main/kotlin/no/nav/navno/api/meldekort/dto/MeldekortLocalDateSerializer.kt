package no.nav.navno.api.meldekort.dto

import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class MeldekortLocalDateSerializer: KSerializer<LocalDate> {
    private val dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd")

    override fun deserialize(decoder: Decoder): LocalDate {
        return LocalDate.parse(decoder.decodeString(), DateTimeFormatter.ISO_DATE)
    }

    override val descriptor = PrimitiveSerialDescriptor(
        serialName = "no.nav.navno.api.meldekort.dto.MeldekortLocalDateSerializer",
        kind = PrimitiveKind.STRING
    )

    override fun serialize(encoder: Encoder, value: LocalDate) {
        val dateString = value.format(dateFormat)

        encoder.encodeString(dateString)
    }

}
