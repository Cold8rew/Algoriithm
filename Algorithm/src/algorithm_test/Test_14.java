package algorithm_test;

import java.util.HashSet;

/*
점심시간에 도둑이 들어, 일부 학생이 체육복을 도난당했습니다. 
다행히 여벌 체육복이 있는 학생이 이들에게 체육복을 빌려주려 합니다. 
학생들의 번호는 체격 순으로 매겨져 있어, 바로 앞번호의 학생이나 바로 뒷번호의 학생에게만 체육복을 빌려줄 수 있습니다. 
예를 들어, 4번 학생은 3번 학생이나 5번 학생에게만 체육복을 빌려줄 수 있습니다. 
체육복이 없으면 수업을 들을 수 없기 때문에 체육복을 적절히 빌려 최대한 많은 학생이 체육수업을 들어야 합니다.

전체 학생의 수 n, 체육복을 도난당한 학생들의 번호가 담긴 배열 lost, 
여벌의 체육복을 가져온 학생들의 번호가 담긴 배열 reserve가 매개변수로 주어질 때, 
체육수업을 들을 수 있는 학생의 최댓값을 return 하도록 solution 함수를 작성해주세요.

제한사항
전체 학생의 수는 2명 이상 30명 이하입니다.
체육복을 도난당한 학생의 수는 1명 이상 n명 이하이고 중복되는 번호는 없습니다.
여벌의 체육복을 가져온 학생의 수는 1명 이상 n명 이하이고 중복되는 번호는 없습니다.
여벌 체육복이 있는 학생만 다른 학생에게 체육복을 빌려줄 수 있습니다.
여벌 체육복을 가져온 학생이 체육복을 도난당했을 수 있습니다. 
이때 이 학생은 체육복을 하나만 도난당했다고 가정하며, 
남은 체육복이 하나이기에 다른 학생에게는 체육복을 빌려줄 수 없습니다.

*/
public class Test_14 {

	public static void main(String[] args) {
		int[] l = {1, 2};
		int[] r = {2, 3};
		int n = 5;

		solution(n, l, r);
	}
	
	public static int solution(int n, int[] lost, int[] reserve) {
        int answer = n;
        int[] hm = new int[n];
        // lost는 -1 , reserve 는 +1로 배열에 넣기
        for (int l : lost) 
        	hm[l-1]--;
        for (int r : reserve) 
        	hm[r-1]++;
        
        for (int i=0; i<hm.length; i++) {
        	// list에 -1인 학생만, 앞뒤에 값이 1인 경우 lost는 +1, reserve는 -1
        	// 없는 경우에 전체학생 수에서 -1
        	if (hm[i] == -1) {
	        	if (i-1>=0 && hm[i-1] == 1) {
	        		hm[i]++;
	        		hm[i-1]--;
	        	} else if (i+1<hm.length && hm[i+1] == 1) {
	        		hm[i]++;
	        		hm[i+1]--;
	        	} else {
	        		answer--;
	        	}
        	}
        }
        System.out.println(answer);
        
        return answer;
    }

	
	/*
	 * public static int solution(int n, int[] lost, int[] reserve) { int
	 * answer=n-lost.length;
	 * 
	 * HashSet<Integer> hash = new HashSet<Integer>(); for (int r : reserve) {
	 * hash.add(r); }
	 * 
	 * for (int i=0; i<lost.length; i++) { if (hash.contains(lost[i])) {
	 * hash.remove(lost[i]); answer++; lost[i] = -1; } }
	 * 
	 * for (int j=0; j<lost.length; j++) { if (hash.contains(lost[j]-1)) {
	 * hash.remove(lost[j]-1); answer++; } else if (hash.contains(lost[j]+1)) {
	 * hash.remove(lost[j]+1); answer++; } } System.out.println(answer); return
	 * answer; }
	 */
}
