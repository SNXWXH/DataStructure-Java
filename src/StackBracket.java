import java.util.Scanner;
import java.util.Stack;

class StackList1{
    char[] stack;
    int size;
    public StackList1(int len){
        stack = new char[len];
        size = 0;
    }
    public void push(char ch){
        stack[size] = ch;
        size++;
    }
    public char pop(){
        if(isEmpty()) {
            System.out.println("스택이 비어있습니다");
            return 0;
        }
        else{
            size--;
            char ch = stack[size];
            return ch;
        }

    }
    boolean isEmpty(){
        if(size == 0)
            return true;
        else
            return false;
    }
}

class Exp{
    StackList1 list;
    char[] arr;

    public Exp(String exp){
        //1. 문자열을 쪼개서 arr로 만들기
        arr = exp.toCharArray();
        //2. stack 생성하기
        list = new StackList1(arr.length);
    }

    public Boolean test(){
        char ch;
        for(int i = 0; i < arr.length; i++){
            if((arr[i]=='(') || (arr[i]=='{') || (arr[i]=='[')){
                list.push(arr[i]);
            } else if ((arr[i]==')') || (arr[i]=='}') || (arr[i]==']')) {
                ch = list.pop();
                if(compare(ch, arr[i])==false) return false;
            }
        }
        if(list.isEmpty()) return true;
        else return false;
    }
    public boolean compare(char openCh, char closeCh){
        if(openCh =='(' && closeCh == ')') return true;
        if(openCh =='{' && closeCh == '}') return true;
        if(openCh =='[' && closeCh == ']') return true;
        return false;
    }
}

public class StackBracket {
    public static void main(String[] args){
        System.out.println("수식을 입력합니다");
        Scanner in = new Scanner(System.in);
        String exp = in.nextLine();
        Exp ex = new Exp(exp);
        if(ex.test())
            System.out.println(exp+"는 괄호 짝이 맞음");
        else
            System.out.println(exp+"는 괄호 짝이 안맞음");
    }
}
