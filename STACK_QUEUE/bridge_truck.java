package test;

import java.util.LinkedList;
import java.util.Queue;

public class tets2 {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> queue = new LinkedList<>();
        //큐는 다리위에 있는 트럭수
        //sum은 트럭의 무게
        //다리에 오를때만 시간 추가
        //다리길이만큼 큐가 안차면 -> 무게를 넘지않는 선에서 트럭을 다리위에 올림
        //
        int sum = 0;
        int time = 0;

        for(int i = 0; i < truck_weights.length; i++) { // 향상된 for문을 쓰는게 좋을 것
            int truck = truck_weights[i];

            while(true) {
                // 큐에 아무것도 없는 경우 = 어떠한 트럭도 다리위에 없음
                if(queue.isEmpty()) {
                    queue.add(truck);
                    sum += truck;
                    time++; // 다리에 오를 때만 시간 추가
                    break;
                } else if(queue.size() == bridge_length) { // 큐에 다리 길이만큼 트럭이 다 찬 경우
                    sum -= queue.poll();
                } else  { // 다리 길이만큼 큐가 차지않았음
                    // weight 값을 넘지 않는 선에서 새로운 트럭을 다리에 올려줌
                    if(sum + truck <= weight) {
                        queue.add(truck);
                        sum += truck;
                        time++;
                        break;
                    } else {
                        // 넘는다면 0을 넣어 이미 큐에 있는 트럭이 다리를 건너게 만듬
                        queue.add(0);
                        time++;
                    }
                }
            }
        }

        // 마지막 트럭에서 반복문이 끝나는데, 마지막 역시 다리 길이만큼 지나가야하기에 + 다리 길이
        return time + bridge_length;
    }
}
