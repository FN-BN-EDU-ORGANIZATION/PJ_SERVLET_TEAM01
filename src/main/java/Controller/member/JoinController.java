package Controller.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Controller.SubController;

public class JoinController implements SubController{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		
		
		try {
	        HttpSession session = req.getSession();
	        String role = (String) session.getAttribute("ROLE");

	        // ROLE 값이 null이거나 없는 경우, join.jsp로 포워딩
	        if (role == null || role.isEmpty()) {
	            req.getRequestDispatcher("/WEB-INF/view/member/join.jsp").forward(req, resp);
	        } 
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

		
	}

}
