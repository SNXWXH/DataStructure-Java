package practice;

import java.util.Scanner;
class stack3{
    char[] list;
    int size=0;
    public stack3(int len){
        list = new char[len];
    }

    public void push(char ch){
        list[size] = ch;
        size++;
    }
    //  마지막 값을 리턴
    public  char pop(){
        if(isEmpty()){
           return 0;
        }
        else{
            size--;
            return list[size];
        }
    }
    public boolean isEmpty(){
        if(size == 0){
            System.out.println("배열이 없어여");
            return true;
        }
        else return false;

    }
}

class Exp1{
    char[] arr;
    stack3 st;
    public Exp1(String exp){
        arr = exp.toCharArray();
        st = new stack3(arr.length);
    }
    boolean test1(){
        for(int i = 0; i < arr.length; i++){
            if((arr[i]=='(') || (arr[i]=='{') || (arr[i]=='[')) {
                st.push(arr[i]);
            } else if ((arr[i]==')') || (arr[i]=='}') || (arr[i]==']')) {
                if(compare(st.pop(),arr[i]) == false) return false;
            }
        }
        if(st.isEmpty()) return true;
        else return false;
    }
    boolean compare(char open, char close){
        if(open =='(' && close ==')') return true;
        if(open =='{' && close =='}') return true;
        if(open =='[' && close ==']') return true;
        return false;
    }
}

public class practiceBracket {
    public static void main(String[] args){
        System.out.println("수식을 입력하세요");
        Scanner in = new Scanner(System.in);
        String exp = in.nextLine();
        Exp1 ex = new Exp1(exp);
        if(ex.test1())
            System.out.println("괄호 짝이 맞음");
        else
            System.out.println("괄호 짝이 맞지 않음");
    }
}
