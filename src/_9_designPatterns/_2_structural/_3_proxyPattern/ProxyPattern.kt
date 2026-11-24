package _9_designPatterns._2_structural._3_proxyPattern

/**
 * ProxyPattern.kt
 * Provides a surrogate/placeholder (`ProxyInternet`) to control access to another object (`RealInternet`).
 */
fun main() {
    println("--- Proxy Pattern ---")
    val internet: Internet = ProxyInternet()

    try {
        println("Attempting connection to google.com:")
        internet.connectToSite("google.com")

        println("\nAttempting connection to banned site 'banned.com':")
        internet.connectToSite("banned.com")
    } catch (e: Exception) {
        println("Caught Exception: ${e.message}")
    }
}

interface Internet {
    @Throws(Exception::class)
    fun connectToSite(siteName: String)
}

class RealInternet : Internet {
    override fun connectToSite(siteName: String) {
        println("Connecting to $siteName ... Connection successful!")
    }
}

class ProxyInternet : Internet {
    private val realInternet: Internet = RealInternet()

    companion object {
        private val bannedSites = listOf("banned.com", "blocked.com", "a", "b", "c", "d")
    }

    override fun connectToSite(siteName: String) {
        if (bannedSites.contains(siteName.lowercase())) {
            throw Exception("Access Denied to $siteName - Site is blocked by Proxy!")
        }
        realInternet.connectToSite(siteName)
    }
}
