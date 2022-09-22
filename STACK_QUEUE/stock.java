class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        //해당 배열의 길이만큼 답안 배열 크기 초기화 i는 현재수, j는 다음수 비교
        for (int i = 0; i < answer.length; i++) { 
            for (int j = i+1; j < answer.length; j++) {//해당 수가 몇초동안 값이 증가했는지 비교하기위해 각 값마다 반복
                if (prices[i] > prices[j]) {//현재수가 더큰경우가 나오면 
                    answer[i] = j-i;// i =1    j가 3이면 3-1 ==2 2초동안 오름 (증가되던 위치에서 현재 위치를 빼면)
                    break;//속 반복문 탈출
                }
                if (j==answer.length-1) answer[i] = j-i; //다음 비교할 대상인 j가 끝까지 가면 
                //+1했으므로 -1에서 비교해줘야함.
            }
        }
        return answer;
    }
}