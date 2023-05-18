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
        heap[size] = item;
        int i = size;
        int parent = size / 2;
        while (parent > 0 && heap[parent] < heap[i]){
            int temp = heap[parent];
            heap[parent] = heap[i];
            heap[i] = temp;
            i = i/2;
            parent = parent/2;
        }
        size++;
    }

    public int find(){
        return heap[1];
    }

    public void delete(){
        heap[1] = h[size -1];
        i = 1;
        while(){
            int left = 2*i;
            int right=  2*i+1;
            if(heap[i] <heap[left] || heap[i]<heap[right]){
                if(heap[left] > heap[right]){
                    int temp = heap[i];
                    heap[i] = heap[left];
                    heap[left] = temp;
                }
            }
            else
                break;
        }
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
        int[] arr = {0,95,80,65,60,40,30,10,35};
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
        h2.print();
    }
}
