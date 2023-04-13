package practice;

class BtNode{
    char data;
    //생성자 생성
    BtNode right;
    BtNode left;
}
class LinkedTree{
    public BtNode makeTree(BtNode left, char data, BtNode right){
        BtNode node = new BtNode();
        node.left = left;
        node.data = data;
        node.right = right;
        return node;
    }
    public void preorder(BtNode node){
        if(node != null){
            System.out.print(node.data+" ");
            preorder(node.left);
            preorder(node.right);
        }
//        System.out.print(node.data+" ");
//        if(node.left != null) preorder(node.left);
//        if(node.right != null)preorder(node.right);
    }
    public void inorder(BtNode node){
        if(node != null){
            if(node.left != null) inorder(node.left);
            System.out.print(node.data+" ");
            if(node.right != null)inorder(node.right);
        }
//        if(node.left != null) inorder(node.left);
//        System.out.print(node.data+" ");
//        if(node.right != null)inorder(node.right);
    }
    public void postorder(BtNode node){
        if(node != null){
            if(node.left != null) postorder(node.left);
            if(node.right != null)postorder(node.right);
            System.out.print(node.data+" ");
        }
//        if(node.left != null) postorder(node.left);
//        if(node.right != null)postorder(node.right);
//        System.out.print(node.data+" ");
    }
}

public class Ex_BT1 {
    public static void main(String[] args){
        LinkedTree t = new LinkedTree();
        BtNode n4 = t.makeTree(null, 'D', null);
        BtNode n5 = t.makeTree(null, 'E', null);
        BtNode n6 = t.makeTree(null, 'F', null);
        BtNode n2 = t.makeTree(n4, 'B', n5);
        BtNode n3 = t.makeTree(null, 'C', n6);
        BtNode n1 = t.makeTree(n2, 'A', n3);
        System.out.print("PreOrder ==> ");
        t.preorder(n1);
        System.out.println();
        System.out.print("InOrder ==> ");
        t.inorder(n1);
        System.out.println();
        System.out.print("PostOrder ==> ");
        t.postorder(n1);
        System.out.println();
    }
}
