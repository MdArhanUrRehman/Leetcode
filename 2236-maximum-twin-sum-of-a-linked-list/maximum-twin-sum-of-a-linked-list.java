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
    public int pairSum(ListNode head) {
        List<Integer> ans = new ArrayList<>();

        ListNode temp = head;

        while(temp != null){
            ans.add(temp.val);
            temp = temp.next;
        }

        int max = 0;

        int n = ans.size();

        for(int i=0; i<n/2; i++){
            int eval = ans.get(i) + ans.get(n-i-1);
            max = Math.max(eval, max);
        }

        return max;
    }
}