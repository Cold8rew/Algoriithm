package algorithm_test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
수포자는 수학을 포기한 사람의 준말입니다. 수포자 삼인방은 모의고사에 수학 문제를 전부 찍으려 합니다. 
수포자는 1번 문제부터 마지막 문제까지 다음과 같이 찍습니다.

1번 수포자가 찍는 방식: 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, ...
2번 수포자가 찍는 방식: 2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5, ...
3번 수포자가 찍는 방식: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, ...

1번 문제부터 마지막 문제까지의 정답이 순서대로 들은 배열 answers가 주어졌을 때, 
가장 많은 문제를 맞힌 사람이 누구인지 배열에 담아 return 하도록 solution 함수를 작성해주세요.

*/
public class Test_13 {

	public static void main(String[] args) {
		int[] a = {1,2,3,4,5};
		solution(a);
	}
	
	public static int[] solution(int[] answers) {
        int[] a = {1, 2, 3, 4, 5};
        int[] b = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] c = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int[] cnt = new int[3];
        
        // 정답 맞춘 카운트 구하기
        for (int i=0; i<answers.length; i++) {
        		if (answers[i] == a[i%a.length]) {cnt[0]++;}
        		if (answers[i] == b[i%b.length]) {cnt[1]++;}
        		if (answers[i] == c[i%c.length]) {cnt[2]++;}
        }
        
        // 가장 많이 맞춘 사람 구하기
        int max = Math.max(cnt[0], Math.max(cnt[1], cnt[2]));
        List<Integer> list = new ArrayList<Integer>();
        // 가장 많이 맞춘 사람만 list에 모두 넣기
        for (int j=0; j<cnt.length; j++) 
        	if (max == cnt[j]) {list.add(j+1);}
        
        // list에 들어간 사람이 누구인지 구하기
        int bunho = 0;
        int[] answer = new int[list.size()];
        for (int num : list) {
        	answer[bunho] = num;
        	bunho++;
        }
        System.out.println(Arrays.toString(answer));
        
        return answer;
    }

}
