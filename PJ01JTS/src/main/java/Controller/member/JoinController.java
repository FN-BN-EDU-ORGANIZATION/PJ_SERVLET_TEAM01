package Controller.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controller.SubController;

public class JoinController implements SubController{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("JoinController execute");

		
		try {
	            req.getRequestDispatcher("/WEB-INF/view/Joinpage.jsp").forward(req, resp);
	        
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

		
	}

}