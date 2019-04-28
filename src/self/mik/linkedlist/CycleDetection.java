package self.mik.linkedlist;

public class CycleDetection {
    public boolean cycleExists(Node root){
        if(root == null){
            return false;
        }
        Node fast = root;
        Node slow =root;
        int i = 1;
        while(fast != null){
            if(fast.next != null){
                fast = fast.next;
            }
            if(i%2 == 0){
                if(slow.next != null){
                    slow = slow.next;
                }
            }
            if(fast == slow){
                return true;
            }
        }
        return false;
    }
}
