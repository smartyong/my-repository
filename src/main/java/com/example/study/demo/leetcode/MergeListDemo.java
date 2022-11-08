package com.example.study.demo.leetcode;

public class MergeListDemo {

    public static void main(String[] args) {
        ListNode list1=new ListNode(1);
        list1.next=new ListNode(2);
        list1.next.next=new ListNode(4);

        ListNode list2=new ListNode(1);
        list2.next=new ListNode(3);
        list2.next.next=new ListNode(4);
        mergeTwoLists(list1,list2);

    }
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode newNode=new ListNode();
        ListNode curr=newNode.next;
        while(list1!=null){
            while(list2!=null){
                if(list1.val<=list2.val){
                    curr=new ListNode(list1.val);
                }else{
                    curr=new ListNode(list2.val);
                }
                list2=list2.next;
                curr=curr.next;
            }
            list1=list1.next;
        }
        return newNode.next;
    }


}
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
