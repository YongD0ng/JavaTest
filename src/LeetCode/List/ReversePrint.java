package LeetCode.List;

public class ReversePrint {
    public int[] reversePrint(ListNode head) {
        if (head == null) {
            return new int[0];
        }
        int cnt = 0;
        ListNode temp = head;
        while (temp != null) {
            ++cnt;
            temp = temp.next;
        }
        int[] res = new int[cnt];
        for (int i = res.length - 1; i >= 0; i--) {
            res[i] = head.val;
            head = head.next;
        }
        return res;
    }
}
