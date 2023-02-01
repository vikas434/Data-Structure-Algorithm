import java.util.ArrayList;

/**
 * You are given the heads of two sorted linked lists list1 and list2.
 *
 * Merge the two lists in a one sorted list. The list should be made by splicing together the nodes of the first two lists.
 *
 * Return the head of the merged linked list.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: list1 = [1,2,4], list2 = [1,3,4]
 * Output: [1,1,2,3,4,4]
 * Example 2:
 *
 * Input: list1 = [], list2 = []
 * Output: []
 * Example 3:
 *
 * Input: list1 = [], list2 = [0]
 * Output: [0]
 *
 *
 * Constraints:
 *
 * The number of nodes in both lists is in the range [0, 50].
 * -100 <= Node.val <= 100
 * Both list1 and list2 are sorted in non-decreasing order.
 */
public class P21MergeTwoSortedList {
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null && list2 == null) {
            return new ListNode();
        }
        ArrayList<Integer> mergedArrayList = new ArrayList<>();

        if(list1 == null) {
            return list2;
        } else if(list2 == null) {
            return list1;
        } else {
            while(list1.next != null && list2.next != null) {
                //TO
               if(list1.val <= list2.val) {
                   mergedArrayList.add(list1.val);
                   list1 = list1.next;
               } else {
                   mergedArrayList.add(list2.val);
                   list2 = list2.next;
               }
            }

            if(list1.next != null) {
                while(list1.next != null) {
                    mergedArrayList.add(list1.val);
                    list1 = list1.next;
                }
            } else {
                while(list2.next != null) {
                    mergedArrayList.add(list2.val);
                    list2 = list2.next;
                }
            }
        }
        //TODO - debug and fix mergedList value.
        ListNode mergedListNode = new ListNode();
        ListNode returningNode = new ListNode();
        var iterator = mergedArrayList.iterator();
        while (iterator.hasNext()) {
            mergedListNode.val = iterator.next();
            mergedListNode.next = new ListNode();
            returningNode = mergedListNode;
            mergedListNode = mergedListNode.next;
        }
        return returningNode;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        listNode1.next = new ListNode(2);
        listNode1.next.next = new ListNode(4);

        ListNode listNode2 = new ListNode(1);
        listNode2.next = new ListNode(3);
        listNode2.next.next = new ListNode(4);

        var listNodeMerged = mergeTwoLists(listNode1, listNode2);
        while (listNodeMerged.next != null) {
            System.out.println(listNodeMerged.val);
            listNodeMerged = listNodeMerged.next;
        }

    }
}
