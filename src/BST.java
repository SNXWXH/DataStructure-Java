class TreeNode{
    int key;
    TreeNode left, right, parent;

    public TreeNode(int key){
        this.key = key;
        this.left = null;
        this.right = null;
        this.parent = null;
    }
}

public class BST {
    TreeNode root;
    //현재 노드키와 삽입할 노드 넘겨받기
    public void insert(TreeNode p, TreeNode node){
        if(p.key > node.key){
            if(p.left == null)
                p.left = node;
            else
                insert(p.left, node);
        }
        else{
            if(p.right == null)
                p.right = node;
            else
                insert(p.right,node);
        }
    }

    //메소드 오버라이딩
    public void insert(TreeNode node){
        if(root == null)
            root = node;
        else
            insert(root, node);
    }

    //트리가 잘 만들어졌는지 중위순회로 확인
    public void inorder(TreeNode node){
        if(node != null){
            inorder(node.left);
            System.out.print(node.key + " ");
            inorder(node.right);
        }
    }
    //특정 키가 있는지 조회
    public boolean searchNode(int key) {
        TreeNode p = root;
        while (p != null) {
            if (p.key == key)
                return true;
            else if (p.key > key)
                p = p.left;
            else
                p = p.right;
        }
        return false;
    }

    //   public int getMin(){
//        TreeNode p = root;
//        while(p!=null){
//            if(p.left != null)
//                p=p.left;
//            else
//                return p.key;
//        }
//        return p.key;
//    }

    public TreeNode getMin(TreeNode node){
        if(node.left == null)
            return node;
        else
            return getMin(node.left);
    }

//    public int getMax(){
//        TreeNode p = root;
//        while(p!=null){
//            if(p.right != null)
//                p=p.right;
//            else return p.key;
//        }
//        return p.key;
//    }
    public TreeNode getMax(TreeNode node){
        if(node.right == null)
            return node;
        else
            return getMax(node.right);
    }

//    public void delete(int key){
//        TreeNode p = search(key);
//        if(p==null) return;
//        delete(p, key);
//    }

    public void delete(TreeNode p, int key){
        TreeNode parent = p.parent;
        //자식이 없는 경우
        if(p.left == null && p.right == null){
            if(parent.left == p)
                parent.left = null;
            else
                parent.right = null;
        }
        //자식이 있는 경우
        else if(p.left == null || p.right == null){
            //왼쪽 자식이 있는 경우
            if(p.left != null){
                if(parent.left == p)
                    parent.left = p.left;
                else parent.right = p.left;
                p.left.parent = parent;
            }
            //오른쪽 자식이 있는 경우
            else{
                if(parent.left != p)
                    parent.left = p.right;
                else
                    parent.right = p.right;
                p.right.parent = parent;
            }
        }
        //자식이 둘 있는 경우
        else{
            TreeNode q = getMax(p.left);
            p.key = q.key;
            delete(p.left, p.key);
        }

    }


    public static void main(String[] args){
        BST t = new BST();
        t.insert(new TreeNode(18));
        t.insert(new TreeNode(7));
        t.insert(new TreeNode(26));
        t.insert(new TreeNode(3));
        t.insert(new TreeNode(12));
        t.insert(new TreeNode(31));
        t.insert(new TreeNode(1));
        t.insert(new TreeNode(27));
        t.inorder(t.root);
        int key = 12;
        if(t.searchNode(key))
            System.out.println("\n"+key+"는 트리에 존재합니다");
        else
            System.out.println("\n"+key+"는 트리에 없습니다.");

        System.out.println("제일 작은 값은 "+t.getMin(t.root).key);
        System.out.println("제일 큰 값은 "+t.getMax(t.root).key);
    }
}
