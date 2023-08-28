import org.gradle.api.tasks.testing.logging.TestExceptionFormat

plugins {
    val versions = object {
        val kotlin = "1.9.10"
        val shadow = "8.1.1"
        val versions = "0.47.0"
    }

    kotlin("jvm") version(versions.kotlin)
    kotlin("plugin.allopen") version(versions.kotlin)
    kotlin("plugin.serialization") version(versions.kotlin)

    id("com.github.johnrengelman.shadow") version(versions.shadow)
    id("com.github.ben-manes.versions") version(versions.versions) // ./gradlew dependencyUpdates to check for new versions
    application
}

kotlin {
    jvmToolchain(17)
}

repositories {
    mavenCentral()
    maven("https://jitpack.io")
}

dependencies {
    val versions = object {
        val auth0Jwt = "4.4.0"
        val kotlinxCoroutines = "1.7.3"
        val kotlinxHtmlJvm = "0.9.1"
        val ktor = "2.3.3"
        val micrometer = "1.11.3"
        val logback = "1.4.11"
        val logstash = "7.4"
        val navSecurity = "3.1.3"
        val tmsKtorTokenSupport = "2.1.3"
        val mockk = "1.13.7"
        val junit = "5.10.0"
    }

    implementation("com.auth0:java-jwt:${versions.auth0Jwt}")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:${versions.kotlinxCoroutines}")
    implementation("org.jetbrains.kotlinx:kotlinx-html-jvm:${versions.kotlinxHtmlJvm}")
    implementation("io.ktor:ktor-client-apache:${versions.ktor}")
    implementation("io.ktor:ktor-client-content-negotiation:${versions.ktor}")
    implementation("io.ktor:ktor-client-json:${versions.ktor}")
    implementation("io.ktor:ktor-client-logging:${versions.ktor}")
    implementation("io.ktor:ktor-client-serialization:${versions.ktor}")
    implementation("io.ktor:ktor-server-html-builder:${versions.ktor}")
    implementation("io.ktor:ktor-server-netty:${versions.ktor}")
    implementation("io.ktor:ktor-server-cors:${versions.ktor}")
    implementation("io.ktor:ktor-server-default-headers:${versions.ktor}")
    implementation("io.ktor:ktor-server-content-negotiation:${versions.ktor}")
    implementation("io.ktor:ktor-server-auth:${versions.ktor}")
    implementation("io.ktor:ktor-server-call-logging:${versions.ktor}")
    implementation("io.ktor:ktor-serialization-kotlinx-json:${versions.ktor}")
    implementation("io.ktor:ktor-server-metrics-micrometer:${versions.ktor}")
    implementation("io.micrometer:micrometer-registry-prometheus:${versions.micrometer}")
    implementation("ch.qos.logback:logback-classic:${versions.logback}")
    implementation("net.logstash.logback:logstash-logback-encoder:${versions.logstash}")
    implementation("no.nav.security:token-validation-ktor-v2:${versions.navSecurity}")
    implementation("com.github.navikt.tms-ktor-token-support:token-support-tokendings-exchange:${versions.tmsKtorTokenSupport}")
    testImplementation("io.mockk:mockk:${versions.mockk}")
    testImplementation("io.ktor:ktor-client-mock:${versions.ktor}")
    testImplementation("io.ktor:ktor-server-test-host:${versions.ktor}")
    testImplementation("org.junit.jupiter:junit-jupiter-api:${versions.junit}")
    testImplementation("org.junit.jupiter:junit-jupiter-engine:${versions.junit}")
}

application {
    mainClass.set("io.ktor.server.netty.EngineMain")
}

tasks {
    withType<Test> {
        useJUnitPlatform()
        testLogging {
            exceptionFormat = TestExceptionFormat.FULL
            events("passed", "skipped", "failed")
        }
    }
}
