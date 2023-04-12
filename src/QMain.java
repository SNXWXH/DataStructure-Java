class QList{
    //삽입 포인터
    int rear=-1;
    //삭제 포인터
    int front=-1;
    int[] arr = new int[3];

    public void enQueue(int item){
        if(rear+1 == arr.length)
            System.out.println("큐가 다 찼습니다");
        else
            arr[++rear] = item;
        //printQueue();
    }
    public int deQueue(){
        if(rear == front){
            System.out.println("큐가 비어있습니다");
            return 0;
        }
        int temp  = arr[++front];
        arr[front] = 0;
        //printQueue();
        return temp;
    }

    public void printQueue(){
        System.out.print("스택 => ");
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
}

public class QMain {
    public static void main(String[] args){
        QList q=new QList();
        q.enQueue(5);
        q.printQueue();
        q.enQueue(15);
        q.printQueue();
        q.deQueue();
        q.printQueue();
    }
}
