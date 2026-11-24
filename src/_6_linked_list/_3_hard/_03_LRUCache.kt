package _6_linked_list._3_hard

/**
 * _03_LRUCache.kt
 * Implements a Least Recently Used (LRU) Cache in O(1) time using HashMap and Doubly Linked List (LeetCode #146).
 *
 * Beginner Explanation:
 * - HashMap provides O(1) key lookup.
 * - Doubly Linked List maintains usage order (Most Recently Used at head, Least Recently Used at tail).
 * - When capacity is exceeded, evict the tail node (LRU).
 *
 * Time Complexity: O(1) for get and put
 * Space Complexity: O(Capacity)
 */
fun main() {
    println("--- LRU Cache Demonstration ---")
    val lruCache = LRUCache(capacity = 2)

    lruCache.put(1, 1) // Cache is {1=1}
    lruCache.put(2, 2) // Cache is {1=1, 2=2}
    println("get(1): ${lruCache.get(1)}") // 1 (Cache is {2=2, 1=1})

    lruCache.put(3, 3) // Evicts key 2, Cache is {1=1, 3=3}
    println("get(2): ${lruCache.get(2)}") // -1 (Not found)

    lruCache.put(4, 4) // Evicts key 1, Cache is {3=3, 4=4}
    println("get(1): ${lruCache.get(1)}") // -1 (Not found)
    println("get(3): ${lruCache.get(3)}") // 3
    println("get(4): ${lruCache.get(4)}") // 4
}

class LRUCache(private val capacity: Int) {
    private class Node(val key: Int, var value: Int) {
        var prev: Node? = null
        var next: Node? = null
    }

    private val map = HashMap<Int, Node>()
    private val head = Node(0, 0)
    private val tail = Node(0, 0)

    init {
        head.next = tail
        tail.prev = head
    }

    fun get(key: Int): Int {
        val node = map[key] ?: return -1
        moveToHead(node)
        return node.value
    }

    fun put(key: Int, value: Int) {
        val node = map[key]
        if (node != null) {
            node.value = value
            moveToHead(node)
        } else {
            if (map.size >= capacity) {
                val lruNode = tail.prev!!
                removeNode(lruNode)
                map.remove(lruNode.key)
            }
            val newNode = Node(key, value)
            map[key] = newNode
            addNodeToHead(newNode)
        }
    }

    private fun addNodeToHead(node: Node) {
        node.next = head.next
        node.prev = head
        head.next?.prev = node
        head.next = node
    }

    private fun removeNode(node: Node) {
        val prevNode = node.prev
        val nextNode = node.next
        prevNode?.next = nextNode
        nextNode?.prev = prevNode
    }

    private fun moveToHead(node: Node) {
        removeNode(node)
        addNodeToHead(node)
    }
}
