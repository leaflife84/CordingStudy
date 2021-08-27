package Naver;

import java.util.Stack;

public class Test2 {
    public static void main(String[] args) {
        Test2 t = new Test2();
        System.out.println(t.solution("1 2 3"));

    }
    public int solution(String S) {
        if(S.length() == 0){
            return -1;
        }
        Stack<Integer> stack = new Stack<>();
        String[] cal = S.split(" ");
        for (int i = 0; i < cal.length; i++) {
            String s = cal[i];
            if(s.equals("POP")){
                if(stack.size() < 1){
                    return -1;
                }
                stack.pop();
            }else if(s.equals("DUP")){
                if(stack.size() < 1){
                    return -1;
                }
                stack.push(stack.peek());
            }else if(s.equals("+")){
                if(stack.size() < 2){
                    return -1;
                }
                stack.push(stack.pop() + stack.pop());
            }else if(s.equals("-")){
                if(stack.size() < 2){
                    return -1;
                }
                stack.push(stack.pop() - stack.pop());
            }else{
                int number = Integer.parseInt(s);
                stack.push(number);
            }
        }
        return stack.pop();
    }
}
