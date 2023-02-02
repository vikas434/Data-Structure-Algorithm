import java.util.HashSet;
import java.util.Set;

public class P141LinkedListCycle {

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null ) {
            return false;
        }

        var slow = head;
        var fast = head;

        while (fast != null  && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast) {
                return true;
            }
        }
        return false;
    }

    public boolean hasCycleWithHashSet(ListNode head) {
        Set<ListNode> nodeSet = new HashSet<ListNode>();
        while(head != null && head.next != null) {
            if(nodeSet.contains(head)) {
                return true;
            } else {
                nodeSet.add(head);
            }
            head = head.next;
        }
        return false;
    }
}
