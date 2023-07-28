package Controller.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Controller.SubController;

public class JoinController implements SubController{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		
		
		try {
	        

	            req.getRequestDispatcher("/WEB-INF/view/member/join.jsp").forward(req, resp);
	        
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

		
	}

}
