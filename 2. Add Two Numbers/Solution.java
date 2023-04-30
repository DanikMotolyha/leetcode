/**
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order, and each of their nodes contains a single digit.
 * Add the two numbers and return the sum as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Input: l1 = [2,4,3], l2 = [5,6,4]
 * Output: [7,0,8]
 * Explanation: 342 + 465 = 807.
 *
 * Example 2:
 *
 * Input: l1 = [0], l2 = [0]
 * Output: [0]
 * Example 3:
 *
 * Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * Output: [8,9,9,9,0,0,0,1]
 */
import static java.lang.Integer.reverse;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode pointerL1 = l1;
        ListNode pointerL2 = l2;

        ListNode firstNode = new ListNode();
        ListNode pointerFirstNode = firstNode;

        int sum;
        boolean biggerThanEight = false;
        while (pointerL1 != null || pointerL2 != null || biggerThanEight) {
            sum = (biggerThanEight ? 1 : 0)
                    + (pointerL1 != null ? pointerL1.val : 0)
                    + (pointerL2 != null ? pointerL2.val : 0);
            biggerThanEight = sum > 9;

            pointerFirstNode.val = biggerThanEight ? (sum % 10) : sum;
            if ((pointerL1 != null && pointerL1.next != null)
                    || (pointerL2 != null && pointerL2.next != null)
                    || biggerThanEight) {
                ListNode nextNode = new ListNode();
                pointerFirstNode.next = nextNode;
                pointerFirstNode = nextNode;
            }

            pointerL1 = pointerL1 != null ? pointerL1.next : null;
            pointerL2 = pointerL2 != null ? pointerL2.next : null;
        }

        return firstNode;
    }
}
