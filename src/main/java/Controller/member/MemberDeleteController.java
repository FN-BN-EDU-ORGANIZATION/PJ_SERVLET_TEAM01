package Controller.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Controller.SubController;
import Domain1.Dao.MemberDao;
import Domain1.Dao.MemberDaoImpl;
import Domain1.Service.MemberService;
import Domain1.Service.MemberServiceImpl;

public class MemberDeleteController implements SubController{

	private MemberService service = MemberServiceImpl.getInstance();

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("MemberDeleteController execute!");
		
		try {
			String Id = req.getParameter("id");
			MemberDao memberDao = MemberDaoImpl.getInstance();
			int result = memberDao.delete(Id);
			
			if(result>0) {
				HttpSession session = req.getSession();
				session.setAttribute("deleteMessage", "아웃!!");
				System.out.println("아웃");
				resp.sendRedirect(req.getContextPath()+"/mypage.do");
			}else {
				System.out.println("실패다...");
				resp.sendRedirect(req.getContextPath()+"/mypage.do");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
