object DittNAV {
    object Common {
        private const val version = "2022.04.19-11.11-1043a85c4f6f"
        private const val groupId = "com.github.navikt.dittnav-common-lib"

        const val logging = "$groupId:dittnav-common-logging:$version"
    }
}

object Jackson {
    private const val version = "2.13.3"

    const val dataTypeJsr310 = "com.fasterxml.jackson.datatype:jackson-datatype-jsr310:$version"
}

object Junit {
    private const val version = "5.8.2"

    private const val groupId = "org.junit.jupiter"
    const val api = "$groupId:junit-jupiter-api:$version"
    const val engine = "$groupId:junit-jupiter-engine:$version"
}

object Kotlin {
    const val version = "1.7.10"
}

object Kotlinx {
    private const val groupId = "org.jetbrains.kotlinx"

    const val coroutines = "$groupId:kotlinx-coroutines-core:1.6.3"
    const val htmlJvm = "$groupId:kotlinx-html-jvm:0.7.5"
}

object Ktor {
    private const val version = "1.6.8"
    private const val groupId = "io.ktor"

    const val serverNetty = "$groupId:ktor-server-netty:$version"
    const val clientApache = "$groupId:ktor-client-apache:$version"
    const val clientJson = "$groupId:ktor-client-json:$version"
    const val clientSerializationJvm = "$groupId:ktor-client-serialization-jvm:$version"
    const val clientJackson = "$groupId:ktor-client-jackson:$version"
    const val clientLogging = "$groupId:ktor-client-logging:$version"
    const val clientLoggingJvm = "$groupId:ktor-client-logging-jvm:$version"
    const val clientMock = "$groupId:ktor-client-mock:$version"
    const val htmlBuilder = "$groupId:ktor-html-builder:$version"
    const val jackson = "$groupId:ktor-jackson:$version"
    const val serialization = "$groupId:ktor-serialization:$version"
}

object Logback {
    private const val version = "1.2.11"
    const val classic = "ch.qos.logback:logback-classic:$version"
}

object Logstash {
    private const val version = "7.2"
    const val logbackEncoder = "net.logstash.logback:logstash-logback-encoder:$version"
}

object NAV {
    private const val version = "2.1.1"
    const val tokenValidatorKtor = "no.nav.security:token-validation-ktor:$version"
}

object Shadow {
    const val version = "7.1.2"
    const val pluginId = "com.github.johnrengelman.shadow"
}

object TmsKtorTokenSupport {
    private const val version = "2022.05.19-09.32-5076b2435b0a"
    private const val groupId = "com.github.navikt.tms-ktor-token-support"

    const val tokendingsExchange = "$groupId:token-support-tokendings-exchange:$version"
}

object Versions {
    const val version = "0.42.0"
    const val pluginId = "com.github.ben-manes.versions"
}