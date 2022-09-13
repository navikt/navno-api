package no.nav.navno.api.config.serializer

import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeParseException

class LocalDateSerializer : KSerializer<LocalDate> {

    override fun deserialize(decoder: Decoder): LocalDate {
        val value = decoder.decodeString()
        return try { // Midlertidig løsning for å støtte begge format i overgang
            LocalDate.parse(value, DateTimeFormatter.ISO_DATE_TIME)
        } catch (e: DateTimeParseException) {
            LocalDate.parse(value, DateTimeFormatter.ISO_DATE)
        }
    }

    override fun serialize(encoder: Encoder, value: LocalDate) {
        encoder.encodeString(value.format(DateTimeFormatter.ISO_DATE))
    }

    override val descriptor: SerialDescriptor
        get() = PrimitiveSerialDescriptor("LocalDate", PrimitiveKind.STRING)
}
