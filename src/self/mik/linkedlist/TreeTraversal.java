package self.mik.linkedlist;

public class TreeTraversal {
    public void postOrder(Node root){
        if(root == null){
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.val+ " ");
        return;
    }
    public void preOrder(Node root){
        if(root == null){
            return;
        }
        System.out.println(root.val+ " ");
        preOrder(root.left);
        preOrder(root.right);
        return;
    }
    public void inOrder(Node root){
        if(root == null){
            return;
        }
        inOrder(root.left);
        System.out.println(root.val+ " ");
        inOrder(root.right);
        return;
    }


}
