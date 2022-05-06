package algorithm_test;

public class Test_6 {
	/*
	 * 0부터 9까지의 숫자 중 일부가 들어있는 정수 배열 numbers가 매개변수로 주어집니다. numbers에서 찾을 수 없는 0부터 9까지의
	 * 숫자를 모두 찾아 더한 수를 return 하도록 solution 함수를 완성해주세요.
	 * 
	 * 제한사항 1 ≤ numbers의 길이 ≤ 9 0 ≤ numbers의 모든 원소 ≤ 9 numbers의 모든 원소는 서로 다릅니다.
	 */
	public static void main(String[] args) {
		int[] n = {1,2,3,4,6,7,8,0};
		int s = solution(n);
		
		System.out.println(s);
	}
	public static int solution(int[] numbers) {
        int answer = 0;
        int[] nums = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        for (int num : numbers) {
	        for (int i=0; i<nums.length; i++) {
	        	if (nums[i]==num) {
	        		nums[i] = 0;
	        	}
	        }
        }
        for (int N_num : nums) {
        	answer += N_num;
        }
        return answer;
    }

}
