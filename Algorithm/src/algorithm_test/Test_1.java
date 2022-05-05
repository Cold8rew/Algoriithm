package algorithm_test;

public class Test_1 {
	// 신규 유저가 입력한 아이디를 나타내는 new_id가 매개변수로 주어질 때, 
	// "네오"가 설계한 7단계의 처리 과정을 거친 후의 추천 아이디를 return 하도록 solution 함수를 완성해 주세요.
	/*
	1단계 new_id의 모든 대문자를 대응되는 소문자로 치환합니다.
	2단계 new_id에서 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거합니다.
	3단계 new_id에서 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.
	4단계 new_id에서 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
	5단계 new_id가 빈 문자열이라면, new_id에 "a"를 대입합니다.
	6단계 new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
	     만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.
	7단계 new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.
	*/
	public static void main(String[] args) {
		String s = ID("...!@BaT#*..y.abcdefghijklm");
		System.out.println(s);
	}
	public static String ID(String new_id) {
		String s = new KAKAOID(new_id)
				.ReplaceToLowerCase()
				.filter()
				.ToSingleDot()
				.StartOREnd()
				.noEmpty()
				.LimitMax()
				.LimitMin()
				.getResult();
				
		return s;
	}
	
	private static class KAKAOID {
		private String s;
		
		KAKAOID(String s) {
			this.s = s;
		}
		
		private KAKAOID ReplaceToLowerCase() {
			s = s.toLowerCase();
			return this;
		}
		
		private KAKAOID filter() {
			s = s.replaceAll("[^-_.0-9a-z]", "");
			return this;
		}
		
		private KAKAOID ToSingleDot() {
			s = s.replaceAll("[.]{2,}", ".");
			return this;
		}
		
		private KAKAOID StartOREnd() {
			s = s.replaceAll("^[.]|[.]$", "");
			return this;
		}
		
		private KAKAOID noEmpty() {
			if (s.isEmpty()) {
				s = "a";
			}
			return this;
		}
		
		private KAKAOID LimitMax() {
			if (s.length() > 15) {
				s = s.substring(0, 15);
			}
			s = s.replaceAll("^[.]|[.]$", "");

			return this;
		}
		
		private KAKAOID LimitMin() {
			if (s.length() < 3) {
				while (s.length() < 3) {
					s += s.charAt(s.length()-1);
				}
			}
			s = s.toString();
			return this;
		}
		
		private String getResult() {
			return s;
		}
		
	}
	
}
		/*public static String solution(String new_id) {
	        String answer = "";
	        String id = new_id.toLowerCase();
	        id = id.replaceAll("[^-_.a-z0-9]", "");
	        id = id.replaceAll("[.]{2,}", ".");
	        id = id.replaceAll("^[.]|[.]$","");
	        
	        if (id.isEmpty()) {
	        	id="a";
	        }
	        if (id.length()>=16) {
	        	id=id.substring(0, 15);
	        	id=id.replaceAll("^[.]|[.]$","");
	        }
	        if (id.length()<=2) {
	        	while (id.length()<3) {
	        		id+=id.charAt(id.length()-1);
	        	}
	        }
	        System.out.println(id);

	        return answer;
	    }*/
