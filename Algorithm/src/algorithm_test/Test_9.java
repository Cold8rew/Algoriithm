package algorithm_test;

public class Test_9 {
	/*
	 * 2명 이상의 심사위원들에게 F를 받은 지원자는 불합격 처리합니다. 1번 조건에 해당하지 않고, 2명 이상의 심사위원들에게 A를 받은
	 * 지원자는 합격 처리합니다. 1, 2번 조건에 해당하지 않는 지원자들에 대해서는 다음과 같이 합격 여부를 결정합니다. 
	 * A=5점, B=4점,C=3점, D=2점, E=1점, F=0점으로 점수를 환산했을 때, 최저점과 최고점을 하나씩 제외한 나머지 점수의 평균이 3점 이상이면
	 * 합격, 3점 미만이면 불합격 처리합니다.
	 */
	public static void main(String[] args) {
		String[] r = {"BCD","ABB","FEE"};
		int s = solution(r);
		System.out.println(s);
	}
	
	public static int solution(String[] scores) {
        int answer = 0;
        long total = 0;
        int A_num = 0;
        int F_num = 0;
        
        for (String score : scores) {
        	String[] rank = score.split("");
        	A_num = score.length() - score.replace("A", "").length();
        	F_num = score.length() - score.replace("F", "").length();
        	
	        for (int j=0; j<rank.length; j++) {
		        switch (rank[j]) {
				case "A":
					total += 5;
					break;
				case "B":
					total += 4;
					break;
				case "C":
					total += 3;
					break;
				case "D":
					total += 2;
					break;
				case "E":
					total += 1;
					break;
				default:
					break;
				}
	        }
	        if ((Math.ceil(total/rank.length)>2 || A_num>=2) && F_num<2) 
	        	answer++;
        }
        return answer;
    }
}
