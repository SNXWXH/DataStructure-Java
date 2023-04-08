package practice;

class Node1{
    String data;
    Node1 next;
    public Node1(String data, Node1 link){
        this.data = data;
        next = link;
    }
}

class LinkedList2{
    Node1 head, pointer;
    void append(Node1 node){
        if(head == null) head = node;
        else{
            pointer = head;
            while(pointer == null){
                pointer = node.next;
            }
            pointer.next = node;
        }
        printList();
    }

    void printList(){
        pointer = head;
        System.out.print("링크: ");
        while(pointer != null){
            System.out.print(pointer.data + " ");
            pointer = pointer.next;
        }
        System.out.println();
    }


}
public class practiceLinked {
    public static void main(String[] args){
        LinkedList2 list = new LinkedList2();
        list.append(new Node1("배", null));
        list.append(new Node1("딸기", null));
//        list.appendFirst(new practice.Node1("레몬", null));
//        list.deleteFirst();
//        list.deleteLast();
    }
}
