object Auth0 {
    private const val version = "4.0.0"
    private const val groupId = "com.auth0"

    const val jwt = "$groupId:java-jwt:$version"
}

object DittNAV {
    object Common {
        private const val version = "2022.04.19-11.11-1043a85c4f6f"
        private const val groupId = "com.github.navikt.dittnav-common-lib"

        const val logging = "$groupId:dittnav-common-logging:$version"
    }
}

object Junit {
    private const val version = "5.9.0"

    private const val groupId = "org.junit.jupiter"
    const val api = "$groupId:junit-jupiter-api:$version"
    const val engine = "$groupId:junit-jupiter-engine:$version"
}

object Kotlin {
    const val version = "1.7.10"
}

object Kotlinx {
    private const val groupId = "org.jetbrains.kotlinx"

    const val coroutines = "$groupId:kotlinx-coroutines-core:1.6.4"
    const val htmlJvm = "$groupId:kotlinx-html-jvm:0.8.0"
}

object Ktor {
    private const val version = "2.1.0"
    private const val groupId = "io.ktor"

    const val serverNetty = "$groupId:ktor-server-netty:$version"
    const val serverCors = "$groupId:ktor-server-cors:$version"
    const val serverDefaultHeaders = "$groupId:ktor-server-default-headers:$version"
    const val serverContentNegotiation = "$groupId:ktor-server-content-negotiation:$version"
    const val serverAuth = "$groupId:ktor-server-auth:$version"
    const val serverCallLogging = "$groupId:ktor-server-call-logging:$version"
    const val clientApache = "$groupId:ktor-client-apache:$version"
    const val clientContentNegotiation = "$groupId:ktor-client-content-negotiation:$version"
    const val clientJson = "$groupId:ktor-client-json:$version"
    const val clientSerialization = "$groupId:ktor-client-serialization:$version"
    const val clientLogging = "$groupId:ktor-client-logging:$version"
    const val clientMock = "$groupId:ktor-client-mock:$version"
    const val htmlBuilder = "$groupId:ktor-server-html-builder:$version"
    const val serialization = "$groupId:ktor-serialization-kotlinx-json:$version"
    const val serverTestHost = "$groupId:ktor-server-test-host:$version"
}

object Logback {
    private const val version = "1.2.11" // Logger tilsynelatende ingenting med versjon 1.4.0
    const val classic = "ch.qos.logback:logback-classic:$version"
}

object Mockk {
    private const val version = "1.12.7"
    const val mockk = "io.mockk:mockk:$version"
}

object NAV {
    private const val version = "2.1.4"
    const val tokenValidatorKtor = "no.nav.security:token-validation-ktor-v2:$version"
}

object Shadow {
    const val version = "7.1.2"
    const val pluginId = "com.github.johnrengelman.shadow"
}

object TmsKtorTokenSupport {
    private const val version = "2.0.0"
    private const val groupId = "com.github.navikt.tms-ktor-token-support"

    const val tokendingsExchange = "$groupId:token-support-tokendings-exchange:$version"
}

object Versions {
    const val version = "0.42.0"
    const val pluginId = "com.github.ben-manes.versions"
}