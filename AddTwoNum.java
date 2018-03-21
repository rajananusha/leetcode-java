/*
Add Two Numbers - LinkedList
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.
*/

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) { 
		val = x; 
	}

	static ListNode createListFromInt(int number){
		if(number == 0 || number < 0){
			return new ListNode(0);
		}
		ListNode list = new ListNode(0);

		ListNode l = list;
		while(number > 0){
			l.next = new ListNode(number % 10);
			number = number / 10;
			l = l.next;
		}
		return list.next;

	}

	static void printListNode(ListNode listNode){
		ListNode l = listNode;
		while(l != null){
			System.out.println(l.val);
			l = l.next;
		}
	}

	static boolean compareLists(ListNode l1, ListNode l2){

		while(l1 != null || l2 != null){
			if(l1 == null || l2 == null || l1.val != l2.val)
				return false;
			l1 = l1.next;
        	l2 = l2.next;
		}
		return true;
	}
}

public class AddTwoNum {

    public static ListNode addtwonumbers (ListNode l1, ListNode l2) {
        ListNode answer = new ListNode(0);
        ListNode head = answer;
        int carry = 0;
        while(l1 != null || l2 != null || carry != 0){
        	int sum = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + carry;
        	carry = sum / 10;
        	answer.next = new ListNode(sum % 10);
        	answer = answer.next;
        	l1 = (l1 == null ? l1 : l1. next);
        	l2 = (l2 == null ? l2 : l2. next);
        }
        return head.next;
    }

    public static void main(String[] args) {

    	// Testcase 1

        ListNode l1 = ListNode.createListFromInt(342);
        ListNode l2 = ListNode.createListFromInt(465);
        ListNode expectedList = ListNode.createListFromInt(807);
        ListNode actualList = addtwonumbers(l1, l2);
        String result = ListNode.compareLists(expectedList, actualList) ? "Passed" : "Failed";
        System.out.println(result);
        // ListNode.printListNode(actualList);

        // Testcase 2

        l1 = ListNode.createListFromInt(5);
        l2 = ListNode.createListFromInt(5);
        expectedList = ListNode.createListFromInt(10);
        actualList = addtwonumbers(l1, l2);
        result = ListNode.compareLists(expectedList, actualList) ? "Passed" : "Failed";
        System.out.println(result);
        // ListNode.printListNode(actualList);
        

    }
}