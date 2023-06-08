class Heap{
    int[] heap = new int[50];
    int size;
    public Heap(int[] arr){
        size = arr.length;
        System.arraycopy(arr,0,heap,0,size);
    }

    public Heap(){
        size = 1;
    }
    public void insert(int item){
        // 제일 마지막 위치에 저장
        heap[size] = item;
        int i = size;
        int parent = size / 2;
        while (parent > 0 && heap[parent] < heap[i]){
            //swap
            int temp = heap[parent];
            heap[parent] = heap[i];
            heap[i] = temp;
            i = i/2;
            parent = parent/2;
        }
        size++;
    }


    //힙에서 가장 큰 원소 반환
    public int find(){
        //힙에서 가장 큰 원소는 항상 루트에 위치하므로
        return heap[1];
    }

    //힙에서 가장 큰 원소 삭제
    public void delete(){
        heap[1] = heap[size -1];
        int i = 1;
        int child = size/2;
        while(i<child) {
            int left=2*i;
            int right=2*i+1;
            if(heap[i] < heap[left] || heap[i]<heap[right]) {
                if(heap[left] > heap[right]) {
                    int temp=heap[i];
                    heap[i]=heap[left];
                    heap[left]=temp;
                    i=2*i;
                }else {
                    int temp=heap[i];
                    heap[i]=heap[right];
                    heap[right]=temp;
                    i=2*i+1;
                }
            }
            else   //현재 노드의 자식노드가 힙 노드보다 작을경우 종료?
                break;
        }
        size--;
    }

    public void print(){
        System.out.println("힙 배열");
        for(int i = 1; i < size; i++)
            System.out.print(heap[i]+" ");
        System.out.println();
    }
}

public class Ex11 {
    public static void main(String[] args){
        int[] arr = {0,95,80,65,50,60,40,30,10,35,20,25,15};
        Heap h1 = new Heap(arr);
        h1.insert(70);
        h1.print();
        h1.insert(100);
        h1.print();
        Heap h2 = new Heap();
        h2.insert(10);
        h2.insert(50);
        h2.insert(20);
        h2.insert(60);
        h2.insert(30);
        h2.insert(70);
        h2.insert(40);
        h2.insert(80);
        System.out.println("빈 트리에서 시작");
		 h2.print();
		 System.out.println("최대값 ==> "+h1.find());
		 System.out.println("최대값 ==> "+h2.find());
//        h1.delete();
//        h1.delete();

        h2.print();
    }
}
