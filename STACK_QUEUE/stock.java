import java.util.*;
class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<Integer> stack = new Stack<>();

        for(int i=0;i< prices.length;i++){
            while(!stack.isEmpty()&&prices[i] < prices[stack.peek()]){//가격이 떨어진 시점
                answer[stack.peek()] = i - stack.peek();//각 인덱스마다 가격이 유지된 시간
                stack.pop();//가격이 떨어졌을때는 stack에서 꺼낸다.
            }
            stack.push(i);
        }
        
        while(!stack.isEmpty()){
            answer[stack.peek()] = prices.length - stack.peek() -1;
            stack.pop();
        }

        return answer;
    }
}
