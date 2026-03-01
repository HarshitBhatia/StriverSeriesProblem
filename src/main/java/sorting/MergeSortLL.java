package sorting;


public class MergeSortLL {
    public static void main(String[] args) {
        LL head=new LL(100);
        head.next=new LL(-100);
        head.next.next=new LL(-400);
        head.next.next.next=new LL(-1200);
        head.next.next.next.next=new LL(456);
        head.next.next.next.next.next=new LL(10);
        head.next.next.next.next.next.next=new LL(345);
        printLL(head);
        //Apply Merge Sort
        LL sortedHead= mergeSortLL(head);
        printLL(sortedHead);
    }

    private static LL mergeSortLL(LL head) {
        if(head==null  || head.next==null){
            return head;
        }
        LL mid=getMidNode(head);
        LL right=mid.next;
        mid.next=null;

        //Recursively Divide Left and Right Part
        LL leftLL=mergeSortLL(head);
        LL rightLL=mergeSortLL(right);
        return merge(leftLL,rightLL);
    }

    private static LL getMidNode(LL head) {
        LL slow=head;
        LL fast=head.next;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }

    public static LL merge(LL left, LL right){
        LL head=new LL(-1);
        LL dummy=head;
        while(left!=null && right!=null){
            if(left.val<=right.val){
                dummy.next=left;
                left=left.next;
            }
            else{
                dummy.next=right;
                right=right.next;
            }
            dummy=dummy.next;
        }
        while(left!=null){
            dummy.next=left;
            left=left.next;
            dummy=dummy.next;
        }
        while(right!=null){
            dummy.next=right;
            right=right.next;
            dummy=dummy.next;
        }
        return head.next;
    }

    private static void printLL(LL head)
    {
        LL node=head;
        while(node!=null){
            System.out.print(node.val+ " ");
            node=node.next;
        }
        System.out.println();
    }

}

class LL{
    int val;
    LL next;
    LL(int value){
        this.val=value;
        this.next=null;
    }
}
