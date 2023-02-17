package LeetCode.List;

import java.util.List;
import java.util.Stack;

public class IsPalindrome {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        ListNode temp = head;
        Stack<ListNode> stack = new Stack<>();
        while (temp != null) {
            stack.push(temp);
            temp = temp.next;
        }

        while (head != null) {
            if (!stack.isEmpty() && stack.pop().val != head.val) {
                return false;
            }
            head = head.next;
        }
        return true;
    }
}
