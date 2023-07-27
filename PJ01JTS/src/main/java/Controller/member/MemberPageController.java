package Controller.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Controller.SubController;

public class MemberPageController implements SubController {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		try {
			HttpSession session = req.getSession();
			String role = (String) session.getAttribute("role");
			if (role.equals("role_u")) {
				req.getRequestDispatcher("/WEB-INF/view/member/user.jsp").forward(req, resp);
			} else if (role.equals("role_m")) {
				req.getRequestDispatcher("WEB-INF/view/member/member.jsp").forward(req, resp);
			}
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
