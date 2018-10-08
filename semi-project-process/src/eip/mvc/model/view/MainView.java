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
		//�α��� ����
		//ȸ�������� ���̵�/�н�����
		//LoginController.insertAccount(id,pwd);
		
		while(log_flag!=1) {
			System.out.println("-------------- �ȳ�? ------------------");
			System.out.println("1. ȸ������  2. �α���");
			int menu_first = Integer.parseInt(sc.nextLine());
			
			switch(menu_first) {
			case 1 : //�ߺ��ȵǴ°� ����
				create_account();
				break;
			case 2:
				login_account();
				break;
			}
		}
		
		
		while(true) {
			System.out.println("------------------- ���� -------------------");
			System.out.println("1. ������� 2. ����Ǯ�� 3. ���������� Ǯ��, 4. ���������ϱ�, 5. ��������, 6. ������");
			int menu = Integer.parseInt(sc.nextLine());

			switch(menu) { 
			// ��Ʈ�ѷ����� ��û
			case 1:ProblemController.selectAll(); break;//ProblemController.insert()/ selectAll() �̷�������
			case 2: break;
			case 3: break;
			case 4: break;
			case 5: break;
			case 6: 
				System.out.println("���α׷� ����");
				System.exit(0);
			}// switch
		}// while
	}
	
	// @param "����"
	// @return String (����ڰ� �Է��� �� sc.nextline())
	// �޼���� : prompt 
	// id = prompt("ȸ�������� ID�� �Է��ϼ���");
	public static String prompt(String str) {
		System.out.print(str);
		sc = new Scanner(System.in);
		return sc.nextLine();
	}
	
	public static void create_account() {
		String id = prompt("* ȸ�������� ID�� �Է��ϼ��� : ");
		String pwd = prompt("* ���ο� Password�� �Է��ϼ��� : ");
	}
	
	public static void login_account() {
		String log_id = prompt("* ID�� �Է��ϼ��� : ");
		String log_pwd = prompt("* Password�� �Է��ϼ��� : ");
		
		user = LoginController.SelectByIdPwd(log_id, log_pwd);
		
		if(user != null) {
		System.out.println(user);//�α����� �������� �� ����ó�� �� �Ǿ� �ִµ�
		log_flag = 1;
		}else {
			System.out.println("����");
		}
	}
}







