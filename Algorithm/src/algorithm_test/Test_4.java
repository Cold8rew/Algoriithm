package algorithm_test;

public class Test_4 {
	/*
	 * 엄지손가락은 상하좌우 4가지 방향으로만 이동할 수 있으며 키패드 이동 한 칸은 거리로 1에 해당합니다. 왼쪽 열의 3개의 숫자 1, 4,
	 * 7을 입력할 때는 왼손 엄지손가락을 사용합니다. 오른쪽 열의 3개의 숫자 3, 6, 9를 입력할 때는 오른손 엄지손가락을 사용합니다.
	 * 가운데 열의 4개의 숫자 2, 5, 8, 0을 입력할 때는 두 엄지손가락의 현재 키패드의 위치에서 더 가까운 엄지손가락을 사용합니다.
	 * 4-1. 만약 두 엄지손가락의 거리가 같다면, 오른손잡이는 오른손 엄지손가락, 왼손잡이는 왼손 엄지손가락을 사용합니다. 순서대로 누를
	 * 번호가 담긴 배열 numbers, 왼손잡이인지 오른손잡이인 지를 나타내는 문자열 hand가 매개변수로 주어질 때, 각 번호를 누른
	 * 엄지손가락이 왼손인 지 오른손인 지를 나타내는 연속된 문자열 형태로 return 하도록 solution 함수를 완성해주세요.
	 * 
	 * [제한사항] numbers 배열의 크기는 1 이상 1,000 이하입니다. numbers 배열 원소의 값은 0 이상 9 이하인 정수입니다.
	 * hand는 "left" 또는 "right" 입니다. "left"는 왼손잡이, "right"는 오른손잡이를 의미합니다. 왼손 엄지손가락을
	 * 사용한 경우는 L, 오른손 엄지손가락을 사용한 경우는 R을 순서대로 이어붙여 문자열 형태로 return 해주세요.
	 */
	public static void main(String[] args) {
		int[] n = {7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2};
		String h = "left";
		String s = solution(n, h);
		
		System.out.println(s);
	}
	// 숫자별 x,y 좌표
	static int[][] numpad = {
			{3,1}, // 0
			{0,0}, // 1
			{0,1}, // 2
			{0,2}, // 3
			{1,0}, // 4
			{1,1}, // 5
			{1,2}, // 6
			{2,0}, // 7
			{2,1}, // 8
			{2,2}, // 9
	};
	
	static String hands;
	
	 // 초기 손위치
	static int[] leftpos = {3,0};
	static int[] rightpos = {3,2};
	public static String solution(int[] numbers, String hand) {
		hands = (hand.equals("left")) ? "L" : "R"; 
        String answer = "";
		for (int num : numbers) {
			String LORR = pushNumber(num);
			answer += LORR;
			
			if (LORR.equals("L")) 
				leftpos = numpad[num];
			if (LORR.equals("R")) 
				rightpos = numpad[num];
		}
		
        return answer;
    }
	
	private static String pushNumber(int num) {
		// 1, 4, 7 은 왼손으로 , 3, 6, 9 는 오른손
		switch (num) {
			case 1 : case 4 : case 7 :
				return "L";
			case 3 : case 6 : case 9 :
				return "R";
		}
		
		// 2, 5, 8, 0 일 경우
		if (getButton(leftpos, num) < getButton(rightpos, num))  return "L";
		if (getButton(leftpos, num) > getButton(rightpos, num))  return "R";
		// 거리가 같을 경우
		return hands;
	}
	
	private static int getButton(int[] pos, int num) {
		return Math.abs(pos[0] - numpad[num][0]) + Math.abs(pos[1] - numpad[num][1]);
	}

}
