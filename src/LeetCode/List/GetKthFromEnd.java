package LeetCode.List;

public class GetKthFromEnd {
    public ListNode getKthFromEnd(ListNode head, int k) {
        int cnt = 0;
        ListNode temp = head;
        while (temp != null) {
            cnt++;
            temp = temp.next;
        }

        if (head == null || cnt < k) {
            return null;
        }
        // 正数 cnt - k + 1 个

        int sum = 0;
        while (head != null) {
            sum++;
            if (sum == (cnt - k + 1)) {
                return head;
            }
            head = head.next;
        }
        return null;
    }
}
