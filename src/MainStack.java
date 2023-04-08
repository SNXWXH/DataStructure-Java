class StackList{
    String[] list = new String[10];
    int size;
    void push(String item){
        list[size] = item;
        size++;
        printStack();
    }
    void pop(){
        if(isEmpty()) System.out.println("스택이 비어있습니다");
        else size--;
        printStack();
    }
    boolean isEmpty(){
        if(size == 0) return true;
        else return false;
    }
    void printStack(){
        System.out.print("스택: ");
        for(int i = 0; i < size; i++){
            System.out.print(list[i]+" ");
        }
        System.out.println();
    }
}
public class MainStack {
    public static void main(String[] args){
        StackList st = new StackList();
        st.push("사과");
        st.push("배");
        st.pop();
        st.push("오렌지");
        st.push("망고");
        st.pop();
    }
}
