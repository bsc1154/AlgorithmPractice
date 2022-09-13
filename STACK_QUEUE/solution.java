import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        Queue<Integer> queue = new LinkedList<Integer>();
        ArrayList<Integer> release = new ArrayList<>();     // 배포당 기능 개수
        // 각 기능이 개발되기까지 남은 기간
        for (int i = 0; i < progresses.length; i++) {
            queue.add((int)Math.ceil((double) (100 - progresses[i]) / speeds[i]));
        }

        int front = queue.poll();
        int cnt = 1;

        while(!queue.isEmpty()){
            if(front < queue.peek() ){
                release.add(cnt);
                front = queue.poll();
                cnt=1;
            }else{
                queue.poll();
                cnt++;
            }
        }

        release.add(cnt);

        return release.stream().mapToInt(Integer::intValue).toArray();
    }
}