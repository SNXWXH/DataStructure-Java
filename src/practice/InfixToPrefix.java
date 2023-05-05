package practice;

import java.util.Stack;

public class InfixToPrefix {

    public static String infixToPrefix(String infix) {
        Stack<Character> stack = new Stack<Character>();
        StringBuilder prefix = new StringBuilder();

        // 중위표기법 문자열을 뒤에서부터 순회합니다.
        for (int i = infix.length() - 1; i >= 0; i--) {
            char c = infix.charAt(i);

            // 연산자인 경우 스택에 저장합니다.
            if (isOperator(c)) {
                while (!stack.isEmpty() && stack.peek() != ')' && hasHigherPrecedence(stack.peek(), c)) {
                    prefix.append(stack.pop());
                }
                stack.push(c);
            }
            // 괄호의 경우 스택에 저장합니다.
            else if (c == ')') {
                stack.push(c);
            } else if (c == '(') {
                while (!stack.isEmpty() && stack.peek() != ')') {
                    prefix.append(stack.pop());
                }
                stack.pop();
            }
            // 피연산자의 경우 바로 prefix 문자열에 추가합니다.
            else {
                prefix.append(c);
            }
        }

        // 스택에 남아있는 모든 연산자를 prefix 문자열에 추가합니다.
        while (!stack.isEmpty()) {
            prefix.append(stack.pop());
        }

        // 문자열을 뒤집어서 전위표기법으로 변환합니다.
        return prefix.reverse().toString();
    }

    // 연산자인지 확인하는 메서드
    public static boolean isOperator(char c) {
        return (c == '+' || c == '-' || c == '*' || c == '/');
    }

    // 우선순위 비교 메서드
    public static boolean hasHigherPrecedence(char op1, char op2) {
        if (op2 == '(' || op2 == ')') {
            return false;
        }
        if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-')) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String infix = "A+B*C-D";
        String prefix = infixToPrefix(infix);
        System.out.println(prefix); // +A-*BCD
    }
}
