import java.util.*;
class Solution {
    public int solution(int[] priorities, int location) {
       int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder()); //최대값 기준 우선순위
        //ps. Priority Queue는 그냥 만들면 최소값 기준으로 우선순위 된다.
        for(int priority : priorities) {
            pq.offer(priority);
        }
        //우선순위 큐에 담는다.
 
        while(!pq.isEmpty()) {
            //요청인쇄 찾기
            for(int i = 0; i < priorities.length; i++) {
                if(pq.peek() == priorities[i]) {//우선순위가 가장 큰것부터 요청 인쇄 와 비교해서 같으면
                    pq.poll(); //맨 먼저 들어간 수를 뽑는다. 
                    answer++;// 몇번째인쇄되는지 +https://programmers.co.kr/learn/courses/30/parts/12081
                    if (location == i) { //본인 요청 인쇄물 인덱스와, 해당 인덱스가 같으면 종료
                        pq.clear();
                        break;
                    }
                }
            }
            //
        }
 
        return answer;
    }
}