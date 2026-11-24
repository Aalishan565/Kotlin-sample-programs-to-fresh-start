package _9_designPatterns._1_creational._3_factoryPattern

/**
 * FactoryPattern.kt
 * Defines an interface for creating an object, but lets subclasses decide which class to instantiate.
 *
 * Beginner Explanation:
 * The client asks `ShapeFactory` for a shape (`CIRCLE` or `RECTANGLE`), and the factory returns the correct instance
 * without exposing creation logic.
 */
fun main() {
    println("--- Factory Pattern ---")

    val shapeFactory = ShapeFactory()

    val circle = shapeFactory.getShape(ShapeType.CIRCLE)
    circle?.draw()

    val rectangle = shapeFactory.getShape(ShapeType.RECTANGLE)
    rectangle?.draw()
}

enum class ShapeType {
    CIRCLE, RECTANGLE
}

interface Shape {
    fun draw()
}

class Circle : Shape {
    override fun draw() {
        println("Drawing Circle [O]")
    }
}

class Rectangle : Shape {
    override fun draw() {
        println("Drawing Rectangle [[]]")
    }
}

class ShapeFactory {
    fun getShape(shapeType: ShapeType): Shape? {
        return when (shapeType) {
            ShapeType.CIRCLE -> Circle()
            ShapeType.RECTANGLE -> Rectangle()
        }
    }
}
