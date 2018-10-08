package eip.mvc.model.view;

import java.util.Iterator;
import java.util.List;

import eip.mvc.model.dto.ErrorVO;
import eip.mvc.model.dto.ProblemVO;
import eip.mvc.problemController.ErrorController;

public class SuccessView {
	
	public static void selectPrint(List<ProblemVO> list) {
		Iterator<ProblemVO> iter = list.iterator();
				
		while(iter.hasNext()) {
			ProblemVO problem = iter.next();
			System.out.println(problem.getProblem());
			
			int answer = Integer.parseInt(MainView.prompt("���� �Է����ּ���"));
			if(answer == problem.getAnswer()) {
				System.out.println("�����Դϴ�!");
				//���� ���� ����(���� �� count +1) => ���߿� result
			} else if(answer == 5 || answer == 6 ) {
				// ���������� �Ѿ����... ����ؾ��ұ�
				break;
			} else {
				System.out.println("�����Դϴ� �����Ʈ�� �����մϴ�");
				ErrorVO vo = new ErrorVO();
				vo.setErrorAnswer(answer);
				vo.setId(MainView.user.getId());
				vo.setProblem(problem);
				ErrorController.insertError(vo);
				System.out.println("5��");
				// ���̵� , ������ȣ, �ۼ��� ���, �ؼ� ����
				
			}
		}
		System.out.println("������ ��Ǫ�̽��ϴ�\n 1. ��� ���� ����(ä��)\n 2. �����Ʈ �� �ؼ���������");
	}
	
	public static void messagePrint(String message) {
		System.out.println(message);
	}
}
