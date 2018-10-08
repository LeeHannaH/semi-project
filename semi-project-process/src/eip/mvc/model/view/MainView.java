package eip.mvc.model.view;

import java.util.Scanner;

import eip.mvc.model.dto.User;
import eip.mvc.problemController.LoginController;
import eip.mvc.problemController.ProblemController;

public class MainView {
	static Scanner sc = new Scanner(System.in);
	static User user = null;
	static int log_flag = 0;
	//MainView.user 
	public static void main(String[] args) {
		//로그인 구현
		//회원가입한 아이디/패스워드
		//LoginController.insertAccount(id,pwd);
		
		while(log_flag!=1) {
			System.out.println("-------------- 안녕? ------------------");
			System.out.println("1. 회원가입  2. 로그인");
			int menu_first = Integer.parseInt(sc.nextLine());
			
			switch(menu_first) {
			case 1 : //중복안되는건 아직
				create_account();
				break;
			case 2:
				login_account();
				break;
			}
		}
		
		
		while(true) {
			System.out.println("------------------- 선택 -------------------");
			System.out.println("1. 문제등록 2. 문제풀기 3. 문제유형별 풀기, 4. 문제삭제하기, 5. 공지사항, 6. 나가기");
			int menu = Integer.parseInt(sc.nextLine());

			switch(menu) { 
			// 컨트롤러에게 요청
			case 1:ProblemController.selectAll(); break;//ProblemController.insert()/ selectAll() 이런식으로
			case 2: break;
			case 3: break;
			case 4: break;
			case 5: break;
			case 6: 
				System.out.println("프로그램 종료");
				System.exit(0);
			}// switch
		}// while
	}
	
	// @param "문자"
	// @return String (사용자가 입력한 값 sc.nextline())
	// 메서드명 : prompt 
	// id = prompt("회원가입할 ID를 입력하세요");
	public static String prompt(String str) {
		System.out.print(str);
		sc = new Scanner(System.in);
		return sc.nextLine();
	}
	
	public static void create_account() {
		String id = prompt("* 회원가입할 ID를 입력하세요 : ");
		String pwd = prompt("* 새로운 Password를 입력하세요 : ");
	}
	
	public static void login_account() {
		String log_id = prompt("* ID를 입력하세요 : ");
		String log_pwd = prompt("* Password를 입력하세요 : ");
		
		user = LoginController.SelectByIdPwd(log_id, log_pwd);
		
		if(user != null) {
		System.out.println(user);//로그인이 실패했을 때 예외처리 안 되어 있는듯
		log_flag = 1;
		}else {
			System.out.println("실패");
		}
	}
}







