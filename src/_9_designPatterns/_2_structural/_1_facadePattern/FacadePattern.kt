package _9_designPatterns._2_structural._1_facadePattern

/**
 * FacadePattern.kt
 * Provides a unified, simplified interface (`ShopKeeper`) to a set of interfaces in a complex subsystem (`Iphone`, `Samsung`).
 */
fun main() {
    println("--- Facade Pattern ---")
    val shopKeeper = ShopKeeper()

    println("Customer requesting iPhone details:")
    shopKeeper.getIphoneDetail()

    println("\nCustomer requesting Samsung details:")
    shopKeeper.getSamsungDetail()
}

interface Phone {
    fun modelName()
    fun modelPrice()
}

class Iphone : Phone {
    override fun modelName() {
        println("Phone Model: iPhone 15 Pro")
    }

    override fun modelPrice() {
        println("Phone Price: \$999")
    }
}

class Samsung : Phone {
    override fun modelName() {
        println("Phone Model: Samsung Galaxy S24")
    }

    override fun modelPrice() {
        println("Phone Price: \$899")
    }
}

// Facade Class
class ShopKeeper {
    private val iphone: Phone = Iphone()
    private val samsung: Phone = Samsung()

    fun getIphoneDetail() {
        iphone.modelName()
        iphone.modelPrice()
    }

    fun getSamsungDetail() {
        samsung.modelName()
        samsung.modelPrice()
    }
}
