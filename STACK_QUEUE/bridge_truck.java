import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        //럭들을 순차적으로 비교하고 처리하기 위해 선입선출 구조를 가진 큐를 이용하고 다리위에 올라가있는 트럭들의 무게의 합을 저장할 변수를 선언
        int answer = 0;
        int sum = 0;//현재지나고있는 트럭의 무게 다리최대 하중을 비교하기 위해 넣는다.
	    Queue<Integer> q = new LinkedList<Integer>();
        
        for(int t : truck_weights){
            while(true){
                //지나고 있는 트럭이 없으면
                if(q.isEmpty()){
                    q.offer(t);//지나는 트럭 추가
					sum += t;
					answer++;
					break;
                    //지나고있는 트럭수가 다리에서 수용할수있는 최대 맥스이면...
                }else if(bridge_length == q.size()){
                    sum -= q.poll();//맨 앞트럭 의 무게를 뺀다.
                }else{
                    if(sum + t > weight){//최대무게보다 현재 지나려는 무게가 더 크면 한타임 건너뛴다.
                        q.offer(0);
						answer++;
                    }else{
                        q.offer(t);
						sum += t;
						answer++;
						break;
                    }
                }
            }
        }
        //이렇게 반복을 진행하면 마지막 트럭이 다리에 올라간 시점에 반복문이 종료되게 되는데 지금까지 걸린 시간에서 마지막 트럭통과하는 시간, 즉 다리의 길이만큼을 더해주면 모든 트럭이 다리를 건너는 총 시간이 된다
        return answer + bridge_length;
    }
}
