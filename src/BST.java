

class TreeNode{
    int key;
    TreeNode left, right, parent;
    public TreeNode(int key){
        this.key = key;
        left = null;
        right = null;
        parent = null;
    }
}


public class BST {
    TreeNode root;
    public void insert(TreeNode node){
        if(root == null)
            root = node;
        else
            insert(root, node);
    }

    public void insert(TreeNode p, TreeNode node){
        if(p.key > node.key){
            if(p.left == null) {
                node.parent = p;
                p.left = node;
            }
            else
                insert(p.left, node);
        }
        else{
            if(p.right == null) {
                node.parent = p;
                p.right = node;
            }
            else
                insert(p.right, node);
        }
    }
    public void inorder(TreeNode node){
        if(node != null){
            inorder(node.left);
            System.out.print(node.key+" ");
            inorder(node.right);
        }
    }

    public TreeNode searchNode(int key){
        TreeNode point = root;
        while(point != null){
            if(point.key == key)
                return point;
            else if(point.key > key)
                point = point.left;
            else
                point = point.right;
        }
        return null;
    }

    public TreeNode getMin(TreeNode node){
        if(node.left == null)
            return node;
        else
            return getMin(node.left);
    }

    public TreeNode getMax(TreeNode node){
        if(node.right == null)
            return node;
        else return getMax(node.right);
    }

    public void delete(int key) {
        TreeNode node = searchNode(key);
        if(node==null)
            return;
        delete(node,key);
    }

    public void delete(TreeNode node, int key){
        TreeNode parent = node.parent;
        //자식이 없는 경우
        if(node.left == null && node.right == null){
            System.out.println("ddd " + node.parent);
            if(parent.left == node)
                parent.left = null;
            else
                parent.right = null;
        }
        //자식이 있는 경우
        else if(node.left == null || node.right == null){
            //왼쪽 자식이 있는 경우
            if(node.left != null){
                if(parent.left == node)
                    parent.left = node.left;
                else parent.right = node.left;
                node.left.parent = parent;
            }
            //오른쪽 자식이 있는 경우
            else{
                if(parent.left != node)
                    parent.left = node.right;
                else
                    parent.right = node.right;
                node.right.parent = parent;
            }
        }
        //자식이 둘 있는 경우
        else{
            TreeNode q = getMax(node.left);
            node.key = q.key;
            delete(node.left, node.key);
        }
    }

    public static void main(String[] args){
        BST t = new BST();
        t.insert(new TreeNode((18)));
        t.insert(new TreeNode(7));
        t.insert(new TreeNode(26));
        t.insert(new TreeNode(3));
        t.insert(new TreeNode(12));
        t.insert(new TreeNode(31));
        t.insert(new TreeNode(1));
        t.insert(new TreeNode(27));
        t.inorder(t.root);
        int key = 7;
        if(t.searchNode(key)!=null)
            System.out.println("\n"+key+"는 트리에 존재합니다");
        else
            System.out.println("\n"+key+"는 트리에 없습니다.");

        t.delete(key);
        t.inorder(t.root);
        System.out.println("제일 작은 값은 "+t.getMin(t.root).key);
        System.out.println("제일 큰 값은 "+t.getMax(t.root).key);
    }
}
