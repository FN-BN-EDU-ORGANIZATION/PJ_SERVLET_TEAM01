package Controller.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Controller.SubController;
import Domain1.Dao.MemberDao;
import Domain1.Dao.MemberDaoImpl;
import Domain1.Dto.MemberDto;

public class MemberSearchController implements SubController {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("MemberSearchController execute!");
		
		try {
		    String id = req.getParameter("id");
		    MemberDao memberDao = MemberDaoImpl.getInstance();
		    MemberDto result = memberDao.select(id);
		    
		    if (result != null) {
//		    	System.out.println("검색완료 ID : "+ result);
		        HttpSession session = req.getSession();
		        session.setAttribute("selectedMember", result);
		        System.out.println("검색완료 ID : "+ result);
		        resp.sendRedirect(req.getContextPath() + "/mypage.do");
		    } else {
		        System.out.println("회원을 찾을 수 없습니다.");
		        resp.sendRedirect(req.getContextPath() + "/mypage.do");
		    }
		} catch (Exception e) {
		    e.printStackTrace();
		}
		
		
	}
}