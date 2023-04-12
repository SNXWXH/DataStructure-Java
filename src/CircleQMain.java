class QList01{
    //삽입 포인터
    int rear = 0;
    //삭제 포인터
    int front = 0;
    int[] arr = new int[3];

    public void enQueue(int item){
        if((front%arr.length) == (rear+1)%arr.length)
            System.out.println("큐가 다 찼습니다");
        else{
            rear = (rear +1)%arr.length;
            //System.out.println(rear);
            arr[rear] = item;
        }
    }
    public int deQueue(){
        if(rear == front){
            System.out.println("큐가 비어있습니다");
            return 0;
        }
        front = (front+1)%arr.length;
        int temp  = arr[front];
        //System.out.println(temp);
        //System.out.println(front);
        arr[front] = 0;
        //printQueue();
        return temp;
    }

    public void printQueue(){
        System.out.print("큐 => ");
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
}

public class CircleQMain {
    public static void main(String[] args){
        QList01 q=new QList01();
        q.enQueue(5);
        q.printQueue();
        q.enQueue(15);
        q.printQueue();
        q.deQueue();
        q.printQueue();
        q.enQueue(3);
        q.printQueue();
        q.enQueue(9);
        q.printQueue();
        q.enQueue(2);
        q.printQueue();
        q.deQueue();
        q.printQueue();
        q.deQueue();
        q.printQueue();
        q.enQueue(7);
        q.printQueue();
    }
}
