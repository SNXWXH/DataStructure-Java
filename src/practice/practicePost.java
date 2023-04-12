package practice;

import java.util.Scanner;

class Stack4{
    char[] list;
    int size = 0;

    public Stack4(int len){
        list = new char[len];
    }

    public void push(char item){
        list[size] = item;
        size++;
    }

    public char pop(){
        if(isEmpty()){
            System.out.println("배열이 비었습니다.");
            return 0;
        }else{
            size--;
            return list[size];
        }
    }

    public boolean isEmpty(){
        if(size == 0)
            return true;
        else
            return false;
    }
}

class PostExp1{
    char[] arr;
    Stack4 list;
    public PostExp1(String exp){
       arr = exp.toCharArray();
       list = new Stack4(arr.length);
    }

    // 중위를 후위로 전환시키는 함수
    public String makePost(){
        String st="";
        for(int i = 0; i < arr.length; i++){
            switch (arr[i]){
                case '+','-':
                    if(list.isEmpty())
                        list.push(arr[i]);
                    else{
                        while(!list.isEmpty()) {
                            char ch = list.pop();
                            st += ch;
                        }
                        list.push(arr[i]);
                    }
                    break;
                case '*','/':
                    if(list.isEmpty())
                        list.push(arr[i]);
                    else{
                        char ch = list.pop();
                        if(ch == '*' || ch =='/'){
                            st+= ch;
                            list.push(arr[i]);
                        }else{
                            list.push(ch);
                            list.push(arr[i]);
                        }
                    }
                    break;
                default:
                    st += arr[i];
                    break;
            }
        }
        while(!list.isEmpty()){
            st += list.pop();
        }
        return st;
    }

}
public class practicePost {
    public static void main(String[] args){
        System.out.println("수식을 입력합니다");
        Scanner in = new Scanner(System.in);
        String exp = in.nextLine();
        PostExp1 ex = new PostExp1(exp);
        String post = ex.makePost();
        System.out.println("중위수식: "+exp+", 후위수식: "+post);
    }
}
