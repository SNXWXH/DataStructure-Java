class Node_B1{
    char data;
    //생성자 생성
    Node_B1 right;
    Node_B1 left;

    public Node_B1 (char d){
        data = d;
    }
}


public class BT1 {
    public static void main(String[] args){
        //단말노드 메소드
        Node_B1 g = new Node_B1('G');
        Node_B1 h = new Node_B1('H');
        Node_B1 f = new Node_B1('F');
        //부모노드 메소드
        Node_B1 d = new Node_B1('D');
        d.right = g;
        Node_B1 e = new Node_B1('E');
        e.left = h;
        Node_B1 c = new Node_B1('C');
        c.right = f;
        Node_B1 b = new Node_B1('B');
        b.left = d;
        b.right = e;
        Node_B1 a = new Node_B1('A');
        a.left = b;
        a.right = c;
    }
}
