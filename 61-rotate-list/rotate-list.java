class Solution {

    private ListNode reverse(ListNode head){
        ListNode curr = head;
        ListNode prev = null;

        while(curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null || k == 0){
            return head;
        }

        // find length
        int n = 0;
        ListNode temp = head;
        while(temp != null){
            n++;
            temp = temp.next;
        }

        k = k % n;
        if(k == 0) return head;

        // 1. reverse whole list
        head = reverse(head);

        // 2. split first k nodes
        ListNode curr = head;
        for(int i = 1; i < k; i++){
            curr = curr.next;
        }

        ListNode left = head;
        ListNode right = curr.next;
        curr.next = null;

        // 3. reverse both parts
        left = reverse(left);
        right = reverse(right);

        // 4. join
        ListNode tail = left;
        while(tail.next != null){
            tail = tail.next;
        }

        tail.next = right;

        return left;
    }
}