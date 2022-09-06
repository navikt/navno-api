import org.gradle.api.tasks.testing.logging.TestExceptionFormat
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    // Apply the Kotlin JVM plugin to add support for Kotlin on the JVM.
    kotlin("jvm").version(Kotlin.version)
    kotlin("plugin.allopen").version(Kotlin.version)
    kotlin("plugin.serialization").version(Kotlin.version)

    id(Shadow.pluginId) version (Shadow.version)
    id(Versions.pluginId) version Versions.version // ./gradlew dependencyUpdates to check for new versions
    application
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "17"
}

repositories {
    mavenCentral()
    maven("https://jitpack.io")
}

dependencies {
    implementation(Auth0.jwt)
    implementation(DittNAV.Common.logging)
    implementation(Kotlinx.coroutines)
    implementation(Kotlinx.htmlJvm)
    implementation(Ktor.clientApache)
    implementation(Ktor.clientContentNegotiation)
    implementation(Ktor.clientJson)
    implementation(Ktor.clientLogging)
    implementation(Ktor.clientSerialization)
    implementation(Ktor.htmlBuilder)
    implementation(Ktor.serverNetty)
    implementation(Ktor.serverCors)
    implementation(Ktor.serverDefaultHeaders)
    implementation(Ktor.serverContentNegotiation)
    implementation(Ktor.serverAuth)
    implementation(Ktor.serverCallLogging)
    implementation(Ktor.serialization)
    implementation(Ktor.metricsMicrometer)
    implementation(Micrometer.registryPrometheus)
    implementation(Logback.classic)
    implementation(NAV.tokenValidatorKtor)
    implementation(TmsKtorTokenSupport.tokendingsExchange)
    testImplementation(Mockk.mockk)
    testImplementation(Ktor.clientMock)
    testImplementation(Ktor.serverTestHost)
    testImplementation(Junit.api)
    testImplementation(Junit.engine)
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

    register("runServer", JavaExec::class) {

        environment("CORS_ALLOWED_ORIGINS", "localhost:9002")

        environment("NAIS_CLUSTER_NAME", "dev-gcp")
        environment("NAIS_NAMESPACE", "personbruker")

        main = application.mainClassName
        classpath = sourceSets["main"].runtimeClasspath
    }
}

apply(plugin = Shadow.pluginId)
