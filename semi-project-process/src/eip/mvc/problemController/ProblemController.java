package eip.mvc.problemController;

import eip.mvc.model.dto.ProblemVO;
import eip.mvc.model.service.ProblemService;
import eip.mvc.model.service.ProblemServiceImpl;
import eip.mvc.model.view.SuccessView;

public class ProblemController {
	private static ProblemService service = new ProblemServiceImpl();
	
	public static void insertProblem(ProblemVO problem) {
		
		try {
			service.insertProblem(problem);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void selectAll() {
		try {
			SuccessView.selectPrint(service.selectAll());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
