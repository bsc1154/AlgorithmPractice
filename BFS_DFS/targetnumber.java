class Solution {
    int answer = 0;
    public int solution(int[] numbers, int target) {
        dfs(numbers,target,0,0);
        return answer;
    }
    
    public void dfs(int[] numbers, int target, int depth, int sum){
        if(numbers.length == depth){//비교할 배열의 길이와 깊이가 끝까지 갔을때
            if(target == sum){
               answer++; 
            }
        }else{
            dfs(numbers, target, depth+1, sum+numbers[depth]);
            dfs(numbers, target, depth+1, sum-numbers[depth]);
        }
    }
}