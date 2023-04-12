//import java.util.Scanner;
//
//class StackList2{
//    char[] list;
//    int size = 0;
//
//    public StackList2(int len){
//        list = new char[len];
//    }
//    public void push(char ch){
//        list[size] = ch;
//        size++;
//    }
//    public char pop(){
//        if(isEmpty()) {
//            System.out.println("스택이 비어있습니다");
//            return 0;
//        }
//        else{
//            size--;
//            char ch = list[size];
//            return ch;
//        }
//    }
//
//    public void printStack(String state) {
//        System.out.print("스택 리스트(" + state + ")");
//        for(int i = 0; i < size; i++){
//            System.out.print(list[i] + " ");
//            System.out.println();
//        }
//    }
//    boolean isEmpty(){
//        if(size == 0)
//            return true;
//        else
//            return false;
//    }
//}
//class PostExp{
//    //스택
//    StackList2 list;
//    //중위수식 문자열
//    char[] arr;
//    //후위수식 문자열
//    String postExp="";
//    public PostExp(String str){
//        arr = str.toCharArray();
//        list = new StackList2(arr.length);
//    }
//    public String makePost(){
//
//        for(int i = 0; i < arr.length; i++){
//            switch (arr[i]){
//                case '(' :
//                    list.push('(');
//                    break;
//                case ')':
//                    while(true){
//                        char ch = list.pop();
//                        if(ch == '(')
//                            break;
//                        else
//                            postExp += ch;
//                    }
//                    break;
//                case '+', '-', '*', '/':
//                    useStack(arr[i]);
//                    break;
//                default:
//                    postExp += arr[i];
//            }
//        }
//        while(!list.isEmpty()){
//            char ch = list.pop();
//            postExp += ch;
//        }
//        return postExp;
//    }
//    public void useStack(char ch) {
//        if(list.isEmpty())
//            list.push(ch);
//        else{
//            char ls = list.pop();
//            if(ls == '('){
//                list.push(ls);
//                list.push(ch);
//            }
//            else{
//                list.push(ls);
//                while (!list.isEmpty()){
//                    char op = list.pop();
//                    int opOrder = returnOrder(op);
//                    int chOrder = returnOrder(ch);
//                    if(opOrder >= chOrder) postExp += op;
//                    else {
//                        list.push(op);
//                        break;
//                    }
//                }
//                list.push(ch);
//            }
//
//        }
//
//    }
//    public int returnOrder(char x){
//        if(x=='(' || x==')')
//            return 0;
//        if(x == '+' || x == '-')
//            return 1;
//        else return 2;
//    }
//}
//public class PostMain {
//    public static void main(String[] args){
//        System.out.println("수식을 입력합니다");
//        Scanner in = new Scanner(System.in);
//        String exp = in.nextLine();
//        PostExp ex = new PostExp(exp);
//        String post = ex.makePost();
//        System.out.println("중위수식: "+exp+", 후위수식: "+post);
//
//        //Cal = new Cal(post);
//    }
//}

import java.util.Scanner;
class StackList3{
    int[] list;
    int size = 0;

    public StackList3(int len){
        list = new int[len];
    }
    public void push(int ch){
        list[size] = ch;
        size++;
        printStack("push");
    }
    public int pop(){
        if(isEmpty()) {
            System.out.println("스택이 비어있습니다");
            return 0;
        }
        else{
            size--;
            int ch = list[size];
            printStack("pop");
            return ch;
        }

    }

    public void printStack(String state) {
        System.out.print("스택 리스트(" + state + ")");
        for(int i = 0; i < size; i++){
            System.out.print(list[i] + " ");
            System.out.println();
        }
    }
    boolean isEmpty(){
        if(size == 0)
            return true;
        else
            return false;
    }
}
class Cal{
    StackList3 list;
    char[] arr;
    public Cal(String str){
        arr = str.toCharArray();
        list = new StackList3(arr.length);
    }
    public int getResult(){

        for(int i = 0; i < arr.length; i++){
            switch (arr[i]){
                case '+', '-', '*', '/':
                    calculate(arr[i]);
                    break;
                default:
                    int num=Character.digit(arr[i],10);
                    list.push(num);
                    break;
            }
        }
        return list.pop();
    }
    public void calculate(char ch) {
        int num2 = list.pop();
        int num1 = list.pop();
        int r;
        if(ch=='+')
            r=num1+num2;
        else if (ch=='-')
            r=num1-num2;
        else if (ch=='*')
            r=num1*num2;
        else r=num1/num2;
        list.push(r);

    }
    public int returnOrder(char x){
        if(x=='(' || x==')')
            return 0;
        else if(x == '+' || x == '-')
            return 1;
        else return 2;
    }
}

class StackList2{
    char[] list;
    int size = 0;

    public StackList2(int len){
        list = new char[len];
    }
    public void push(char ch){
        list[size] = ch;
        size++;
        printStack("push");
    }
    public char pop(){
        if(isEmpty()) {
            System.out.println("스택이 비어있습니다");
            return 0;
        }
        else{
            size--;
            char ch = list[size];
            printStack("pop");
            return ch;
        }
    }

    public void printStack(String state) {
        System.out.print("스택 리스트(" + state + ")");
        for(int i = 0; i < size; i++){
            System.out.print(list[i] + " ");
            System.out.println();
        }
    }
    boolean isEmpty(){
        if(size == 0)
            return true;
        else
            return false;
    }
}
class PostExp{
    //스택
    StackList2 list;
    //중위수식 문자열
    char[] arr;
    //후위수식 문자열
    String postExp="";
    public PostExp(String str){
        arr = str.toCharArray();
        list = new StackList2(arr.length);
    }
    public String makePost(){

        for(int i = 0; i < arr.length; i++){
            switch (arr[i]){
                case '(' :
                    list.push('(');
                    break;
                case ')':
                    char ch;
                    while((ch= list.pop()) != '('){
                        postExp+=ch;
                    }
                    break;
                case '+', '-', '*', '/':
                    useStack(arr[i]);
                    break;
                default:
                    postExp += arr[i];
            }
        }
        while(!list.isEmpty()){
            char ch = list.pop();
            postExp += ch;
        }
        return postExp;
    }
    public void useStack(char ch) {
        if(list.isEmpty())
            list.push(ch);
        else{
                while (!list.isEmpty()){
                    char op = list.pop();
                    int opOrder = returnOrder(op);
                    int chOrder = returnOrder(ch);
                    if(opOrder >= chOrder) postExp += op;
                    else {
                        list.push(op);
                        break;
                    }
                }
                list.push(ch);


        }

    }
    public int returnOrder(char x){
        if(x=='(' || x==')')
            return 0;
        else if(x == '+' || x == '-')
            return 1;
        else return 2;
    }
}
public class PostMain {
    public static void main(String[] args){
        System.out.println("수식을 입력합니다");
        Scanner in = new Scanner(System.in);
        String exp = in.nextLine();
        PostExp ex = new PostExp(exp);
        String post = ex.makePost();
        System.out.println("중위수식: "+exp+", 후위수식: "+post);

        Cal cal = new Cal(post);
        System.out.println("결과는 ==> "+cal.getResult());
    }
}
