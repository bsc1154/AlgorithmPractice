class Solution {
    static final String MAPPING = "AEIOU";
    static final int[] RATE_OF_INCREASE = {781, 156, 31, 6, 1};
    
    public int solution(String word) {
        int answer = word.length();
        
        for(int i=0;i<word.length();i++){
            //증가율과 * 각자리의 모음의 인덱스(대치된 값)
            answer+=RATE_OF_INCREASE[i] * MAPPING.indexOf(word.charAt(i));
        }
        return answer;
    }
}