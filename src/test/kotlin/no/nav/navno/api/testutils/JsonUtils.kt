package no.nav.navno.api.testutils

fun readJsonFile(name: String): String {
    return {}.javaClass.getResource(name)!!.readText()
}
