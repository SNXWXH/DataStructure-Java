class Node{
    String item;
    Node next;
    //생성자 만들기
    public Node (String item, Node link){
        this.item = item;
        next = link;
    }
}

class LinkedList1 {
    // 배열의 인덱스와 같은 point
    Node head,point;
    void append(Node node){
        //첫번째 노드라면 어떻게 해야할지
        if(head == null) {
            head = node;
        }else{
            point = head;
            while(point.next != null){
                point = point.next;
            }
            point.next = node;
        }
        printList();
    }

    void appendFirst(Node node){
        node.next = head;
        head = node;
    }
    void deleteFirst(){
            head = head.next;
            printList();
    }
    void deleteLast(){
        if(head == null) System.out.println("연결리스트가 비어있습니다");
        else{
           point = head;
           Node temp = point;
           while(point.next != null){
               temp = point;
               point = point.next;
           }
           temp.next = null;
        }
        printList();
    }

    boolean searchNode(String item){
        point = head;
        while (point.next != null){
            if(point.item.equals(item)) return true;
            point = point.next;
        }
        return false;
    }

    void printList( ){
        point = head;
        System.out.print("리스트 : ");
        while(point != null){
            System.out.print(point.item+ "  ");
            point = point.next;
        }
        System.out.println();
    }
}

public class MainLinkedList {
    public static void main(String[] args){
        LinkedList1 list = new LinkedList1();
        list.append(new Node("배", null));
        list.append(new Node("사과", null));

        if(list.searchNode("배")) System.out.println("존재합니다");
        else System.out.println("존재하지 않습니다.");
        if(list.searchNode("망고")) System.out.println("존재합니다");
        else System.out.println("존재하지 않습니다.");

        list.appendFirst(new Node("딸기", null));
        list.append(new Node("오렌지", null));

        list.deleteFirst();
        list.deleteLast();
    }
}
