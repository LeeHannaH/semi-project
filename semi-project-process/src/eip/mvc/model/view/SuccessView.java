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
			
			int answer = Integer.parseInt(MainView.prompt("답을 입력해주세요"));
			if(answer == problem.getAnswer()) {
				System.out.println("정답입니다!");
				//정답 따로 저장(유형 및 count +1) => 나중에 result
			} else if(answer == 5 || answer == 6 ) {
				// 이전문제로 넘어가려면... 어떻게해야할까
				break;
			} else {
				System.out.println("오답입니다 오답노트에 저장합니다");
				ErrorVO vo = new ErrorVO();
				vo.setErrorAnswer(answer);
				vo.setId(MainView.user.getId());
				vo.setProblem(problem);
				ErrorController.insertError(vo);
				System.out.println("5번");
				// 아이디 , 문제번호, 작성한 답안, 해설 삽입
				
			}
		}
		System.out.println("문제를 다푸셨습니다\n 1. 결과 보러 가기(채점)\n 2. 오답노트 및 해설보러가기");
	}
	
	public static void messagePrint(String message) {
		System.out.println(message);
	}
}
