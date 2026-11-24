package _6_linked_list._1_easy

/**
 * _05_MiddleOfLinkedList.kt
 * Finds the middle node of a Linked List using Tortoise and Hare pointers (LeetCode #876).
 *
 * Beginner Explanation:
 * Maintain `slow` pointer (moves 1 step) and `fast` pointer (moves 2 steps).
 * When `fast` reaches end, `slow` is at the middle node!
 *
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 */
fun main() {
    val head = ListNode(1)
    head.next = ListNode(2)
    head.next?.next = ListNode(3)
    head.next?.next?.next = ListNode(4)
    head.next?.next?.next?.next = ListNode(5)

    println("--- Middle Node of Linked List ---")
    printLinkedList(head)

    val middleNode = findMiddleNode(head)
    println("Middle Node Data: ${middleNode?.data}")
}

fun findMiddleNode(head: ListNode?): ListNode? {
    var slow = head
    var fast = head

    while (fast?.next != null) {
        slow = slow?.next
        fast = fast.next?.next
    }

    return slow
}
