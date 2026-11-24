package _6_linked_list._3_hard

import _6_linked_list._1_easy.ListNode

/**
 * _01_IntersectionPointOfTwoLinkedLists.kt
 * Finds the node where two singly linked lists intersect (LeetCode #160).
 *
 * Beginner Explanation:
 * Two Pointers Trick:
 * Pointer `pA` starts at headA, pointer `pB` starts at headB.
 * When a pointer reaches the end of its list, redirect it to the head of the OTHER list.
 * Both pointers will travel equal total distance `lenA + lenB` and meet at the intersection node!
 *
 * Time Complexity: O(N + M)
 * Space Complexity: O(1)
 */
fun main() {
    val common = ListNode(8)
    common.next = ListNode(4)
    common.next?.next = ListNode(5)

    val headA = ListNode(4)
    headA.next = ListNode(1)
    headA.next?.next = common

    val headB = ListNode(5)
    headB.next = ListNode(6)
    headB.next?.next = ListNode(1)
    headB.next?.next?.next = common

    println("--- Intersection Point of Two Linked Lists ---")
    val intersectionNode = getIntersectionNode(headA, headB)
    println("Intersection Node Data: ${intersectionNode?.data}")
}

fun getIntersectionNode(headA: ListNode?, headB: ListNode?): ListNode? {
    if (headA == null || headB == null) return null

    var pA = headA
    var pB = headB

    while (pA != pB) {
        pA = if (pA == null) headB else pA.next
        pB = if (pB == null) headA else pB.next
    }

    return pA
}
