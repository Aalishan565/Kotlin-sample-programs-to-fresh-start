package _9_designPatterns._1_creational._2_builderPattern

/**
 * BuilderPattern.kt
 * Separates the construction of a complex object from its representation.
 *
 * Beginner Explanation:
 * - Traditional Builder: Uses a inner `Builder` class with chainable `set()` methods.
 * - Idiomatic Kotlin: Kotlin's named parameters and default arguments natively replace the Builder pattern!
 */
fun main() {
    println("--- Builder Pattern ---")

    // 1. Traditional Builder Pattern
    val phoneFromBuilder = Phone.Builder()
        .setBrand("Apple")
        .setName("iPhone 15 Pro")
        .setPrice(999)
        .setRam(8)
        .build()

    println("1. Phone built using Traditional Builder:")
    println("   $phoneFromBuilder")

    // 2. Idiomatic Kotlin Way (Named Arguments)
    val phoneKotlinWay = PhoneData(
        brand = "Samsung",
        name = "Galaxy S24",
        price = 899
        // ram defaults to 8
    )

    println("\n2. Phone created using Idiomatic Kotlin Named Arguments:")
    println("   $phoneKotlinWay")
}

// Traditional Builder Implementation
class Phone private constructor(
    val name: String?,
    val brand: String?,
    val price: Int,
    val ram: Int
) {
    override fun toString(): String {
        return "Phone(brand='$brand', name='$name', price=\$$price, ram=${ram}GB)"
    }

    class Builder {
        private var name: String? = null
        private var brand: String? = null
        private var price: Int = 0
        private var ram: Int = 0

        fun setName(name: String) = apply { this.name = name }
        fun setBrand(brand: String) = apply { this.brand = brand }
        fun setPrice(price: Int) = apply { this.price = price }
        fun setRam(ram: Int) = apply { this.ram = ram }

        fun build(): Phone {
            return Phone(name, brand, price, ram)
        }
    }
}

// Idiomatic Kotlin Replacement (Data Class with Default Arguments)
data class PhoneData(
    val name: String,
    val brand: String,
    val price: Int = 0,
    val ram: Int = 8
)
