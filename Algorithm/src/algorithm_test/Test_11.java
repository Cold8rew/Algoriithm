package algorithm_test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Test_11 {
	/*
	 * 수많은 마라톤 선수들이 마라톤에 참여하였습니다. 단 한 명의 선수를 제외하고는 모든 선수가 마라톤을 완주하였습니다.
	 * 
	 * 마라톤에 참여한 선수들의 이름이 담긴 배열 participant와 완주한 선수들의 이름이 담긴 배열 completion이 주어질 때,
	 * 완주하지 못한 선수의 이름을 return 하도록 solution 함수를 작성해주세요.
	 * 
	 * 제한사항 마라톤 경기에 참여한 선수의 수는 1명 이상 100,000명 이하입니다. completion의 길이는 participant의
	 * 길이보다 1 작습니다. 참가자의 이름은 1개 이상 20개 이하의 알파벳 소문자로 이루어져 있습니다. 참가자 중에는 동명이인이 있을 수
	 * 있습니다.
	 */
	public static void main(String[] args) {

		String[] p = {"mislav", "stanko", "mislav", "ana"};
		String[] c = {"stanko", "ana", "mislav"};
		String s = solution(p, c);
		System.out.println(s);
	}
	
	public static String solution(String[] participant, String[] completion) {
        String answer = "";
        
        Map<String, Integer> map = new HashMap<>();
        // 중복 확인( 동명이인이 있을 경우 value = 2)
        for (String player : participant) {
        	map.put(player, map.getOrDefault(player, 0) +1);
        }
        // 완주자 목록에 있으면 value를 -1, 완주자들은 value가 0이 됨으로 완주 못한 사람은 1
        for (String player : completion) {
        	map.put(player, map.get(player) -1);
        }
        // 완주 못한 사람은 value가 1 이므로 answer에 key 값을 담는다
        for (String key : map.keySet()) {
        	if (map.get(key) == 1) { 
        		answer = key;
        		break;
        	}
        }
        
        // 다른 풀이 방법 (Arrays.sort를 이용해 정렬하고 이름이 다르다면 그 사람이 완주 못한 사람)
		/*
		 * Arrays.sort(participant); Arrays.sort(completion);
		 * 
		 * for (int i=0; i<completion.length; i++) { if
		 * (!participant[i].equals(completion[i])) { answer = participant[i]; break; } }
		 */
        return answer;
    }

}
