package _9_designPatterns._1_creational.abstractFactory

/**
 * AbstractFactoryPattern.kt
 * Provides an interface for creating families of related or dependent objects without specifying their concrete classes.
 */
fun main() {
    println("--- Abstract Factory Pattern ---")

    // Get Color Factory
    val colorFactory = FactoryProducer.getFactory("COLOR")
    val redColor = colorFactory?.getColor("RED")
    redColor?.fill()

    // Get Shape Factory
    val shapeFactory = FactoryProducer.getFactory("SHAPE")
    val circleShape = shapeFactory?.getShape("CIRCLE")
    circleShape?.draw()
}

interface Shape {
    fun draw()
}

class Circle : Shape {
    override fun draw() {
        println("Drawing Circle in Abstract Factory")
    }
}

class Rectangle : Shape {
    override fun draw() {
        println("Drawing Rectangle in Abstract Factory")
    }
}

interface Color {
    fun fill()
}

class Red : Color {
    override fun fill() {
        println("Filling Red Color")
    }
}

class Black : Color {
    override fun fill() {
        println("Filling Black Color")
    }
}

abstract class AbstractFactory {
    abstract fun getShape(shape: String): Shape?
    abstract fun getColor(color: String): Color?
}

class ShapeFactory : AbstractFactory() {
    override fun getShape(shape: String): Shape? {
        return when (shape.uppercase()) {
            "CIRCLE" -> Circle()
            "RECTANGLE" -> Rectangle()
            else -> null
        }
    }

    override fun getColor(color: String): Color? = null
}

class ColorFactory : AbstractFactory() {
    override fun getShape(shape: String): Shape? = null

    override fun getColor(color: String): Color? {
        return when (color.uppercase()) {
            "RED" -> Red()
            "BLACK" -> Black()
            else -> null
        }
    }
}

object FactoryProducer {
    fun getFactory(choice: String): AbstractFactory? {
        return when (choice.uppercase()) {
            "SHAPE" -> ShapeFactory()
            "COLOR" -> ColorFactory()
            else -> null
        }
    }
}
