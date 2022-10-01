import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        Queue<Integer> queue = new LinkedList<Integer>();
        ArrayList<Integer> release = new ArrayList<Integer>();
        for(int i=0;i<progresses.length;i++){
            queue.add((int)Math.ceil((double)(100-progresses[i])/speeds[i]));    
        }
        int cnt = 1;
        int front = queue.poll();
        
        while(!queue.isEmpty()){
            if(front < queue.peek()){//뒤에께 작업시간이 더 길면 현재 cnt는 넣어줌.
                release.add(cnt);
                front = queue.poll();
                cnt = 1;//작업이 같이 배포될경우 카운트가 늘어난 상태이므로 다시 초기화 해줘야함.
            }else{
                queue.poll();
                cnt++;
            }
        }
        
        release.add(cnt);
        return release.stream().mapToInt(Integer::intValue).toArray();
    }
}
