package _9_designPatterns.behavioural._1_observerPattern

/**
 * ObserverPattern.kt
 * Defines a 1-to-N dependency between objects so when one object changes state, all its dependents are notified automatically.
 */
fun main() {
    println("--- Observer Pattern ---")

    val sub1 = FirstSubscriber("Sub 1")
    val sub2 = SecondSubscriber("Sub 2")
    val sub3 = ThirdSubscriber("Sub 3")

    val publisher = MessagePublisher()

    // Register observers
    publisher.registerObserver(sub1)
    publisher.registerObserver(sub2)
    publisher.registerObserver(sub3)

    println("Publishing Message 1:")
    publisher.notifyObserver(Message("Kotlin Design Patterns Released!"))

    println("\nUnregistering Sub 2...")
    publisher.unRegisterObserver(sub2)

    println("\nPublishing Message 2:")
    publisher.notifyObserver(Message("Updated Message Broadcast!"))
}

data class Message(val messageContent: String)

interface Observer {
    fun onMessageReceive(message: Message)
}

interface Subject {
    fun registerObserver(observer: Observer)
    fun unRegisterObserver(observer: Observer)
    fun notifyObserver(message: Message)
}

class FirstSubscriber(val name: String) : Observer {
    override fun onMessageReceive(message: Message) {
        println("FirstSubscriber ($name) received: '${message.messageContent}'")
    }
}

class SecondSubscriber(val name: String) : Observer {
    override fun onMessageReceive(message: Message) {
        println("SecondSubscriber ($name) received: '${message.messageContent}'")
    }
}

class ThirdSubscriber(val name: String) : Observer {
    override fun onMessageReceive(message: Message) {
        println("ThirdSubscriber ($name) received: '${message.messageContent}'")
    }
}

class MessagePublisher : Subject {
    private val observers = HashSet<Observer>()

    override fun registerObserver(observer: Observer) {
        observers.add(observer)
    }

    override fun unRegisterObserver(observer: Observer) {
        observers.remove(observer)
    }

    override fun notifyObserver(message: Message) {
        for (observer in observers) {
            observer.onMessageReceive(message)
        }
    }
}
