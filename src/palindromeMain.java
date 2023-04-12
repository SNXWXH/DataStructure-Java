import java.util.Scanner;
import static java.lang.Character.toUpperCase;

class Stack01{
    char[] list;
    int size = 0;
    public Stack01(int len){
        list = new char[len];
    }
    void push(char item){
        list[size] = item;
        size++;
        printStack();
    }
    public char pop(){
        if(isEmpty()) {
            System.out.println("스택이 비어있습니다");
            return 0;
        }
        else{
            size--;
            char ch = list[size];
            return ch;
        }

    }
    boolean isEmpty(){
        return size == 0;
    }
    void printStack(){
        System.out.print("스택: ");
        for(int i = 0; i < size; i++){
            System.out.print(list[i]+" ");
        }
        System.out.println();
    }

}

class palindrome{
    char[] word;
    Stack01 list;

    //입력받은 문자열 전환 및 스택 배열 길이 지정
    public palindrome(String st){
        word = st.toCharArray();
        list = new Stack01(word.length/2);
    }

    public boolean palindromeCheck(){
        int start, end;
        //문자열의 길이가 짝수일때
        if(word.length%2 == 0){
            end = word.length/2 - 1;
            start = word.length/2;
        }
        //문자열 길이가 홀수일때
        else{
            end = word.length/2 - 1;
            start = word.length/2+1;
        }

        //스택에 하나씩 넣기
        System.out.println("*스택에 문자 하나씩 넣기*");
        for(int i = 0; i <= end; i++){
            list.push(word[i]);
        }
        System.out.println();

        //회문검사
        System.out.println("*회문검사 시작*");
        char temp;
        for(int i = start; i < word.length; i++){
                temp = list.pop();
                if(toUpperCase(temp) != toUpperCase(word[i])){
                    System.out.println(temp+" 와 "+word[i]+" 는 동일하지않습니다");
                    System.out.println();
                    return false;
                }
                System.out.println(temp+" 와 "+word[i]+" 는 동일합니다");
        }
        return true;
    }
}


public class palindromeMain {
    public static void main(String[] args){
        System.out.println("문자열을 입력해주세요");
        Scanner in = new Scanner(System.in);
        String st = in.nextLine();
        palindrome pd = new palindrome(st);
        if(pd.palindromeCheck()) {
            System.out.println();
            System.out.println(st + "는 회문검사에 통과하였습니다");
        }
        else{
            System.out.println();
            System.out.println(st+"는 회문검사에 통과하지 않습니다");
        }
    }
}
