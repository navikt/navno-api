object Auth0 {
    private const val version = "4.1.0"
    private const val groupId = "com.auth0"

    const val jwt = "$groupId:java-jwt:$version"
}

object Junit {
    private const val version = "5.9.1"

    private const val groupId = "org.junit.jupiter"
    const val api = "$groupId:junit-jupiter-api:$version"
    const val engine = "$groupId:junit-jupiter-engine:$version"
}

object Kotlin {
    const val version = "1.7.20"
}

object Kotlinx {
    private const val groupId = "org.jetbrains.kotlinx"

    const val coroutines = "$groupId:kotlinx-coroutines-core:1.6.4"
    const val htmlJvm = "$groupId:kotlinx-html-jvm:0.8.0"
}

object Ktor {
    private const val version = "2.1.2"
    private const val groupId = "io.ktor"

    const val metricsMicrometer = "$groupId:ktor-server-metrics-micrometer:$version"
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
    private const val version = "1.4.4"
    const val classic = "ch.qos.logback:logback-classic:$version"
}

object Logstash {
    private const val version = "7.2"
    private const val groupId = "net.logstash.logback"

    const val logbackEncoder = "$groupId:logstash-logback-encoder:$version"
}

object Micrometer {
    private const val version = "1.9.5"
    const val registryPrometheus = "io.micrometer:micrometer-registry-prometheus:$version"
}

object Mockk {
    private const val version = "1.13.2"
    const val mockk = "io.mockk:mockk:$version"
}

object NAV {
    private const val version = "2.1.6"
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
    const val version = "0.44.0"
    const val pluginId = "com.github.ben-manes.versions"
}