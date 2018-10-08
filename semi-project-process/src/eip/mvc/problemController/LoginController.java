package eip.mvc.problemController;

import java.sql.SQLException;

import eip.mvc.model.dto.User;
import eip.mvc.model.service.LoginService;
import eip.mvc.model.service.LoginServiceImpl;
import eip.mvc.model.view.SuccessView;

public class LoginController {
	private static LoginService service = new LoginServiceImpl();
	
	public static boolean insertAccount(String id, String pwd) {
		boolean re = false;
		try {
			
			if(service.insertAccount(id, pwd) > 0) {
				re = true;
			SuccessView.messagePrint("가입에 성공했습니다");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return re;
	}
	
	public static User SelectByIdPwd(String id, String pwd) {
		User user = null;
			
			try {
				user = service.selectByIdPwd(id, pwd);
				SuccessView.messagePrint("로그인에 성공하였습니다");
			} catch (Exception e) {
				e.getMessage();
			}
			
		return user;
	}
}
